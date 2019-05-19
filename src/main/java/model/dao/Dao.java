package model.dao;

import java.util.List;

public interface Dao <E> extends AutoCloseable{

    void create(E entity);

    List<E> read(Integer id);

    List<E> readAll();

    void update(Integer id, E entity);

    void delete(Integer id);

    @Override
    void close();
}
