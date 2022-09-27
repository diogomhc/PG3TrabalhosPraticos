package trab1.grupo2;

public class Triathlon extends Competition {

    private final String modality;
    private final Athlete athlete;
    protected final Competition[] competitions;

    public Triathlon(Competition... c) throws CompetitionException {
        super(getCompetitionsTime(c));
        modality = "Triatlo";
        athlete = c[0].getAthlete();
        competitions = c;
    }

    private static double getCompetitionsTime(Competition...c) throws CompetitionException {
        if (c.length != 3)
            throw new CompetitionException("Triatlo: Número de competições inválido");
        for (int i = 1; i < 3; i++) {
            if (!c[i].getModality().equals(c[0].getModality()))
                throw new CompetitionException("Triatlo: Modalidades inválidas");
            if (!c[i].getAthlete().equals(c[0].getAthlete()))
                throw new CompetitionException("Triatlo: Atleta inválido");
        }
        return Competition.sumTimes(c);
    }

    public String getModality() {
        return modality;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public double[] getThreeTimes() {
        double[] res = new double[3];
        for (int i = 0; i < 3; i++) res[i] = competitions[2 - i].getTime();
        return res;
    }

    public String toString() {
        StringBuilder res = new StringBuilder("Triatlo\n");
        for (Competition c: competitions) {
            res.append("\n" + c);
        }
        return res.toString();
    }
}
