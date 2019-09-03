package faza3;

import faza3.repository.*;
import model.*;
import service.MagazinService;

import java.sql.SQLException;
import java.util.List;

public class MagazinServiceFaza3 implements MagazinService {
    private BiletRepoJDBC biletRepo = new BiletRepoJDBC();
    private ClientRepoJDBC clientRepoJDBC = new ClientRepoJDBC();
    private EvenimentRepoJDBC evenimentRepoJDBC = new EvenimentRepoJDBC();
    private LocatieRepoJDBC locatieRepoJDBC = new LocatieRepoJDBC();


    @Override
    public List<Eveniment> findAllEvents() {
        return evenimentRepoJDBC.getAllEvents();
    }

    @Override
    public List<Eveniment> findEventsLike(String a) {
        return null;
    }

    @Override
    public List<Eveniment> findEventLocation(String l) {
        return null;
    }

    @Override
    public void addClient(Persoana p, String parola) {
        clientRepoJDBC.addClient(p, parola);
    }

    @Override
    public List<Eveniment> findEventsClientGotTicketFor(Integer id) {
        return null;
    }

    @Override
    public Bilet buyTicket(Client c, Eveniment e, String tipLoc) {
        return null;
    }

    @Override
    public void addEvent(Integer idLocatie, String nume, String data, Boolean status) {

    }

    @Override
    public void addLocation(String adresa, Integer nrScaune, Integer nrLocuriPicioare) {
        locatieRepoJDBC.addLocatie(adresa,nrScaune,nrLocuriPicioare);
    }

    @Override
    public void addLocation(String adresa, Integer nrScaune) {
        locatieRepoJDBC.addLocatie(adresa, nrScaune);
    }

    @Override
    public void eventIsFinished(Eveniment e) {

    }

    @Override
    public List<Eveniment> findAllActiveEvents() {
        return null;
    }

    public void openMagazin() {
        //daca exista vreo logica de inceput, aici sa fie
    }

    public void closeMagazin() {
        try {
            DatabaseConnection.getInstance().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
