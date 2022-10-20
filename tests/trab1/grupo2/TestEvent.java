package trab1.grupo2;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class TestEvent {
    @Test
    public void testConstruct() {
        Athlete a = new AthleteTest("Diogo Ribeiro");
        Event e = new Event( a,"50 metros mariposa", 22.96);
        assertEquals( a, e.getAthlete());
        assertEquals( "50 metros mariposa", e.getModality());
        assertEquals( 2296, (int)(e.getTime()*100+0.5));
    }

    @Test
    public void testToString()  {
        Athlete a = new AthleteTest("Diogo Ribeiro");
        Event e = new Event( a,"50 metros mariposa", 22.96);
        assertEquals( "50 metros mariposa: Diogo Ribeiro - 22.96", e.toString());
    }

    @Test
    public void testSum() {
        Athlete a = new AthleteTest("Rosa Mota");
        double[] times = {10.1, 9.79, 9.63, 12.34};
        Competition[] competitions = new Competition[times.length];
        double sum = 0;
        for (int i= 0; i < times.length; ++i) {
            sum += times[i];
            competitions[i] = new Event(a, "corrida: 100 metros", times[i]);
        }
        double res = Competition.sumTimes(competitions);
        assertEquals((int)(sum*100+.5), (int)(res*100+.5));

        res = Competition.sumTimes( competitions[0], competitions[1] );
        assertEquals((int)((times[0] + times[1])*100+.5), (int)(res*100+.5));

        res = Competition.sumTimes(competitions[0]);
        assertEquals((int)(times[0]*100+.5), (int)(res*100+.5));

        res = Competition.sumTimes();
        assertEquals(0, res);
    }

}
