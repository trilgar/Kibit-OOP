package lecture10.yagni.example2;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class BadExample {
    public interface DataStorage {
        void save(String data);
        String load(String id);
    }

    public class FileSystemStorage implements DataStorage {
        @Override
        public void save(String data) {
            // Збереження даних у файл
            try{
                PrintWriter writer = new PrintWriter("data.txt");
                writer.println(data);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public String load(String path) {
            // Завантаження даних з файлу
            try{
                return Files.readString(Path.of(path), StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public class DatabaseStorage implements DataStorage {
        @Override
        public void save(String data) {
            // Збереження даних у базу даних
            return;
        }

        @Override
        public String load(String id) {
            // Завантаження даних з бази даних
            return null;
        }
    }

}
