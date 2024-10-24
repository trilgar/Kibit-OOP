package lecture10.dry.example3;

public class BadExample {
    public class DatabaseConfig {
        public void connect() {
            String url = "jdbc:mysql://localhost:3306/mydb";
            // Підключення до бази даних
        }
    }

    public class UserRepository {
        public void getUser(int id) {
            String url = "jdbc:mysql://localhost:3306/mydb";
            // Виконання запиту до бази даних
        }
    }

}
