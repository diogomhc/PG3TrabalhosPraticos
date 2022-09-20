package TrabalhoPratico1.Grupo2;
import TrabalhoPratico1.Grupo2.Athlete;
import TrabalhoPratico1.Grupo2.Competition;

public class Event extends Competition {
    private final String modality;
    private final Athlete athlete;

    public Event(Athlete a, String m, double t) {
        super(t);
        athlete = a;
        modality = m;
    }

    public String getModality() {
        return modality;
    }

    public Athlete getAthlete() {
        return athlete;
    }
}
