package trab1.grupo3;

public class StateException extends Exception {
    private final State state;

    public StateException(String msg) {
        super(msg);
        state = null;
    }

    public StateException(State s) {
        super(s.name + " - Estado inválido");
        state = s;
    }

    public State getState() {
        return state;
    }
}
