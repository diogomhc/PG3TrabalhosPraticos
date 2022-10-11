package trab1.grupo4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Journal extends Publication implements Composite<Article> {
    private Article[] articles;

    protected Journal(String prefix, String title) {
        super(prefix, title);
        articles = new Article[0];
    }

    public Article get(Predicate<Article> pred) {
        for (Article a: articles)
            if (pred.test(a))
                return a;

        return null;
    }

    public List<Article> getAll() {
        return Arrays.stream(articles).toList();
    }

    public Composite<Article> append(Article article) {
        Article[] temp = new Article[articles.length + 1];
        System.arraycopy(articles, 0, temp, 0, articles.length);
        temp[articles.length] = article;
        articles = temp;

        return this;
    }

    public int getNumberOfPages() {
        return 0;
    }
}
