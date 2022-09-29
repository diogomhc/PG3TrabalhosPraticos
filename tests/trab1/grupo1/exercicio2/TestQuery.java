package trab1.grupo1.exercicio2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestQuery {

    private static void testGetters(Query e, String nm, String resp, int points) {
        assertEquals(nm, e.getText());
        assertEquals(points, e.getPoints());
        assertEquals(points,e.checkAnswer(resp));
    }

    @Test
    public void testConstructorOne() {
        Query e = new Query("A dimensão do int é 32 bits");
        testGetters(e, "A dimensão do int é 32 bits", "yes",5);
    }

    @Test
    public void testConstructorTwo() {
        Query e1 = new Query("A dimensão do int é 32 bits", true);
        testGetters(e1, "A dimensão do int é 32 bits", "yes",5);
        Query e2 = new Query("A dimensão do int é 64 bits", false);
        testGetters(e2, "A dimensão do int é 64 bits", "no",5);
    }

    @Test
    public void testConstructorThree() {
        Query e = new Query("A dimensão do int é 64 bits", "no", 10);
        testGetters(e, "A dimensão do int é 64 bits", "no",10);
    }

    @Test
    public void testEquals() {
        Query e1 = new Query("A dimensão do int é 32 bits", "yes",14);
        assertTrue(e1.equals(new Query("A dimensão do int é 32 bits", "yes",14)));
        assertTrue(e1.equals(new Query(new String("A dimensão do int é 32 bits"), "yes",14)));
        assertTrue(e1.equals(new Query("A dimensão do int é 32 bits", new String("yes"),14)));

        Query e2 = new Query("A dimensão do int é 32 bits", "sim",14);
        assertTrue(e2.equals(new Query("A dimensão do int é 32 bits", "sim",14)));

        assertFalse(e1.equals(e2));
        assertFalse(e1.equals(new Query("A dimensão do int é 32 bits", "yes",5)));
        assertFalse(e1.equals(new Query("A dimensão do int é 64 bits", "yes",14)));
        assertEquals(e1, new Query("A dimensão do int é 32 bits", "yes",14));
    }

    @Test
    public void testToString() {
        String str= "A dimensão do int é 32 bits [5]? yes";
        Query e = new Query("A dimensão do int é 32 bits");
        assertEquals(str, e.toString());
        e = new Query("A dimensão do int é 32 bits", true);
        assertEquals(str, e.toString());
        e = new Query("A dimensão do int é 32 bits", "yes", 5);
        assertEquals(str, e.toString());
        e = new Query("A dimensão do int é 32 bits", "sim",15);
        assertEquals("A dimensão do int é 32 bits [15]? sim", e.toString());
    }

    @Test
    public void testCompareTo() {
        Query e1 = new Query("Event Greater", "yes", 4);
        Query e2 = new Query("Event Less", "yes", 3);
        Query e3 = new Query("Event Equal", "yes", 4);
        assertTrue(e1.compareTo(e2) > 0);
        assertTrue(e2.compareTo( e3) < 0);
        assertEquals(0, e1.compareTo( e3));
    }

    @Test
    public void testParser() {
        Query e = Query.parse("A dimensão do int é 32 bits? yes");
        testGetters(e, "A dimensão do int é 32 bits", "yes", 5);
        e = Query.parse("A dimensão do int é 32 bits [14]? yes");
        testGetters(e, "A dimensão do int é 32 bits", "yes", 14);
        e = Query.parse("A dimensão do int é 64 bits [10]? no");
        testGetters(e, "A dimensão do int é 64 bits", "no", 10);
    }


    @Test
    public void testGrowing() {
        Query[] queries = new Query[ 5 ];
        for(int i= 0; i < queries.length; ++i)
            queries[i] = new Query("Text " + i, "yes", i);
        Query[] result = Query.growingQueries( queries );
        assertNotSame( result, queries );
        assertArrayEquals(queries, result);
        for(int i= 1; i < queries.length; i+=2)
            queries[i] = new Query("Text " + i, "yes", i-2);
        result = Query.growingQueries( queries );
        assertEquals(3, result.length);
        for(int i= 1; i < result.length; ++i)
            assertTrue( result[i].compareTo(result[i-1]) >= 0);
    }
}
