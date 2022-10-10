package trab1.grupo4;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

public class Book extends Publication implements Composite<Chapter> {
    private Chapter[] chapters;

    protected Book(String prefix, String title) {
        super(prefix, title);
    }

    public Chapter get(Predicate<Chapter> pred) {
        return null;
    }

    public List<Chapter> getAll() {
        return null;
    }

    public Composite<Chapter> append(Chapter chapter) {
        return null;
    }

    public int getNumberOfPages() {
        return 0;
    }
}
