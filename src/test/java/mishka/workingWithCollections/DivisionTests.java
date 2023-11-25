package mishka.workingWithCollections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTests {

    //Проверка метода getName
    @Test
    void testGetName(){
        //Проверка работы с конструктором по умолчанию
        Division div1 = new Division();
        assertEquals(null,div1.getName());

        //Проверка работы с конструктором, принимающим параметр на вход
        Division div2 = new Division("name");
        assertEquals("name",div2.getName());
    }

    //Проверка метода getID
    @Test
    void testGetID(){
        //Проверка работы с конструктором по умолчанию
        Division div1 = new Division();
        assertEquals(10000,div1.getID());

        //Проверка работы с конструктором, принимающим параметр на вход
        Division div2 = new Division("name");
        int id = div2.getID();
        assertTrue(id >= 10000 && id <= 99999);
    }

    //Проверка метода setName
    @Test
    void testSetName(){
        //Проверка работы с конструктором по умолчанию
        Division div1 = new Division();
        div1.setName("name");
        assertEquals("name",div1.getName());

        //Проверка работы с конструктором, принимающим параметр на вход
        Division div2 = new Division("name");
        div2.setName("surname");
        assertNotEquals("name",div2.getName());
    }
    //Проверка метода toString
    @Test
    void testToStringInEmptyList() {

        //Проверка вывода при пустой сущности Человек
        Division div1 = new Division();
        assertEquals("|  10000         null    |", div1.toString());

        //Проверка вывода при непустой сущности Человек
         Division div2 = new Division("name1");
        int id = div2.getID();
         assertEquals("|  " + id + "         name1   |", div2.toString());
    }

}