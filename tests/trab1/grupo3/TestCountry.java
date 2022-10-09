package trab1.grupo3;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;


public class TestCountry {
    private static void testGetters(State s, String nm, int area, boolean isSovereign) {
        assertEquals(nm, s.name);
        assertEquals(area, s.getArea());
        assertEquals(isSovereign, s.isSovereign());
    }

    @Test
    public void testConstruct()  {
        State pt = new Country("Portugal", 92391, true);//Estado soberano
        testGetters( pt, "Portugal", 92391, true );
        State g = new Country("Geórgia", 154077, false);//Estado autónomo
        testGetters( g, "Geórgia", 154077, false );
    }

    @Test
    public void testToString()  {
        State pt = new Country("Portugal", 92391, true);//Estado soberano
        assertEquals( "Portugal - Estado soberano (92391 km²)", pt.toString() );
        State g = new Country("Geórgia", 154077, false);//Estado autónomo
        assertEquals( "Geórgia - Estado autónomo (154077 km²)", g.toString() );
    }

    @Test
    public void testFind() {
        State pt = new Country("Portugal", 92391, true);//Estado soberano
        Predicate<State> predTrue = new Predicate<State>() {
            @Override
            public boolean test(State state) {
                return true;
            }
        };
        assertSame( pt, pt.find(predTrue));
        Predicate<State> predPt = new Predicate<State>() {
            @Override
            public boolean test(State state) {
                return state.name.equals("Portugal");
            }
        };
        assertSame( pt, pt.find( predPt ));
        Predicate<State> predSovereign = new Predicate<State>() {
            @Override
            public boolean test(State state) {
                return state.isSovereign();
            }
        };
        assertSame( pt, pt.find(predSovereign));

        assertNull( pt.find( predTrue.negate() ) );
    }
}
