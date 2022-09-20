package TrabalhoPratico1.Grupo2;

public class AthleteTest implements Athlete {
    private final String name;

    public AthleteTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return getName();
    }
    public boolean equals(Object o){
        return o instanceof AthleteTest &&
               getName().equals(((AthleteTest)o).getName());
    }
}
