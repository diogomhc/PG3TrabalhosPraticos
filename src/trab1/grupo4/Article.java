package trab1.grupo4;

public class Article extends Content {
    private final Publication publication;
    public Article(String authors, String title, Publication p, int hp, int np) {
        super("", title, hp, np);
        publication = p;
    }

    public Publication getPublication() {
        return publication;
    }

    // INACABADO
}
