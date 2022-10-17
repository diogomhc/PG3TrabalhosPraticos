package trab1.grupo4;

public class Article extends Content {
    private final Publication publication;

    public Article(String authors, String title, Publication p, int hp, int fp) throws PublicationException {
        super(authors, title, hp, validatePageNumbers(hp, fp));
        publication = p;
    }

    private static int validatePageNumbers(int hp, int fp) throws PublicationException {
        if (fp < hp) throw new PublicationException();
        return fp - hp + 1;
    }

    public Publication getPublication() {
        return publication;
    }


    public String toString() {
        return super.toString() + ", " + getPublication().getTitle() + ", " + pagesToString();
    }
}
