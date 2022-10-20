package trab1.grupo2;

import java.util.Locale;

public class Penalty extends Competition {
    private final double penalty;
    public final Competition competition;

    public Penalty(Event e, double tp) {
        super(e.getTime() + tp);
        competition = e;
        penalty = tp;
    }

    public String getModality() {
        return competition.getModality();
    }

    public Athlete getAthlete() {
        return competition.getAthlete();
    }

    public String toString() {
        return String.format(Locale.US, super.toString() + " [%.2f + %.2f]", competition.getTime(), penalty);
    }
}