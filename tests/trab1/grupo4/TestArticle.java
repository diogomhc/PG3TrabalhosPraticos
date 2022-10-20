package trab1.grupo4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestArticle {
    static final JournalTest j = new JournalTest("Expresso", "656756788989", 30);
    static void testGetters(Publication p, String title, int np) {
        assertEquals( title, p.getTitle());
        assertEquals( np, p.getNumberOfPages());
    }

    static void testGetters(Content p, String title, int np, int hp, int fp) {
        testGetters( p, title, np);
        assertEquals( hp, p.getHomePage());
        assertEquals( fp, p.getFinalPage());
    }

    @Test
    public void testConstruct() throws PublicationException {
        Article a1 = new Article("Tavares, Miguel Sousa","E desembarcaram nas praias",  j, 5, 5);
        testGetters(a1, "E desembarcaram nas praias", 1, 5 , 5);

        Article a2=new Article("Salvador, João Miguel","A falar é que a gente se entende",j, 34,38);
        testGetters(a2, "A falar é que a gente se entende", 5, 34, 38);
    }

    @Test
    public void testToStringOnePage() throws PublicationException {
        Article a1 = new Article("Tavares, Miguel Sousa","E desembarcaram nas praias",  j, 5, 5);
        assertEquals("Tavares, Miguel Sousa \"E desembarcaram nas praias\", Expresso, 5", a1.toString());
    }

    @Test
    public void testToString() throws PublicationException {
        Article a2=new Article("Salvador, João Miguel","A falar é que a gente se entende",j, 34,38);
        assertEquals("Salvador, João Miguel \"A falar é que a gente se entende\", Expresso, 34-38", a2.toString());
    }

    @Test
    public void testPublicationException( ) {
        PublicationException e = assertThrows(PublicationException.class,()-> new Article("Salvador, João Miguel","A falar é que a gente se entende",j, 34,30));
        assertEquals("Invalid publication", e.getMessage());
    }
}
