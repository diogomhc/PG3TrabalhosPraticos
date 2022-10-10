package trab1.grupo4;

public abstract class Publication {
    private final String prefix, title;

    protected Publication(String prefix, String title) {
        this.prefix = prefix;
        this.title = title;
    }

    public abstract int getNumberOfPages();

    public String getTitle() {
        return title;
    }

    public String toString() {
        return prefix + " \"" + getTitle() + '"';
    }
}
