package trab1.grupo4;

public class PublicationException extends Exception {
    public PublicationException() {
        super("Invalid publication");
    }

    public PublicationException(String message) {
        super("Error: " + message);
    }
}
