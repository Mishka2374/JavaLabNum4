package mishka.workingWithCollections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTests {

    //Проверка метода identify
    @Test
    void testIdentify() {
        // Проверка, что генерируется исключение IllegalArgumentException, когда длина массива names не равна 6
        String[] names1 = {"1", "2", "3"};
        assertThrows(IllegalArgumentException.class, () -> Human.identify(names1));

        // Проверка, правильно ли задано поле names, если длина массива names равна 6
        String[] names2 = {"1", "2", "3", "4", "5", "6"};
        Human.identify(names2);
        assertArrayEquals(names2, Human.names);
    }

    //Проверка метода toString
    @Test
    void testToString() {

        //Проверка вывода при пустой сущности Человек
        Human man1 = new Human();
        assertEquals("| 10000    null       null      null            10000      0      |", man1.toString());

        //Проверка вывода при непустой сущности Человек
        Division div = new Division();
        Human man2 = new Human(1,"1","1","1",div,1);
        assertEquals("| 1        1          1         1               10000      1      |", man2.toString());
    }

}