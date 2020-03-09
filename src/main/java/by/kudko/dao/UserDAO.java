package by.kudko.dao;

import by.kudko.model.User;

import java.util.List;

public interface UserDAO  extends CrudDAO<User>{
    List<User> findAllByName(String name);
}
