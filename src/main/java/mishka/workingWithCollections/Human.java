package mishka.workingWithCollections;

import org.jetbrains.annotations.NotNull;

/**
 * Класс Human представляет собой реализацию сущности Человек в Базе Данных
 * Здесь включено его уникальное ID, имя, пол, подразделение и зарплата
 *
 * @author Mishka2374
 */
public class Human {
    private final int ID;                 //Персональный ID
    private final String name;            //Имя Человека
    private final String sex;       //Пол

    private final String birthdate; //Дата Рождения
    private final Division division; //Подразделение
    private final int salary;        //Зарплата
    static String[] names;   //Массив имён для Заголовка

    /**
     * Конструктор по умолчанию
     *
     * @example <pre>{@code
     *           Human man = new Human();
     *      }</pre>
     */
    public Human() {
        ID = 10000;
        name = null;
        sex = null;
        birthdate = null;
        division = new Division();
        salary = 0;
    }

    /**
     * Конструктор, принимающий на вход массив строк
     *
     * @param data массив строк, содержащий поля класса
     * @throws IllegalArgumentException неправильная длина массива
     */
    public Human(String @NotNull [] data) {
        if (data.length != 6) {
            throw new IllegalArgumentException("Expected array length: 6, but got: " + data.length);
        }

        ID = Integer.valueOf(data[0]);
        name = data[1];
        sex = data[2];
        birthdate = data[3];
        division = new Division(data[4]);
        salary = Integer.valueOf(data[5]);
    }

    /**
     * Конструктор, принимающий на вход параметры для сущности
     *
     * @param ID        персональный ID
     * @param name      имя Человека
     * @param sex       пол
     * @param birthdate день рождения
     * @param division  имя подразделения
     * @param salary    зарплата
     */
    public Human(int ID, String name, String sex,
                 String birthdate, Division division, int salary) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.birthdate = birthdate;
        this.division = division;
        this.salary = salary;
    }


    /**
     * Переопределённый метод toString
     *
     * @return строка с информацией о значениях полей сущности
     */
    @Override
    public String toString() {
        return String.format("%-1s %-8s %-10s %-9s %-15s %-10s %-6s %-1s",
                "|", ID, name, sex, birthdate, division.getID(),salary,"|");
    }

    /**
     * Метод, искусственной индикации Заголовка сущности Человек
     *
     */
    public static void printOf() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-2s %-7s %-10s %-10s %-13s %-10s %-7s %-1s%n",
                "|","ID", "Name", "Gender", "BirthDate", "Division", "Salary", "|");
        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Метод, индикации для Заголовка сущности Человек (первая строчка на входе в CVS файле)
     *
     * @param names массив имён для Заголовка сущности
     */
    public static void identify(String[] names){
        if (names.length != 6) {
            throw new IllegalArgumentException("Expected array length: 6, but got: " + names.length);
        }
        Human.names = names;
    }

    /**
     * Метод составления Заголовка для таблицы данных о Человеке
     *
     */
    public static void printHeader() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-2s %-7s %-10s %-10s %-13s %-10s %-7s %-1s%n",
                "|",names[0], names[1], names[2], names[3], names[4], names[5], "|");
        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Метод, выводящий сущность Подразделение, которая связана с сущностью Человек
     *
     * @return заголовок сущности Подразделения
     */
    public String printDivisionName(){
        return division.toString();
    }
    /**
     * Метод получения ID Человека
     *
     * @return ID Человека
     */
    public int getID() {
        return ID;
    }
    /**
     * Метод получения имени Человека
     *
     * @return имя Человека
     */
    public String getName() {
        return name;
    }
    /**
     * Метод получения пола Человека
     *
     * @return пол Человека
     */
    public String getSex() {
        return sex;
    }
    /**
     * Метод получения имени Подразделения Человека
     *
     * @return имя Подразделения Человека
     */
    public String getDivision() {
        return division.getName();
    }
    /**
     * Метод получения Даты рождения Человека
     *
     * @return Дата рождения Человека
     */
    public String getBirthdate() {
        return birthdate;
    }
    /**
     * Метод получения зарплаты Человека
     *
     * @return зарплата Человека
     */
    public int getSalary() {
        return salary;
    }
}