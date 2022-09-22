package trab1.grupo4;

public abstract class Publication {
    private final String prefix, title;

    public Publication(String prefix, String title) {
        this.prefix = prefix;
        this.title = title;
    }

    public abstract int getNumberOfPages();

    public String getTitle() {
        return title;
    }

    public String getPrefix() {
        return prefix;
    }

    public String toString() {
        return getPrefix() + '"' + getTitle() + '"';
    }
}
