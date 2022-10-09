package trab1.grupo4;

public abstract class Content extends Publication {
    private final int homePage, numberOfPages;

    protected Content(String prefix, String title, int hp, int np) {
        super(prefix, title);
        homePage = hp;
        numberOfPages = np;
    }

    public final int getNumberOfPages() {
        return numberOfPages;
    }

    public final int getHomePage() {
        return homePage;
    }

    public final int getFinalPage() {
        return getNumberOfPages() - 1;
    }

    public String pagesToString() {
        return Integer.toString(getHomePage()) + (getNumberOfPages() == 1 ? '-' + Integer.toString(getFinalPage()) : '\0');
    }
}
