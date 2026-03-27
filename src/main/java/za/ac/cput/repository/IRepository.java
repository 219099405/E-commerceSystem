


/*
Repository Interface
Author: Aneeqah Talaaboedien (219099405)
Date March 2026
 */

package za.ac.cput.repository;
import za.ac.cput.domain.User;

import java.util.List;

public interface IRepository <T, ID> {//aneeqah talaaboedien 219099405
    T create (T t);
    T read (ID id);
    T update (T t);
    boolean delete (ID id);


    List<T> getAll();   //Pertunia Sifunda
}
