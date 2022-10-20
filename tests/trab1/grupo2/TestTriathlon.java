package trab1.grupo2;

import org.junit.jupiter.api.Test;
import org.w3c.dom.events.EventException;

import static org.junit.jupiter.api.Assertions.*;

public class TestTriathlon {
    @Test
    public void testConstruct() throws Exception {
        Athlete a = new AthleteTest("Arnaldo Abrantes");
        double[] times = { 17.24,	55.04,	31.09 };
        Triathlon t = new Triathlon(
                new Event(a,"natacao", times[2]),
                new Event(a,"ciclismo", times[1]),
                new Event(a,"corrida",times[0] ));

        assertEquals( a, t.getAthlete());
        assertEquals( "Triatlo", t.getModality());
        double sum = 0;
        for ( double d: times) sum+= d;
        assertEquals((int) (sum*100+0.5), (int)(t.getTime()*100+0.5));
        assertArrayEquals( times, t.getThreeTimes());
    }

    @Test
    public void testToString() throws Exception  {
        Athlete a = new AthleteTest("Arnaldo Abrantes");
        double[] times = { 17.24,	55.04,	31.09 };
        Triathlon t = new Triathlon(
                new Event(a,"natacao", times[2]),
                new Event(a,"ciclismo", times[1]),
                new Event(a,"corrida",times[0] ));
        assertEquals( "Triatlo: Arnaldo Abrantes - 103.37\n" +
                      "\t- natacao: Arnaldo Abrantes - 31.09\n" +
                      "\t- ciclismo: Arnaldo Abrantes - 55.04\n" +
                      "\t- corrida: Arnaldo Abrantes - 17.24", t.toString());
    }

    @Test
    public void testLessOfThree(){
        String expected = "Triatlo: Número de competições inválido";
        CompetitionException ev;
        ev = assertThrows(CompetitionException.class, () -> new Triathlon() );
        assertEquals(expected, ev.getMessage());

        ev = assertThrows(CompetitionException.class, () -> new Triathlon(new Event[2]) );
        assertEquals(expected, ev.getMessage());
    }

    @Test
    public void testModalities(){
        String expected = "Triatlo: Modalidades inválidas";
        Athlete a = new AthleteTest("Arnaldo Abrantes");
        Event e1 =new Event(a,"natacao", 17.24),
                e2 =   new Event(a,"ciclismo", 55.04),
                e3 =   new Event(a,"corrida", 31.09 );
        CompetitionException ev;
        ev = assertThrows(CompetitionException.class, () -> new Triathlon(e1, e1, e2) );
        assertEquals(expected, ev.getMessage());

        ev = assertThrows(CompetitionException.class, () -> new Triathlon(e1, e2, e1) );
        assertEquals(expected, ev.getMessage());

        ev = assertThrows(CompetitionException.class, () -> new Triathlon(e1, e2, e2) );
        assertEquals(expected, ev.getMessage());

    }

    @Test
    public void testAthlete(){
        String expected = "Triatlo: Atleta inválido";
        Athlete a = new AthleteTest("Arnaldo Abrantes");
        Event e1 = new Event(new AthleteTest("João"),"natacao", 17.24),
              e2 = new Event(a,"ciclismo", 55.04),
              e3 = new Event(a,"corrida", 31.09 );
        CompetitionException ev;
        ev = assertThrows(CompetitionException.class, () -> new Triathlon(e1, e2, e3) );
        assertEquals(expected, ev.getMessage());

        ev = assertThrows(CompetitionException.class, () -> new Triathlon(e2, e3, e1) );
        assertEquals(expected, ev.getMessage());

        ev = assertThrows(CompetitionException.class, () -> new Triathlon(e3, e1, e2) );
        assertEquals(expected, ev.getMessage());

    }

}
