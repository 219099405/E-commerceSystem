package za.ac.cput.repository;

import java.util.List;

/*
 * IRepository.java
 * Pertunia Sifunda (221692568)
 */

public interface IRepository<T, ID> {

    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);

    List<T> getAll();

}