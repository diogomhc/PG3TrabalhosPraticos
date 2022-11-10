package trab2.grupo1;

import java.io.*;
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

    public static <T> void mapper( BufferedReader in, Function<String, T> mapping, BiConsumer<String, T> action ) throws IOException {
        String s;
        while ((s = in.readLine()) != null)
            action.accept(s, mapping.apply(s));
    }

    public static Integer evaluate(String expression) {
        if (!expression.endsWith("=") || expression.length() % 2 == 1) return null;

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
    }

    public static void evaluate(String filenameIn, BiConsumer<String,Integer> action) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filenameIn))) {
            mapper(br, StreamUtils::evaluate, action);
        }
    }

    public static void copyEvaluate(String filenameIn, String filenameOut) throws IOException {
        try (PrintWriter pw = new PrintWriter(filenameOut)) {
            evaluate(filenameIn, (s, i) -> pw.println(s + (i == null ? " ERROR" : i)));
        }
    }

    public static void copyEvaluate(BufferedReader in, Writer out) throws IOException {
        mapper(in, StreamUtils::evaluate, (s, i) -> {
            try {
                out.write(s + (i == null ? " ERROR" : i));
            }
            catch (IOException ioe) {
                throw new RuntimeException(ioe.getMessage());
            }
        });
    }

    public static String stringEvaluate( String expression ) {
        StringWriter sw = new StringWriter();
        try {
            copyEvaluate(new BufferedReader(new StringReader(expression)), sw);
            return sw.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}