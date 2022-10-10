package trab1.grupo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFederation {
    private static final State pt = new Country("Portugal", 92391, true);
    private static final State fr = new Country("França", 154077, true);
    private static final State g = new Country("Geórgia", 154077, false);
    private static final State fl =new Country("Flórida",170451, false);
    private static final String onuName = "Organização Nações Unidas";
    private static final String onuType = "Organização Internacional";

    @Test
    public void testConstruct()  throws Exception{
       Federation usa = new Federation("Estados Unidos");
       assertEquals("Estados Unidos", usa.name);
       assertEquals(0, usa.getArea());
       assertTrue( usa.isSovereign() );
       assertEquals(0, usa.size());
    }

    @Test
    public void testEmptyDescription()  {
        Federation usa = new Federation("Estados Unidos");
        assertEquals("Estados Unidos - Estado federal",usa.toString());
    }

    @Test
    public void testAppend() throws Exception {
        Federation usa = new Federation("Estados Unidos");
        usa.append( g ).append(fl.name,fl.getArea());
        assertEquals(2, usa.size());
        assertEquals(g.getArea()+ fl.getArea(), usa.getArea());
        assertSame(g, usa.getFirst());
        assertEquals(fl.name, usa.getLast().name);
        assertFalse( usa.getLast().isSovereign() );

        usa.append( fl );
        assertEquals(2, usa.size());
    }

    @Test
    public void testToString() throws Exception {
        Federation usa = new Federation("Estados Unidos");
        usa.append( g ).append(fl);
        assertEquals("Estados Unidos - Estado federal"+
                "\n  Geórgia - Estado autónomo (154077 km²)" +
                "\n  Flórida - Estado autónomo (170451 km²)", usa.toString());

    }

    @Test
    public void testToStringTwo() throws Exception {
        Federation usa = new Federation("Estados Unidos");
        usa.append( g ).append(fl);
        Union onu = new Union( onuName, onuType );
        onu.append(pt).append(fr).append(usa);

        onu.append(pt).append(fr);
        assertEquals("Organização Nações Unidas - Organização Internacional"+
                "\n  Portugal - Estado soberano (92391 km²)" +
                "\n  França - Estado soberano (154077 km²)"+
                "\n  Estados Unidos - Estado federal"+
                "\n    Geórgia - Estado autónomo (154077 km²)" +
                "\n    Flórida - Estado autónomo (170451 km²)"
                , onu.toString());
    }

    @Test
    public void testFind() throws Exception {
        Federation usa = new Federation("Estados Unidos");
        usa.append( g ).append(fl);
        Union onu = new Union( onuName, onuType );
        onu.append(pt).append(fr).append( usa);
        assertSame( onu, onu.find(s-> s.name.equals(onuName)));
        assertSame( usa, onu.find(s-> s.name.equals("Estados Unidos")));
        assertSame(fr, onu.find(s-> s.getArea() == fr.getArea()));
        assertSame(g, onu.find(s-> s.name.equals(g.name)));
        assertNull( onu.find(s-> s.getArea() == 0) );
    }

    @Test
    public void testAppendException() {
        Federation usa = new Federation("Estados Unidos");
        StateException ex= assertThrows(StateException.class, () -> usa.append( pt ));
        assertEquals("Portugal - Estado inválido", ex.getMessage());
        assertEquals(pt, ex.getState());
    }
}
