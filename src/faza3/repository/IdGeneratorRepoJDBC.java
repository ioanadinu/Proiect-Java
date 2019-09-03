package faza3.repository;

import model.IdGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IdGeneratorRepoJDBC {
    Connection connection = DatabaseConnection.getInstance().getConnection();

    public IdGenerator getIdGenerator() {
        IdGenerator idGenerator = new IdGenerator();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT bilet_id, client_id, eveniment_id, locatie_id FROM id_generator";
            ResultSet resultSet = statement.executeQuery(sql);
            int b = 0;
            while (resultSet.next()) {
                idGenerator.setIdBilet(resultSet.getInt("bilet_id")-1);
                idGenerator.setIdClient(resultSet.getInt("client_id")-1);
                idGenerator.setIdEveniment(resultSet.getInt("eveniment_id")-1);
                idGenerator.setIdLocatie(resultSet.getInt("locatie_id")-1);
                b++;
            }
            if(b!=1) throw new RuntimeException("idGenerator has too many rows");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(statement!=null) statement.close();
                return idGenerator;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                return idGenerator;
            }
        }
    }

    public void updateIdGenerator(IdGenerator idGenerator) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "UPDATE id_generator SET "+
                    "bilet_id="+idGenerator.getIdBilet().toString()+
                    ",client_id="+idGenerator.getIdClient().toString()+
                    ",eveniment_id="+idGenerator.getIdEveniment().toString()+
                    ",locatie_id="+idGenerator.getIdLocatie().toString();
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(statement!=null) statement.close();
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
