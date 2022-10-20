package trab1.grupo2;

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
