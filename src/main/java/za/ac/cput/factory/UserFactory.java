
/*
Aneeqah Talaaboedien
Student number 219099405
March 2026
*/

package za.ac.cput.factory;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;;

public class UserFactory {
    public static User createUser(String userId,
                                  String userName,
                                  String email,
                                  String password) {

        if (Helper.isNullOrEmpty(userId) ||
                Helper.isNullOrEmpty(userName) ||
                Helper.isNullOrEmpty(email)||
                Helper.isNullOrEmpty(password))
            return null;



        return new User.Builder().
                setUserId(userId).
                setUserName(userName).
                setEmail(email).
                setPassword(password).
                build();
    }}