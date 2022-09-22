package TrabalhoPratico1.Grupo3;

import java.util.function.Predicate;

public interface Composition extends Iterable<State> {
    public State find(Predicate<State> pred);
    public Composition append(State s) throws StateException;
}
