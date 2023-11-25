package mishka.workingWithCollections;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * Класс CVSReader представляет собой реализацию записи csv файла в список.
 * Запись производится в класс Human
 *
 * @author Mishka2374
 */
public class CVSReader {

    /**
     * Метод для заполнения списка из файла формата CSV
     *
     * @param humans список людей
     * @param csvFilePath путь до файла
     * @param separator разделитель
     * @throws RuntimeException не удалось прочесть файл
     */
    public static void input(ArrayList<Human> humans, final String csvFilePath, final char separator) {
        try (InputStream in = CVSReader.class.getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null : new CSVReaderBuilder(new InputStreamReader(in))
                     .withCSVParser(new CSVParserBuilder()
                             .withSeparator(separator)
                             .build()
                     ).build()) {
            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }

            String[] nextLine;
            nextLine=reader.readNext();
            Human.identify(nextLine); // первая строка CVS содержит имена переменных Заголовка
            while ((nextLine = reader.readNext()) != null) {
                humans.add(new Human(nextLine));
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException("CSV validation failed: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + e.getMessage());
        }
    }

}
