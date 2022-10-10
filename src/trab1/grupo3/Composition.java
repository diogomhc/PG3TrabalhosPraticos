package trab1.grupo3;

import java.util.function.Predicate;

public interface Composition extends Iterable<State> {
    State find(Predicate<State> pred);
    Composition append(State s) throws StateException;

    int size();
    State getFirst();
    State getLast();
}
