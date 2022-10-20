package trab1.grupo4;

import trab1.grupo4.Publication;

public class JournalTest extends Publication {
    private final int pages;
    protected JournalTest(String title, String isbn, int np) {
        super( "Journal ", title ); pages = np;
    }
    public int getNumberOfPages() { return pages; }
}
