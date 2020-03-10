package by.kudko.util;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {
    public static Connection getConnection(){
        Connection connection = null;
        Properties dbProperties = new Properties();
        try {
            dbProperties.load(new FileInputStream("src/main/resources/db.properties"));
            String url = dbProperties.getProperty("db.url");
            String dbUser = dbProperties.getProperty("db.username");
            String dbPass = dbProperties.getProperty("db.pass");
            String driverClass = dbProperties.getProperty("db.driverclass");

            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, dbUser,dbPass);
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        } catch (IOException exception){
            exception.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;

    }

    public static DriverManagerDataSource getConnectionDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Properties dbProperties = new Properties();
        try {
            dbProperties.load(new FileInputStream("src/main/resources/db.properties"));
            String url = dbProperties.getProperty("db.url");
            String dbUser = dbProperties.getProperty("db.username");
            String dbPass = dbProperties.getProperty("db.pass");
            String driverClass = dbProperties.getProperty("db.driverclass");

            dataSource.setUrl(url);
            dataSource.setUsername(dbUser);
            dataSource.setPassword(dbPass);
            dataSource.setDriverClassName(driverClass);
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        } catch (IOException exception){
            exception.printStackTrace();
        }

        return dataSource;

    }


}
