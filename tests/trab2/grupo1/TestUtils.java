package trab2.grupo1;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static trab2.grupo1.StreamUtils.*;

public class TestUtils {

    @Test
    public void TestExpression() {
        String expression = "";
        assertNull(evaluate(expression));

        expression = "4";
        assertNull(evaluate(expression));

        expression += '=';
        assertEquals(4, evaluate(expression));

        expression = "6+5=";
        assertEquals(11, evaluate(expression));

        expression = '1' + expression;
        assertNull(evaluate(expression));

        expression = "6*5=";
        assertNull(evaluate(expression));
    }

    @Test
    public void TestCopyCom() {
        String code = "package test;\n\n" +
                      "// classe de teste\n" +
                      "public class Test {\n\n" +
                      "/* método\n" +
                      "* principal */\n" +
                      "    public static void main(String[] args) {\n" +
                      "        String text = \"this is a test string // and this is a test comment\";\n\n" +
                      "        // envia o texto para o ecrã\n" +
                      "        System.out.println(text);\n" +
                      "    }\n" +
                      "}", expected = "3 // classe de teste\n11 // envia o texto para o ecrã\n";

        assertDoesNotThrow(() -> copyCom(new BufferedReader(new StringReader(code)), new PrintWriter(System.out)));

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            copyCom(new BufferedReader(new StringReader(code)), new PrintWriter(baos));

            assertEquals(expected, baos.toString());

        }
        catch (Exception ignored) {

        }
    }

    @Test
    public void TestStringExpression() {
        String test = "6+5\n9+6=\n4=\n23*5=\n4*8=\n=\n55=", expected = "6+5 ERROR\n9+6=15\n4=4\n23*5= ERROR\n4*8= ERROR\n= ERROR\n55= ERROR\n";
        assertEquals(expected, stringEvaluate(test));
    }
}
