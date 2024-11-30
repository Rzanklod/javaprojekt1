package test;

import org.junit.Test;
import resource.book.Audiobook;
import resource.book.PaperBook;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {
    @Test
    public void differentBookTypesTest() {
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        Audiobook ab = new Audiobook("Pan Tadeusz", "Aleksandria", 9, "Adam Mickiewicz", 470);
        assertTrue(pb.isTheSameBook(ab));
    }

    @Test
    public void differentTitlesTest(){
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        Audiobook ab = new Audiobook("Pan Tadeusz2", "GREG", 9, "Adam Mickiewicz", 470);
        assertFalse(pb.isTheSameBook(ab));
    }

    @Test
    public void differentAuthorsTest(){
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        Audiobook ab = new Audiobook("Pan Tadeusz", "GREG", 9, "Adam Mickiewicza", 470);
        assertFalse(pb.isTheSameBook(ab));
    }

    @Test
    public void sameTitleAndAuthorTest(){
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        PaperBook pb2 = new PaperBook("Pan Tadeusz", "GREG", 9, "Adam Mickiewicz", 470);
        assertTrue(pb.isTheSameBook(pb2));
    }

    @Test
    public void nullArgumentTest(){
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        assertFalse(pb.isTheSameBook(null));
    }
}
