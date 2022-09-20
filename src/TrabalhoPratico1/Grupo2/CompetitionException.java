package TrabalhoPratico1.Grupo2;

public class CompetitionException extends Exception {
    public CompetitionException() {
        super("Competição inválida");
    }
    public CompetitionException(String message) {
        super(message);
    }
}
