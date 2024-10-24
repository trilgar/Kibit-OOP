package lecture10.dry.example3;

public class GoodExample {
    public class DatabaseConfig {
        public static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

        public void connect() {
            // Підключення до бази даних за допомогою DB_URL
        }
    }

    public class UserRepository {
        public void getUser(int id) {
            // Використовуємо DatabaseConfig.DB_URL для підключення
        }
    }

}
