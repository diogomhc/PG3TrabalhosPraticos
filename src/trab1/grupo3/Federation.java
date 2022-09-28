package trab1.grupo3;

public class Federation extends Union {
    public Federation(String nm) {
        super(nm, "Federation"); // ??????
    }

    public boolean isSovereign() {
        return true;
    }

    public Federation append(State s) throws StateException {
        if (s.isSovereign()) throw new StateException(s.name);
        super.append(s);
        return this;
    }

    public Federation append(String stName, int area) {
        // Rever conceito melhor

        // Dá erro
        //super.append(new Country(stName, area, false));
        return null;
    }

    public State greaterState() {
        // Rever conceito melhor
        return null;
    }
}
