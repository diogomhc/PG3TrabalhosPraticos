package trab1.grupo4;

public class Chapter extends Content {

    public final int numberOfChapter;

    private Book book;

    public Chapter(String title, int chap, Book b, int hp, int np) {
        super(String.format("Cap. %02d -", chap), title, hp, np);
        numberOfChapter = chap;
        book = b;
    }

    public Chapter(String title, Book b, int np) {
        this(title, 1, b, 1, np);
    }

    public String getDescription() {
        return toString() + "\nin " + book.toString() + ", " + pagesToString();
    }
}
