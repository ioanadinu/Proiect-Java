package service;

import model.*;

import java.util.List;

public interface MagazinService {
   List<Eveniment> findAllEvents();
   List<Eveniment> findEventsLike(String a);
   List<Eveniment> findEventLocation(String l);
   void addClient(Persoana p, String parola);
   List<Eveniment> findEventsClientGotTicketFor(Integer id);
   Bilet buyTicket(Client c, Eveniment e, String tipLoc);
   void addEvent( Integer idLocatie, String nume, String data, Boolean status);
   void addLocation( String adresa, Integer nrScaune, Integer nrLocuriPicioare);
   void addLocation( String adresa, Integer nrScaune);
   void eventIsFinished(Eveniment e);
   List<Eveniment> findAllActiveEvents();



}
