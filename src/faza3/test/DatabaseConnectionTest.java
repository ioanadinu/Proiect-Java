package faza3.test;

import faza3.repository.DatabaseConnection;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        DatabaseConnection.getInstance().getConnection();
    }
}
