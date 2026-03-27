
/*
User Repository implements IRepository interface
Author: Aneeqah Talaaboedien (219099405)
Date March 2026
 */

package za.ac.cput.repository;
import za.ac.cput.domain.User;
import java.util.List;

public interface IUserRepository  extends IRepository <User, String>{
    List<User> getAll();

    User create(User user);
}
