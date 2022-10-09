package trab1.grupo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnion {
    private static final State pt = new Country("Portugal", 92391, true);
    private static final State f = new Country("França", 154077, true);
    private static final String onuName = "Organização Nações Unidas";
    private static final String onuType = "Organização Internacional";

    @Test
    public void testConstruct()  {
        Union onu = new Union( onuName, onuType );
        assertEquals(onuName, onu.name);
        assertEquals(0, onu.getArea());
        assertFalse( onu.isSovereign() );
        assertEquals(0, onu.size());
    }

    @Test
    public void testEmptyDescription()  {
        Union onu = new Union( onuName, onuType );
        assertEquals("Organização Nações Unidas - Organização Internacional", onu.toString());
    }

    @Test
    public void testAppendOne() throws Exception {
        Union onu = new Union( onuName, onuType );

        onu.append( pt );
        assertEquals(1, onu.size());
        assertSame(pt, onu.first());
        assertSame(pt, onu.last());
        assertEquals(pt.getArea(), onu.getArea());
   }

    @Test
    public void testAppend() throws Exception {

        Union onu = new Union( onuName, onuType );

        State[] states = { pt, f };
        onu.append( pt ).append( f);
        assertEquals(2, onu.size());
        assertEquals(pt.getArea()+ f.getArea(), onu.getArea());
        assertSame(pt, onu.first());
        assertSame(f, onu.last());
        int i= 0;
        for( State s : onu )
            assertSame(states[i++], s);

        onu.append( pt );
        assertEquals(2, onu.size());
        assertEquals(pt.getArea()+ f.getArea(), onu.getArea());
        assertSame(pt, onu.first());
        assertSame(f, onu.last());
    }

    @Test
    public void testToString() throws Exception {
        Union onu = new Union( onuName, onuType );

        onu.append(pt).append(f);
        assertEquals("Organização Nações Unidas - Organização Internacional"+
                        "\n  Portugal - Estado soberano (92391 km²)" +
                        "\n  França - Estado soberano (154077 km²)",
                      onu.toString());
    }

    @Test
    public void testFind() throws Exception {
        Union onu = new Union( onuName, onuType );
        onu.append(pt).append(f);
        assertSame( onu, onu.find(s-> s.name.equals(onuName)));
        assertSame( pt, onu.find(s-> s.name.equals("Portugal")));
        assertSame( f, onu.find(s-> s.getArea() == f.getArea()));
        assertNull( onu.find(s-> s.getArea() == 0) );
    }
}
