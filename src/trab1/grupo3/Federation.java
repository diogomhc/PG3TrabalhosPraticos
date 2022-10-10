package trab1.grupo3;

public class Federation extends Union {
    public Federation(String nm) {
        super(nm, "Estado federal");
    }

    public boolean isSovereign() {
        return true;
    }

    public Federation append(State s) throws StateException {
        if (s.isSovereign()) throw new StateException(s);
        super.append(s);
        return this;
    }

    public Federation append(String stName, int area) {
        try {
            append(new Country(stName, area, false));
        }
        catch (StateException se) { }
        return this;
    }

    public State greaterState() {
        State greater = null;

        for (State s: this) {
            greater = greater == null ? s : greater.compareTo(s) <= 0 ? s : greater;
        }

        return greater;
    }
}
