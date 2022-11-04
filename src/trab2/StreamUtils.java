package trab2;

import java.io.*;
import java.util.Objects;
import java.util.function.*;

public class StreamUtils {

    public static boolean validate( Reader in ) throws IOException {
        int counter = 0, c;
        while ((c = in.read()) != -1) {
            if (c == '{') counter++;
            else if ((char)c == '}') {
                counter--;
                if (counter < 0)
                    return false;
            }
        }
        return counter == 0;
    }

    public static void copyCom( BufferedReader in, PrintWriter out ) throws IOException {
        String s;
        int line = 1, index;
        while ((s = in.readLine()) != null) {
            if ((index = s.indexOf("//")) != -1)
                out.println(line + " " + s.substring(index));

            line++;
        }
    }

    public static <T> void mapper( BufferedReader in,
                     Function<String, T> mapping,
                     BiConsumer<String, T> action ) throws IOException {
        String s;
        while ((s = in.readLine()) != null)
            action.accept(s, mapping.apply(s));
    }

    public static Integer evaluate(String expression) {
        if (!expression.endsWith("=")) return null;

        int res = 0;
        try {
            String exp = expression.trim();
            res = Integer.parseInt(exp.substring(0, 1));
            exp = exp.substring(1);

            while (exp.length() > 0) {
                if (exp.charAt(0) == '=') break;
                switch (exp.charAt(0)) {
                    case '+' -> res += Integer.parseInt(exp.substring(1, 2));
                    case '-' -> res -= Integer.parseInt(exp.substring(1, 2));
                    default -> throw new Exception();
                }
                exp = exp.substring(2);
            }
        }
        catch (Exception e) {
            return null;
        }
        return res;

        /*if ((index = expression.indexOf(" ")) != -1) {
            try {
                return Integer.parseInt(expression);
            }
            catch (Exception e) {
                return null;
            }
        }

        res = Integer.parseInt(expression.substring(0, index));


        return res;*/
    }


    public static void main(String[] args) throws IOException {
        //System.out.println("Escreva texto: ");
        //System.out.println(validate(new InputStreamReader(System.in)) +"\n\n\n");
        //copyCom(new BufferedReader(new StringReader("// um comentario\n System.out.println(); // outro comentario\n\n\n /* terceiro\n\ncomentario*/ \n // comentario extra")), new PrintWriter(System.out, true));
        System.out.println(evaluate("6+5="));
    }
}