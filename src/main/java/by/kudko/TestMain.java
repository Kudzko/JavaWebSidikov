package by.kudko;

import by.kudko.dao.impl.UserDAO;
import by.kudko.util.DButil;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class TestMain {
    public static void main(String[] args) {


        UserDAO userDAO = new UserDAO(DButil.getConnectionDataSource());
        System.out.println(userDAO.findAll());
    }
}
