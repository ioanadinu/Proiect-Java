package faza3.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    private final String URL = "jdbc:postgresql:magazin";
    private final String USER = "postgres";
    private final String PASSWORD = "polpol123";

    private Connection connection;

    private DatabaseConnection() {
        try {
            Properties props = new Properties();

            props.setProperty("user", USER);

            props.setProperty("password",PASSWORD);

            props.setProperty("stringtype", "unspecified");
            this.connection = DriverManager.getConnection(URL,props);
        }
        catch (Exception e) {
            System.out.println("Connection failure");
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if(instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
