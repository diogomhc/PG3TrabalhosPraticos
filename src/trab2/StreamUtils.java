package trab2;

import java.io.*;
import java.util.Scanner;

public class StreamUtils {

    public static boolean validate( Reader in ) throws IOException {
        int counter = 0, c;
        while ((c = in.read()) != -1) {
            if ((char)c == '{') counter++;
            else if ((char)c == '}') {
                counter--;
                if (counter < 0)
                    return false;
            }
        }
        return counter == 0;
    }

    public static void copyCom( BufferedReader in, PrintWriter out ) throws IOException {
        String s = "";
        int line = 1, index = 0;
        while ((s = in.readLine()) != null) {
            if ((index = s.indexOf("//")) != -1)
                out.println(line + ' ' + s.substring(index));

            line++;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Escreva texto: ");
        System.out.println(validate(new InputStreamReader(System.in)) +"\n\n\n");
        //copyCom(new BufferedReader(new StringReader("// um comentario\n System.out.println(); // outro comentario\n\n\n /* terceiro\n\ncomentario*/ \n // comentario extra")), new PrintWriter());
    }
}