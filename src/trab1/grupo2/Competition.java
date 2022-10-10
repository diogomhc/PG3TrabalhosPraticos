package trab1.grupo2;

import java.util.Locale;

public abstract class Competition {
    protected final double time;

    protected Competition(double time) {
        this.time = time;
    }

    public final double getTime() {
        return time;
    }

    public abstract String getModality();

    public abstract Athlete getAthlete();

    public String toString() {
        return String.format(Locale.US, "%s: %s - %.2f", getModality(), getAthlete(), getTime());
    }

    public static double sumTimes(Competition... c) {
        double sum = 0;
        for (Competition comp: c) {
            sum += comp.getTime();
        }
        return sum;
    }
}
