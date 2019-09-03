package faza3.test;

import faza3.repository.DatabaseConnection;
import faza3.repository.IdGeneratorRepoJDBC;
import model.IdGenerator;

import java.sql.SQLException;

public class ConnectionTest{
    public static void main(String[] args) throws SQLException {
        IdGeneratorRepoJDBC idGeneratorRepoJDBC = new IdGeneratorRepoJDBC();
        IdGenerator idGenerator = idGeneratorRepoJDBC.getIdGenerator();
        System.out.println(idGenerator);
        DatabaseConnection.getInstance().getConnection().close();
    }
}
