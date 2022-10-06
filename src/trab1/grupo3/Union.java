package trab1.grupo3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class Union extends State implements Composition {

    private final ArrayList<State> states;

    public final String type;

    public Union(String nm, String tp) {
        super(nm);
        type = tp;
        states = new ArrayList<>();
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

    public Iterator<State> iterator() {
        return states.iterator();
    }

    public State find(Predicate<State> pred) {
        if (pred.test(this)) return this;

        for(State s: states)
            if (pred.test(s))
                return s;

        return null;
    }

    public Composition append(State s) throws StateException {
        State found = find( i -> i.name.equals(s.name) );
        if (found == null || !found.equals(s)) states.add(s);
        return this;
    }

    public String getDescription(String prefix) {
        StringBuilder res = new StringBuilder(prefix + name + " - " + type);
        for (State s: states) {
            res.append('\n' + prefix + s.getDescription("\t"));
        }
        return res.toString();
    }
}
