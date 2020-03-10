package by.kudko.dao;


import java.util.List;
import java.util.Optional;

public interface ICrudDAO<T> {
    Optional<T> find(T entity);

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> findAll();

}
