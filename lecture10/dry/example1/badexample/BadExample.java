package lecture10.dry.example1.badexample;

import lecture10.dry.example1.User;

import java.util.HashMap;
import java.util.Map;

public class BadExample {
    public static void main(String[] args) {
        UserService userService = new UserService();
        // create 3 users and then update one of them

        userService.createUser("user1", "password1");
        userService.createUser("user2", "password2");
        userService.createUser("user3", "password3");
        System.out.println(userService.getUser(1));

        userService.updateUser(1, "user1_updated", "password1_updated");
        System.out.println(userService.getUser(1));
    }
}

class UserService {
    Map<Integer, User> users = new HashMap<>();

    public void createUser(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Некоректне ім'я користувача");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Пароль занадто короткий");
        }
        User newUser = new User(username, password);
        users.put(newUser.getId(), newUser);
    }

    public void updateUser(int id, String username, String password) {
        User user = users.get(id);

        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Некоректне ім'я користувача");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Пароль занадто короткий");
        }
        if (user == null) {
            throw new IllegalArgumentException("Користувача з id " + id + " не існує");
        }
        user.setUsername(username);
        user.setPassword(password);
    }

    public User getUser(int id) {
        return users.get(id);
    }
}

