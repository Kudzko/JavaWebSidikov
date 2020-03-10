package by.kudko.dao;

import by.kudko.model.User;

import java.util.List;

public interface IUserDAO extends ICrudDAO<User> {
    List<User> findAllByName(String name);
}
