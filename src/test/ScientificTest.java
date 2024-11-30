package test;

import org.junit.Test;
import resource.book.ScientificBook;
import resource.journal.ScientificJournal;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScientificTest {
    @Test
    public void nullArgumentTest(){
        ScientificBook sb = new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer",
                5, "Jarosław Warylewski",680,"prawo");

        assertFalse(sb.isTheSameDomain(null));
    }

    @Test
    public void differentObjectTypesTest(){
        ScientificBook sb = new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer",
                5, "Jarosław Warylewski",680,"prawo");
        ScientificJournal sj = new ScientificJournal("Państwo i Prawo","Wolters Kluwer",
                18, LocalDate.of(2024,8,1),"prawo");

        assertTrue(sb.isTheSameDomain(sj));
    }

    @Test
    public void differentDomainsTest(){
        ScientificBook sb = new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer",
                5, "Jarosław Warylewski",680,"prawo");
        ScientificBook sb2 = new ScientificBook("Prawo karne - część ogólna", "Wolters Kluwer",
                6, "Jarosław Warylewski",680,"prawoasd");

        assertFalse(sb.isTheSameDomain(sb2));
    }
}
