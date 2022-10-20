package trab1.grupo4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBook {
    @Test
    public void testConstruct() {
        Book b= new Book("Walter J. Savitch, Kenrick Mock",
                "Java: An Introduction to Problem Solving & Programming","0132162709");
        assertEquals( "Java: An Introduction to Problem Solving & Programming", b.getTitle());
        assertEquals( 0, b.getNumberOfPages());
    }

    @Test
    public void testToString()  {
        Book b= new Book("Walter J. Savitch, Kenrick Mock",
                "Java: An Introduction to Problem Solving & Programming","0132162709");
        assertEquals("Walter J. Savitch, Kenrick Mock \"Java: An Introduction to Problem Solving & Programming\"", b.toString());
    }

    @Test
    public void testDescriptionEmpty() throws PublicationException {
        Book b= new Book("Walter J. Savitch, Kenrick Mock",
                "Java: An Introduction to Problem Solving & Programming","0132162709");
        assertEquals("Walter J. Savitch, Kenrick Mock \"Java: An Introduction to Problem Solving & Programming\"\n" +
                "ISBN:0132162709", b.getDescription());
    }

    @Test
    public void testAppend() {
        Book b= new Book("Walter J. Savitch, Kenrick Mock",
                "Java: An Introduction to Problem Solving & Programming","01321627099");
        assertDoesNotThrow(()->b.append("Introduction to Computers and Java", 11));
        assertEquals(11, b.getNumberOfPages());
        assertEquals(1, b.getAll().size());
        assertDoesNotThrow(()->b.append("Basic Computation", 15));
        assertEquals(26, b.getNumberOfPages());
        assertEquals(2, b.getAll().size());

        Chapter[] array= {
                new Chapter("Basic Computation", 2, b, 12, 15),
                new Chapter("Introduction to Computers and Java", b, 11)
        };
        int i = 0;
        for (Chapter c: b.getAll()) {
            Chapter expected = array[i++];
            TestArticle.testGetters(c, expected.getTitle(), expected.getNumberOfPages(), expected.getHomePage(), expected.getFinalPage() );
            assertEquals(expected.getDescription(), c.getDescription());
        }
    }

    @Test
    public void testDescription()  {
        Book b= new Book("Walter J. Savitch, Kenrick Mock",
                "Java: An Introduction to Problem Solving & Programming","01321627099");
        assertDoesNotThrow( () ->b.append("Introduction to Computers and Java", 11).append("Basic Computation", 15));
        assertEquals("Walter J. Savitch, Kenrick Mock \"Java: An Introduction to Problem Solving & Programming\"\n" +
                "ISBN:01321627099, 26 pages\n" +
                "\tCap. 01 - \"Introduction to Computers and Java\", 1-11\n" +
                "\tCap. 02 - \"Basic Computation\", 12-26", b.getDescription());
    }

    @Test
    public void testGet()  {
        Book b= new Book("Walter J. Savitch, Kenrick Mock",
                "Java: An Introduction to Problem Solving & Programming","01321627099");
        assertDoesNotThrow(() ->b.append("Introduction to Computers and Java", 11)
                                 .append("Basic Computation", 15)
                                 .append("Flow of Control: Branching", 20));

        Publication c = b.get(p -> true);
        assertEquals("Flow of Control: Branching", c.getTitle() );

        c = b.get( p -> ((Chapter)p).numberOfChapter == 1);
        assertEquals("Introduction to Computers and Java", c.getTitle() );

        c = b.get( p -> p.getNumberOfPages() == 15);
        assertEquals("Basic Computation", c.getTitle() );

        c = b.get( p -> p.numberOfChapter < 3);
        assertEquals("Basic Computation", c.getTitle() );
    }

    @Test
    public void testAppendUnsupportedOperationException( ) {
        Book b= new Book("Walter J. Savitch, Kenrick Mock",
                "Java: An Introduction to Problem Solving & Programming","01321627099");
        Chapter c =new Chapter("Basic Computation", 2, b, 12, 15);
        assertThrows(UnsupportedOperationException.class,()-> b.append( c));
    }


    @Test
    public void testAppendDuplicateChapterException( ) {
        Book b= new Book("Walter J. Savitch, Kenrick Mock",
                "Java: An Introduction to Problem Solving & Programming","01321627099");
        assertDoesNotThrow(()-> b.append( "Basic Computation", 3));
        PublicationException e=assertThrows(PublicationException.class,()-> b.append( "Basic Computation", 10 ));
        assertEquals("Error: Invalid chapter", e.getMessage());
    }

}
