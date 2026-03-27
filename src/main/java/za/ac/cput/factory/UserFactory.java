package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;;

public class UserFactory {
    public static User createUser(String userId, String userName, String password) {
        if (Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(userName) || Helper.isNullOrEmpty(password))
            return null;


        return new User.Builder().setUserId(userId).setUserName(userName).setPassword(password).build();
    }
}
