package trab1.grupo4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestChapter {
    static Book book= new Book("Walter J. Savitch, Kenrick Mock",
            "Java: An Introduction to Problem Solving & Programming","0132162709");

    static void testGetters(Content p, String title, int np, int hp, int fp) {
        assertEquals( title, p.getTitle());
        assertEquals( np, p.getNumberOfPages());
        assertEquals( hp, p.getHomePage());
        assertEquals( fp, p.getFinalPage());
    }

    @Test
    public void testConstruct()  {
        Chapter c = new Chapter("Introduction to Computers and Java", book, 11);
        testGetters(c, "Introduction to Computers and Java", 11, 1 , 11);

        c= new Chapter("Basic Computation", 2, book, 11, 14);
        testGetters(c, "Basic Computation", 14, 11, 24);
    }

    @Test
    public void testToString()  {
        Chapter c= new Chapter("Basic Computation", 2, book, 11, 14);
        assertEquals("Cap. 02 - \"Basic Computation\"", c.toString());
    }

    @Test
    public void testDescriptionFirstChapter() {
        Chapter c = new Chapter("Introduction to Computers and Java", book, 11);
        assertEquals("Cap. 01 - \"Introduction to Computers and Java\"\n" +
                "in Walter J. Savitch, Kenrick Mock \"Java: An Introduction to Problem Solving & Programming\", 1-11", c.getDescription());
    }

    @Test
    public void testDescription() {
        Chapter c= new Chapter("Basic Computation", 2, book, 11, 14);
        assertEquals("Cap. 02 - \"Basic Computation\"\n" +
                "in Walter J. Savitch, Kenrick Mock \"Java: An Introduction to Problem Solving & Programming\", 11-24", c.getDescription());
    }
}
