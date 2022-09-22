package trab1.grupo2;

public class Penalty extends Competition {
    private final Event event;

    private final double penalty;

    public Penalty(Event e, double tp) {
        super(e.getTime() + tp);
        event = e;
        penalty = tp;
    }

    public String getModality() {
        return event.getModality();
    }

    public Athlete getAthlete() {
        return event.getAthlete();
    }

    public String toString() {
        return getModality() + ": " + getAthlete() + " - " + getTime() + " [" + event.getTime() + " + " + penalty + ']';
    }
}