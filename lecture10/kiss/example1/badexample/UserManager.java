package lecture10.kiss.example1.badexample;

import lecture10.kiss.example1.User;

public class UserManager {
    public boolean isUserActive(User user) {
        if (user != null) {
            if (user.status() != null) {
                if (user.status().equals("ACTIVE")) {
                    return true;
                }
            }
        }
        return false;
    }
}

