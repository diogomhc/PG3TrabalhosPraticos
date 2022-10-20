package trab1.grupo2;

import java.util.Locale;

public class Triathlon extends Competition {
    protected final Competition[] competitions;

    public Triathlon(Competition... c) throws CompetitionException {
        super(getCompetitionsTime(c));
        competitions = c;
    }

    private static double getCompetitionsTime(Competition...c) throws CompetitionException {
        if (c.length != 3)
            throw new CompetitionException("Triatlo: Número de competições inválido");
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < i; j++) {
                if (c[i].getModality().equals(c[j].getModality()))
                    throw new CompetitionException("Triatlo: Modalidades inválidas");
            }
            if (!c[i].getAthlete().equals(c[0].getAthlete()))
                throw new CompetitionException("Triatlo: Atleta inválido");
        }
        return Competition.sumTimes(c);
    }

    public String getModality() {
        return "Triatlo";
    }

    public Athlete getAthlete() {
        return competitions[0].getAthlete();
    }

    public double[] getThreeTimes() {
        double[] res = new double[3];
        for (int i = 0; i < 3; i++) res[i] = competitions[2 - i].getTime();
        return res;
    }

    public String toString() {
        StringBuilder res = new StringBuilder(super.toString());
        for (Competition c: competitions) {
            res.append("\n\t- " + c);
        }
        return res.toString();
    }
}
