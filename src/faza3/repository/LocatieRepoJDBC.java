package faza3.repository;

import model.IdGenerator;
import model.Locatie;
import model.LocatieInAerLiber;
import model.Sala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocatieRepoJDBC {
    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public List<Locatie> getAllLocations() {
        List<Locatie> locatieList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT locatie_id, adresa, nr_scaune, nr_locuri_picioare FROM locatii;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Locatie locatie = null;
                Integer locatieId = resultSet.getInt("locatie_id");
                String adresa = resultSet.getString("adresa");
                Integer nrScaune = resultSet.getInt("nr_scaune");
                Integer nrLocuriPicioare = resultSet.getInt("nr_locuri_picioare");
                if(resultSet.wasNull()) {
                    locatie = new Sala(locatieId,adresa,nrScaune);
                }
                else {
                    locatie = new LocatieInAerLiber(locatieId,adresa,nrScaune,nrLocuriPicioare);
                }
                locatieList.add(locatie);
            }
            return locatieList;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return locatieList;
        }
        finally {
            try {
                if(statement!=null) statement.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Locatie> getByAdressLike(String param) {
        List<Locatie> locatieList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT locatie_id, adresa, nr_scaune, nr_locuri_picioare FROM locatii " +
                    "WHERE adresa LIKE '%"+param+"%';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Locatie locatie = null;
                Integer locatieId = resultSet.getInt("locatie_id");
                String adresa = resultSet.getString("adresa");
                Integer nrScaune = resultSet.getInt("nr_scaune");
                Integer nrLocuriPicioare = resultSet.getInt("nr_locuri_picioare");
                if(nrLocuriPicioare!=null) {
                    locatie = new LocatieInAerLiber(locatieId,adresa,nrScaune,nrLocuriPicioare);
                }
                else {
                    locatie = new Sala(locatieId,adresa,nrScaune);
                }
                locatieList.add(locatie);
            }
            return locatieList;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return locatieList;
        }
        finally {
            try {
                if(statement!=null) statement.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addLocatie(String adresa,Integer nrScaune,Integer nrLocuriPicioare) {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO locatii VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            IdGeneratorRepoJDBC idGeneratorRepo = new IdGeneratorRepoJDBC();
            IdGenerator idGenerator = idGeneratorRepo.getIdGenerator();
            preparedStatement.setInt(1, idGenerator.getIdLocatie());
            preparedStatement.setString(2, adresa);
            preparedStatement.setInt(3, nrScaune);
            preparedStatement.setInt(4, nrLocuriPicioare);

            idGeneratorRepo.updateIdGenerator(idGenerator);
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(preparedStatement!=null) preparedStatement.close();
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addLocatie(String adresa, Integer nrScaune) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            IdGeneratorRepoJDBC idGeneratorRepo = new IdGeneratorRepoJDBC();
            IdGenerator idGenerator = idGeneratorRepo.getIdGenerator();
            String sql = "INSERT INTO locatii VALUES ("+
                    idGenerator.getIdLocatie().toString()+","+
                    "'"+adresa+"',"+nrScaune.toString()+",NULL);";
            idGeneratorRepo.updateIdGenerator(idGenerator);
            statement.executeQuery(sql);
        }
        catch (Exception e) {
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

    public void updateLocatie(Locatie locatie) {
        if(locatie instanceof LocatieInAerLiber) updateLocatieInAerLiber((LocatieInAerLiber) locatie);
        else if(locatie instanceof Sala) updateSala((Sala) locatie);
    }

    private void updateLocatieInAerLiber(LocatieInAerLiber locatieInAerLiber) {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE locatii SET adresa=?,nr_scaune=?,nr_locuri_picioare=? " +
                    "WHERE id="+locatieInAerLiber.getId().toString();
            preparedStatement = connection.prepareStatement(sql);
            IdGeneratorRepoJDBC idGeneratorRepo = new IdGeneratorRepoJDBC();
            IdGenerator idGenerator = idGeneratorRepo.getIdGenerator();
            preparedStatement.setInt(1,idGenerator.getIdLocatie());
            preparedStatement.setString(2,locatieInAerLiber.getAdresa());
            preparedStatement.setInt(3,locatieInAerLiber.getNrScaune());
            preparedStatement.setInt(4,locatieInAerLiber.getNrLocuriPicioare());

            preparedStatement.executeUpdate();
            idGeneratorRepo.updateIdGenerator(idGenerator);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(preparedStatement!=null) preparedStatement.close();
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void updateSala(Sala sala) {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE locatii SET adresa=?,nr_scaune=? " +
                    "WHERE id="+sala.getId().toString();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sala.getAdresa());
            preparedStatement.setInt(2,sala.getNrScaune());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(preparedStatement!=null) preparedStatement.close();
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteById(Integer id){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "DELETE FROM locatii WHERE locatie_id="+id+";";

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

    public void deleteAll(){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "DELETE FROM locatii;";

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
