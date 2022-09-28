package trab1.grupo3;

import java.util.ArrayList;
import java.util.Iterator;

public class Union extends State implements Composition {

    private ArrayList<State> states;

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

    public Composition append(State s) throws StateException {
        if (find( i -> i.name.equals(s.name) ).equals(s)) states.add(s);
        return this;
    }

    public Iterator<State> iterator() {
        // Rever conceito melhor
        return null;
    }
}
