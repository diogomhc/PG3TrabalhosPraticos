package TrabalhoPratico1.Grupo3;

public class StateException extends Exception {
    private final State state;

    public StateException(String msg) {
        super(msg);
        state = null;
    }

    public StateException(State s) {
        super(s.getDescription("").substring(0, s.getDescription("").indexOf(" - ") + 3) + "Estado inválido");
        state = s;
    }
}
