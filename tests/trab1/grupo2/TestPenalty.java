package trab1.grupo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPenalty {
    @Test
    public void testConstruct() {
        Athlete a = new AthleteTest("Arnaldo Abrantes");
        Event e = new Event(a,"corrida: 100 metros", 10.53);
        Penalty pe = new Penalty( e, 0.20);
        assertEquals( a, pe.getAthlete());
        assertEquals( "corrida: 100 metros", pe.getModality());
        assertEquals( 1073, (int)(pe.getTime()*100+0.5));
        assertEquals( 10.53, pe.competition.getTime());
    }

    @Test
    public void testToString()  {
        Athlete a = new AthleteTest("Arnaldo Abrantes");
        Event e = new Event(a,"corrida: 100 metros", 10.53);
        Penalty pe = new Penalty( e, 0.20);
        assertEquals( "corrida: 100 metros: Arnaldo Abrantes - 10.73 [10.53 + 0.20]", pe.toString());
    }
}
