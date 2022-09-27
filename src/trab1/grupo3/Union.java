package trab1.grupo3;

import java.util.Iterator;

public class Union extends State implements Composition {

    private State[] states;

    public final String type;

    public Union(String nm, String tp) {
        super(nm);
        type = tp;
    }

    public boolean isSovereign() {
        return false;
    }

    public int getArea() {
        int area = 0;
        for (State s: states) {
            area += s.getArea();
        }
        return area;
    }

    public int compareTo(State other) {
        // Rever conceito melhor
        return 0;
    }

    public Composition append(State s) throws StateException {
        // Rever conceito melhor
        return null;
    }

    public Iterator<State> iterator() {
        // Rever conceito melhor
        return null;
    }
}
