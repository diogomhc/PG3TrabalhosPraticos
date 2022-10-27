package trab1.grupo4;

import java.util.*;
import java.util.function.Predicate;

public class Book extends Publication implements Composite<Chapter> {
    private final ArrayList<Chapter> chapters;
    private final String isbn;

    protected Book(String authors, String title, String isbn) {
        super(authors, title);
        this.isbn = isbn;
        chapters = new ArrayList<>();
    }

    public Chapter get(Predicate<Chapter> pred) {
        Chapter temp = null;

        for (Chapter c: chapters)
            if (pred.test(c))
                temp = c;

        return temp;
    }

    public List<Chapter> getAll() {
        ArrayList<Chapter> temp = new ArrayList<>(chapters);

        temp.sort((prev, next) -> prev.getTitle().compareToIgnoreCase(next.getTitle()));

        return temp;
    }

    public Composite<Chapter> append(Chapter chapter) {
        throw new UnsupportedOperationException();
    }

    public Book append(String chapterTitle, int pages) throws PublicationException {
        if (get(c -> c.getTitle().equalsIgnoreCase(chapterTitle)) != null) throw new PublicationException("Invalid chapter");

        chapters.add(new Chapter(chapterTitle, chapters.size() + 1, this, chapters.size() == 0 ? 1 : chapters.get(chapters.size() - 1).getFinalPage() + 1, pages));

        return this;
    }

    public int getNumberOfPages() {
        int sum = 0;

        for (Chapter c: chapters)
            sum += c.getNumberOfPages();

        return sum;
    }

    public String getDescription() {
        StringBuilder res = new StringBuilder(toString() + "\nISBN:" + isbn);
        if (getNumberOfPages() > 0) res.append(", " + getNumberOfPages() + (getNumberOfPages() > 1 ? " pages" : " page"));
        for(Chapter c: chapters) {
            res.append("\n\t").append(c.toString()).append(", " + c.pagesToString());
        }
        return res.toString();
    }
}
