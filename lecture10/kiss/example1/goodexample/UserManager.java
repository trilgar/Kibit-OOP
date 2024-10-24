package lecture10.kiss.example1.goodexample;

import lecture10.kiss.example1.User;

public class UserManager {
    public boolean isUserActive(User user) {
        return user != null && "ACTIVE".equals(user.status());
    }
}

