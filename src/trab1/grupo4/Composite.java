package trab1.grupo4;

import java.util.List;
import java.util.function.Predicate;

public interface Composite<T> {
    T get(Predicate<T> pred);
    List<T> getAll();
    Composite<T> append(T t);
}
