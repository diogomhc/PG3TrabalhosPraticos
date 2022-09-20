package TrabalhoPratico1.Grupo2;

public abstract class Competition {
    protected final double time;

    public Competition(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public abstract String getModality();

    public abstract Athlete getAthlete();

    public String toString() {
        return getModality() + ": " + getAthlete() + " - " + getTime();
    }

    public static double sumTimes(Competition... c) {
        double sum = 0;
        for (Competition comp: c) {
            sum += comp.getTime();
        }
        return sum;
    }
}
