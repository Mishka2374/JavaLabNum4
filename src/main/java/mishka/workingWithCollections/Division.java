package mishka.workingWithCollections;

import java.util.HashMap;
import java.util.Random;
/**
 * Класс Division представляет собой реализацию сущности Подразделение в Базе Данных
 * Здесь включено его уникальное ID и имя
 *
 * @author Mishka2374
 */
public class Division {
    private final int ID; //Уникальное ID
    private String name;  //Имя Подразделения
    private static final Random random = new Random();
    private static final HashMap<String, Integer> names = new HashMap<>();

    /**
     * Конструктор по умолчанию
     *
     * @example <pre>{@code
     *           Division div = new Division();
     *      }</pre>
     */
    public Division() {
        ID = 10000;
        name = null;
    }

    /**
     * Конструктор, принимающий параметр на вход
     *
     * @param name имя подразделения
     * @throws NullPointerException если на вход не подана строка
     * @example <pre>{@code
     *           Division div = new Division("number five");
     *      }</pre>
     */
    public Division(String name) {
        if (name == null) {
            throw new NullPointerException();
        }

        if (names.containsKey(name)) {
            this.ID = names.get(name);
        } else {
            int IDCount = generateFourDigitID(); // генерация ID
            names.put(name, IDCount);
            this.ID = IDCount;
        }

        this.name = name;
    }

    /**
     * Генератор пятизначных чисел для уникального ID
     *
     * @return пятизначное число
     */
    private int generateFourDigitID() {
        return 10000 + random.nextInt(90000);
    }

    /**
     * Метод получения ID Подразделения
     *
     * @return ID Пользователя
     */
    public int getID() {
        return ID;
    }

    /**
     * Метод получения имени Подразделения
     *
     * @return имя Подразделения
     */

    public String getName() {
        return name;
    }

    /**
     * Метод замены имени Подразделения
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Перегруженный метод toString класса Object
     *
     * @return возвращает строку с информацией об элементах сущности
     */
    @Override
    public String toString() {
        return String.format("%-2s %-13s %-7s %-1s",
                "|", ID, name,"|");
    }

    /**
     * Метод составления Заголовка для таблицы данных о Подразделении
     */
    public static void printHeader() {
        System.out.println("--------------------------");
        System.out.printf("%-2s %-10s %-10s %-1s%n",
                "|","Div_ID", "Div_Name","|");
        System.out.println("--------------------------");
    }

}
