package trab1.grupo2;

import org.junit.jupiter.api.Test;

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
        assertEquals( "Triatlo: Arnaldo Abrantes - 103,37\n" +
                      "\t- natacao: Arnaldo Abrantes - 31,09\n" +
                      "\t- ciclismo: Arnaldo Abrantes - 55,04\n" +
                      "\t- corrida: Arnaldo Abrantes - 17,24", t.toString());
    }
}
