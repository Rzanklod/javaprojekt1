package test;

import org.junit.Test;
import resource.NoAvailableResourceException;
import resource.Resource;
import resource.book.PaperBook;
import user.Student;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class UserTest {
    // testy metody getFee
    @Test
    public void nullResourcesTest(){
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        Resource[] resources = null;
        int fee = s.getFee(resources);
        assertEquals(0, fee);
    }

    @Test
    public void emptyResourcesTest() {
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");

        Resource[] resources = {};

        int fee = s.getFee(resources);

        assertEquals(0, fee);
    }

    @Test
    public void singleOverdueResourceTest() throws NoAvailableResourceException {
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);

        Resource[] resources = { pb };

        pb.rent(s);

        pb.setDueDate(LocalDate.now().minusDays(2));

        int fee = s.getFee(resources);
        assertEquals(2, fee);
    }

    @Test
    public void singleNotOverdueResourceTest() throws NoAvailableResourceException {
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);

        Resource[] resources = { pb };

        pb.rent(s);

        int fee = s.getFee(resources);
        assertEquals(0, fee);
    }

    @Test
    public void multipleOverdueResourceTest() throws NoAvailableResourceException {
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        PaperBook pb2 = new PaperBook("Pan Tadeusz","GREG",2,"Adam Mickiewicz",334);
        PaperBook pb3 = new PaperBook("Pan Tadeusz","GREG",3,"Adam Mickiewicz",334);

        Resource[] resources = { pb, pb2, pb3 };

        pb.rent(s);
        pb2.rent(s);

        pb.setDueDate(LocalDate.now().minusDays(4));
        pb2.setDueDate(LocalDate.now().minusDays(1));
        pb3.setDueDate(LocalDate.now().minusDays(2));
        int fee = s.getFee(resources);
        assertEquals(7, fee);
    }

    @Test
    public void overdueResourcesNotOwnedByUserTest() throws NoAvailableResourceException {
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        PaperBook pb2 = new PaperBook("Pan Tadeusz","GREG",2,"Adam Mickiewicz",334);
        PaperBook pb3 = new PaperBook("Pan Tadeusz","GREG",3,"Adam Mickiewicz",334);

        Resource[] resources = { pb, pb2 };

        pb.rent(s); // wypozycza tylko 1 zasob

        pb.setDueDate(LocalDate.now().minusDays(4));
        pb2.setDueDate(LocalDate.now().minusDays(1));
        pb3.setDueDate(LocalDate.now().minusDays(2));
        int fee = s.getFee(resources);
        assertEquals(4, fee);
    }
    // koniec testow metody getFee


    //Testy metody numberOfResources
    @Test
    public void nullResourcesList(){
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        Resource[] resources = null;

        int numberOfResources = s.numberOfResources(resources);
        assertEquals(0, numberOfResources);
    }

    @Test
    public void emptyResourcesList(){
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        Resource[] resources = {};

        int numberOfResources = s.numberOfResources(resources);
        assertEquals(0, numberOfResources);
    }

    @Test
    public void noOwnedResources() throws NoAvailableResourceException {
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        PaperBook pb2 = new PaperBook("Pan Tadeusz","GREG",2,"Adam Mickiewicz",334);
        PaperBook pb3 = new PaperBook("Pan Tadeusz","GREG",3,"Adam Mickiewicz",334);

        Resource[] resources = { pb, pb2, pb3 };

        int numberOfResources = s.numberOfResources(resources);
        assertEquals(0, numberOfResources);
    }

    @Test
    public void singleOwnedResourceTest() throws NoAvailableResourceException {
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        PaperBook pb2 = new PaperBook("Pan Tadeusz","GREG",2,"Adam Mickiewicz",334);
        PaperBook pb3 = new PaperBook("Pan Tadeusz","GREG",3,"Adam Mickiewicz",334);

        pb2.rent(s);
        Resource[] resources = { pb, pb2, pb3 };

        int numberOfResources = s.numberOfResources(resources);
        assertEquals(1, numberOfResources);
    }

    @Test
    public void multipleOwnedResourceTest() throws NoAvailableResourceException {
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        PaperBook pb = new PaperBook("Pan Tadeusz","GREG",1,"Adam Mickiewicz",334);
        PaperBook pb2 = new PaperBook("Pan Tadeusz","GREG",2,"Adam Mickiewicz",334);
        PaperBook pb3 = new PaperBook("Pan Tadeusz","GREG",3,"Adam Mickiewicz",334);
        PaperBook pb4 = new PaperBook("Pan Tadeusz","GREG",4,"Adam Mickiewicz",334);

        pb2.rent(s);
        pb3.rent(s);
        Resource[] resources = { pb, pb2, pb3, pb4 };

        int numberOfResources = s.numberOfResources(resources);
        assertEquals(2, numberOfResources);
    }
}
