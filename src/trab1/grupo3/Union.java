package trab1.grupo3;

import java.util.Iterator;

public class Union extends State implements Composition {

    private final String type;

    public Union(String nm, String tp) {
        super(nm);
        type = tp;
    }

    public boolean isSovereign() {
        return false;
    }

    public int getArea() {
        // Área dos estados que agrega
        return 0;
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
