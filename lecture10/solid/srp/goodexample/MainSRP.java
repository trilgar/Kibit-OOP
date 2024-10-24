package lecture10.solid.srp.goodexample;

import java.util.ArrayList;
import java.util.List;

public class MainSRP {
    public static void main(String[] args) {
        User user = new User("john_doe", "john@example.com");

        UserRepository userRepository = new UserRepository();
        NotificationService notificationService = new NotificationService();

        // Збереження користувача
        userRepository.save(user);

        // Відправка сповіщення
        notificationService.sendNotification(user);
    }
}

class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

// Відповідає за збереження користувачів
class UserRepository {
    private List<User> database = new ArrayList<>();

    public void save(User user) {
        database.add(user);
        System.out.println("User " + user.getUsername() + " saved to database.");
    }

    public List<User> getAllUsers() {
        return database;
    }
}

// Відповідає за сповіщення
class NotificationService {
    public void sendNotification(User user) {
        System.out.println("Sending email to " + user.getEmail());
    }
}



