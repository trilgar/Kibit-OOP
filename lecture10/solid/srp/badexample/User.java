package lecture10.solid.srp.badexample;

import java.util.List;

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

    // Порушення SRP: Клас User відповідає за збереження до бази даних
    public void save(List<User> database) {
        database.add(this);
    }

    // Порушення SRP: Клас User відповідає за відправку email-сповіщення
    public void sendNotification() {
        System.out.println("Sending email to " + this.email);
    }
}
