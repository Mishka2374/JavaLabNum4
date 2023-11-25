package mishka;

import mishka.workingWithCollections.CVSReader;
import mishka.workingWithCollections.Division;
import mishka.workingWithCollections.Human;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Класс menu представляет собой реализацию работы "меню" упрощённой работы
 * с чем-либо. В данном случае нам дан CSV файл, который содержит в себе информацию о людях.
 * Нужно считать данные о людях из этого файла в список.
 *
 * @author Mishka2374
 */
public class menu {
    /**
     * Метод для реализации составления файла в список
     */
    public static void answer()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте, Вас приветствует МЕНЮ по реализации файла в список");
        System.out.println("Выберите действие:");
        System.out.println("1) Переместить файлы в список - нажмите \"1\"");
        System.out.println("2) Посмотреть Людей в виде Базы Данных - нажмите \"2\"");
        System.out.println("3) Посмотреть Подразделения в виде Базы Данных - нажмите \"3\"");
        System.out.println("4) Стереть данные - нажмите \"4\"");
        System.out.println("Выход - нажмите любое отрицательное число");
        int x;
        ArrayList<Human> humans = new ArrayList<>();
        do {
            System.out.println("\nВернуться в меню - \"0\" \t Выход - \"-1\"");
            x = scanner.nextInt();
            switch (x) {
                case 0:
                    System.out.println("Выберите действие:");
                    System.out.println("1) Переместить файлы в список - нажмите \"1\"");
                    System.out.println("2) Посмотреть Людей в виде Базы Данных - нажмите \"2\"");
                    System.out.println("3) Посмотреть Подразделения в виде Базы Данных - нажмите \"3\"");
                    System.out.println("4) Стереть данные - нажмите \"4\"");
                    System.out.println("Выход - нажмите любое отрицательное число");
                    break;
                case 1:
                    System.out.println("Из какого файла хотите взять данные?\n 1) foreign_name_one.csv - нажмите \\\"1\\\"\"" +
                            "\n 2)foreign_name.csv- нажмите \\\"2\\\"\" \n ");
                    int y;
                    do {
                        y = scanner.nextInt();
                        if (y != 1 && y != 2) {
                            System.out.println("Неправильно введено число, повторите:");
                        }
                    } while (y != 1 && y != 2);
                    if (y == 1) {
                        CVSReader.input(humans, "foreign_name_one.csv", ';');
                    } else {
                        CVSReader.input(humans, "foreign_names.csv", ';');
                    }
                    System.out.println("Выберите действие:");
                    System.out.println("2) Посмотреть Людей в виде Базы Данных - нажмите \"2\"");
                    System.out.println("3) Посмотреть Подразделения в виде Базы Данных - нажмите \"3\"");
                    System.out.println("4) Стереть данные - нажмите \"4\"");
                    break;
                case 2:
                    Human.printHeader();
                    for (Human human: humans) {
                        System.out.println(human.toString());
                    }
                    break;
                case 3:
                    Division.printHeader();
                    for (Human human: humans){
                        System.out.println(human.printDivisionName());
                    }
                    break;
                case 4:
                    humans.clear();
                    break;
                default:
                    System.out.println("До свидания!");
            }

        } while (x >= 0);
    }

}
