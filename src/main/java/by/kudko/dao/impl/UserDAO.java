package by.kudko.dao.impl;

import by.kudko.dao.IUserDAO;
import by.kudko.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO implements IUserDAO {
    private final String FIND_ALL = "SELECT * FROM travel_agency.user;";
    private Connection connection;

    public UserDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAllByName(String name) {
        return null;
    }

    @Override
    public Optional<User> find(User entity) {
        return Optional.empty();
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String nickname = resultSet.getString("nickname");

                User user = new User(id, name, surname, nickname);
                users.add(user);
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
