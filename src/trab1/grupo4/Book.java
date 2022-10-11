package trab1.grupo4;

import java.util.*;
import java.util.function.Predicate;

public class Book extends Publication implements Composite<Chapter> {
    private Chapter[] chapters;
    private final String isbn;

    protected Book(String authors, String title, String isbn) {
        super(authors, title);
        this.isbn = isbn;
    }

    public Chapter get(Predicate<Chapter> pred) {
        for (Chapter c: chapters)
            if (pred.test(c))
                return c;

        return null;
    }

    public List<Chapter> getAll() {
        return Arrays.stream(chapters).toList();
    }

    public Composite<Chapter> append(Chapter chapter) {
        throw new UnsupportedOperationException();
    }

    public Book append(String chapterTitle, int pages) {
        Chapter[] temp = new Chapter[chapters.length + 1];
        System.arraycopy(chapters, 0, temp, 0, chapters.length);
        temp[chapters.length] = new Chapter(chapterTitle, this, pages);
        chapters = temp;

        return this;
    }

    public int getNumberOfPages() {
        int sum = 0;

        for (Chapter c: chapters)
            sum += c.getNumberOfPages();

        return sum;
    }

    public String getDescription() {
        StringBuilder res = new StringBuilder(toString() + "\nISBN: " + isbn + ", " + getNumberOfPages() + (getNumberOfPages() != 1 ? "pages" : "page"));
        for(Chapter c: chapters) {
            res.append("\n\t").append(c.toString().substring(0, c.toString().indexOf(" in"))).append(c.pagesToString());
        }
        return res.toString();
    }
}
