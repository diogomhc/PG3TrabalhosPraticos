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

        State s = null;

        for(State state: states) {
            if ((s = state.find(pred)) != null) break;
        }

        return s;
    }

    public Composition append(State s) throws StateException {
        if (find( i -> i.name.equals(s.name) ) == null) states.add(s);
        return this;
    }

    public String getDescription(String prefix) {
        StringBuilder res = new StringBuilder(super.getDescription(prefix) + type);
        for (State s: states) {
            res.append('\n').append(s.getDescription(prefix + "  "));
        }
        return res.toString();
    }

    public int size() {
        return states.size();
    }

    public State getFirst() {
        return states.isEmpty() ? null : states.get(0);
    }

    public State getLast() {
        return states.isEmpty() ? null : states.get(size() - 1);
    }
}
