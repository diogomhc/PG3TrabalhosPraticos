package trab1.grupo3;

import java.util.function.Predicate;

public abstract class State implements Comparable<State> {
    public final String name;

    protected State(String nm) {
        name = nm;
    }

    public State find(Predicate<State> pred) {
        return pred.test(this) ? this: null;
    }

    public String getDescription(String prefix) {
        return prefix + name + " - ";
    }

    public final String toString() {
        return getDescription("");
    }

    public abstract boolean isSovereign();

    public abstract int getArea();

    public int compareTo(State other) {
        return getArea() - other.getArea();
    }
}
