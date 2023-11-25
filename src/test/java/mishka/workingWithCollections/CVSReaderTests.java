package mishka.workingWithCollections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class CVSReaderTests {

    //Проверка, что метод input правильно работает с CVS файлом
    @Test
    public void testInput() {
        ArrayList<Human> humans = new ArrayList<>();

        try {
            CVSReader.input(humans, "foreign_name_one.csv", ';');
            assertFalse(humans.isEmpty());
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }

        try {
            CVSReader.input(humans, "one.csv", ';');
            fail("Exception should have been thrown");
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

}