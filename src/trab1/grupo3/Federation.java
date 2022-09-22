package TrabalhoPratico1.Grupo3;

public class Federation extends Union {
    public Federation(String nm) {
        super(nm, "Federation"); // ??????
    }

    public boolean isSovereign() {
        return true;
    }

    public Federation append(State s) {
        // Rever conceito melhor
        return null;
    }

    public Federation append(String stName, int area) {
        // Rever conceito melhor
        return null;
    }

    public State greaterState() {
        // Rever conceito melhor
        return null;
    }
}
