package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import resource.NoAvailableResourceException;
import resource.book.ScientificBook;
import resource.journal.ScientificJournal;
import user.Student;
import user.Teacher;

import java.time.LocalDate;

public class RentableTest {
    @Test
    public void nullArgumentTest(){
        ScientificBook sb = new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer",
                5, "Jarosław Warylewski",680,"prawo");
        assertThrows(NoAvailableResourceException.class, () -> {
            sb.rent(null);
        });
    }

    @Test
    public void unsuccessfulRentTest(){
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        ScientificBook sb = new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer",
                5, "Jarosław Warylewski",680,"prawo");
        assertThrows(NoAvailableResourceException.class, () -> {
            sb.rent(s);
            sb.rent(s);
        });
    }

    @Test
    public void successfulRentTest() throws NoAvailableResourceException {
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        ScientificBook sb = new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer",
                5, "Jarosław Warylewski",680,"prawo");
        sb.rent(s);
        assertEquals(s, sb.getUser());
    }

    @Test
    public void studentRentDurationTest() throws NoAvailableResourceException {
        Student s = new Student("Mariusz", "Kowalski", 212, "Wmii", "asdas");
        ScientificBook sb = new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer",
                5, "Jarosław Warylewski",680,"prawo");
        sb.rent(s);
        LocalDate rentDate = sb.getRentDate();
        LocalDate expectedDueDate = rentDate.plusMonths(1);
        assertEquals(expectedDueDate, sb.getDueDate());
    }

    @Test
    public void teacherJournalRentDurationTest() throws NoAvailableResourceException {
        Teacher t = new Teacher("Karol", "Przybylski", 5,
                "Prawa i Administracji", "profesor");
        ScientificJournal sj = new ScientificJournal("Państwo i Prawo","Wolters Kluwer",
                18,LocalDate.of(2024,8,1),"prawo");
        sj.rent(t);
        LocalDate rentDate = sj.getRentDate();
        LocalDate expectedDueDate = rentDate.plusDays(10);
        assertEquals(expectedDueDate, sj.getDueDate());
    }

    @Test
    public void teacherBookRentDurationTest() throws NoAvailableResourceException {
        Teacher t = new Teacher("Karol", "Przybylski", 5,
                "Prawa i Administracji", "profesor");
        ScientificBook sb = new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer",
                5, "Jarosław Warylewski",680,"prawo");
        sb.rent(t);
        LocalDate rentDate = sb.getRentDate();
        LocalDate expectedDueDate = rentDate.plusMonths(3);
        assertEquals(expectedDueDate, sb.getDueDate());
    }
}
