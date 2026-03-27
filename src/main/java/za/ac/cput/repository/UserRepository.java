/*
User Repository implements IuserRepository
Author: Aneeqah Talaaboedien (219099405)
Date March 2026
 */

package za.ac.cput.repository;
import za.ac.cput.domain.User;
import java.util.ArrayList;
import java.util.List;


public class UserRepository implements IUserRepository{

    //Singleton
    private static IUserRepository repository = null;
    private List<User> usersLists;

    //Declaring Constructor to construct ArrayList
    private UserRepository() {
        usersLists = new ArrayList<User>();
    }

    public static IUserRepository getRepository() {
        if (repository == null) {
            repository = new UserRepository();
        }
        return repository;
    }

    @Override
    public List<User> getAll() {
        return usersLists;
    }

    @Override
    public User create(User user) {
        usersLists.add(user);
        return user;
    }


    @Override
    public User read(String Name) {
        for (User user : usersLists) {
            if (user.getUserName().equals(Name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User update(User user) {
        String Name = user.getUserName();
        User oldUser = read(Name);
        if (oldUser == null)
            return null;

        boolean success = delete(Name);
        if (success) {
            if (usersLists.add(user))
                return user;
        }
        return null;
    }

    @Override
    public boolean delete(String Name) {
        User userToDelete = read(Name);
        if (userToDelete == null)
            return false;
        return usersLists.remove(userToDelete);
    }
}
