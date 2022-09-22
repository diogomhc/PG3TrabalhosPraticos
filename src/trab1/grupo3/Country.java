package TrabalhoPratico1.Grupo3;

public class Country extends State {
    private final int area;
    private final boolean isSovereign;

    public Country(String nm, int a, boolean sovereign) {
        super(nm);
        area = a;
        isSovereign = sovereign;
    }

    public int getArea() {
        return area;
    }

    public boolean isSovereign() {
        return isSovereign;
    }

    public String getDescription(String prefix) {
        return super.getDescription(prefix) + "Estado " + (isSovereign() ? "soberano" : "autónomo") + " (" + area + " km²)";
    }

    public int compareTo(State other) {
        return getArea() - other.getArea();
    }
}