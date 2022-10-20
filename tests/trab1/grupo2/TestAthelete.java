package trab1.grupo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAthelete {
    @Test
    public void testConstruct() {
        Athlete a = new AthleteTest("Diogo Ribeiro");
        assertEquals( "Diogo Ribeiro", a.getName());
    }

    @Test
    public void testToString()  {
        Athlete a = new AthleteTest("Diogo Ribeiro");
        assertEquals( "Diogo Ribeiro", a.toString());
    }

    public void testEquals()  {
        Athlete a1 = new AthleteTest("Diogo Ribeiro");
        assertEquals( a1, new AthleteTest("Diogo Ribeiro") );
        assertEquals( a1, new AthleteTest(new String("Diogo Ribeiro")));
        assertFalse( a1.equals( null ) );
        assertFalse( a1.equals( "Diogo Ribeiro" ) );
    }

}
