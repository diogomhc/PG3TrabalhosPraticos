package trab1.grupo2;

public class CompetitionException extends Exception {
    public CompetitionException() {
        super("Competição inválida");
    }
    public CompetitionException(String message) {
        super(message);
    }
}
