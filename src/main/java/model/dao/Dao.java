package model.dao;

import java.util.List;

public interface Dao <E, T> {

    void create(E entity);

    List<E> read();

    List<E> readAll();

    void delete(T key);

}
