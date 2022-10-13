package trab1.grupo4;

public class Article extends Content {
    private final Publication publication;

    private final String authors;

    public Article(String authors, String title, Publication p, int hp, int np) throws Exception {
        super(authors, title, hp, validatePageNumbers(hp, np));
        this.authors = authors;
        publication = p;
    }

    private static int validatePageNumbers(int hp, int np) throws Exception {
        if (hp + np - 1 <= 0) throw new Exception();
        return hp + np - 1;
    }

    public Publication getPublication() {
        return publication;
    }


    public String toString() {
        return super.toString() + ", " + getPublication().getTitle() + ", " + pagesToString();
    }
    // INACABADO
}
