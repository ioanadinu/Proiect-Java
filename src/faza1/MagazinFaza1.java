package faza1;

import model.*;
import service.MagazinService;

import java.util.List;
import java.util.stream.Collectors;

public class MagazinFaza1 implements MagazinService {
    private Magazin magazin = new Magazin();
    private IdGenerator idGenerator = new IdGenerator();

    @Override
    public List<Eveniment> findAllEvents() {
        return magazin.getEvenimente();
    }

    @Override
    public List<Eveniment> findEventsLike(String a) {
        return magazin.getEvenimente().stream()
                .filter(e -> e.getNume().contains(a))
                .collect(Collectors.toList());
    }

    @Override
    public List<Eveniment> findEventLocation(String l) {
        List<Integer> listaContinel = magazin.getLocatii().stream()
                .filter(e -> e.getAdresa().contains(l))
                .map(e -> e.getId())
                .collect(Collectors.toList());
        return magazin.getEvenimente().stream()
                .filter(e -> listaContinel.contains(e.getIdLocatie()))
                .collect(Collectors.toList());
    }

    @Override
    public void addClient(Persoana p, String parola) {
        Client c = new Client(p.getNume(), p.getEmail(),idGenerator.getIdClient() , parola);
    }

    @Override
    public List<Eveniment> findEventsClientGotTicketFor(Integer id) {
        return magazin.getBilete().stream()
                .filter(b -> b.getIdClient().equals(id))
                .map(b -> b.getEveniment())
                .collect(Collectors.toList());
    }

    @Override
    public Bilet buyTicket(Client c, Eveniment e, String tipLoc) {
        Bilet b = new Bilet(idGenerator.getIdBilet(), c.getId(), tipLoc, e);
        magazin.getBilete().add(b);
        return b;
    }

    @Override
    public void addEvent( Integer idLocatie, String nume, String data, Boolean status) {
        Eveniment e = new Eveniment(idGenerator.getIdEveniment(), idLocatie, nume, data, status);
        magazin.getEvenimente().add(e);
    }

    @Override
    public void addLocation( String adresa, Integer nrScaune) {
        Sala l = new Sala( idGenerator.getIdLocatie(),  adresa,  nrScaune);
        magazin.getLocatii().add(l);
    }

    public void addLocation( String adresa, Integer nrScaune, Integer nrLocuriPicioare) {
        LocatieInAerLiber l = new LocatieInAerLiber(idGenerator.getIdLocatie(), adresa, nrScaune, nrLocuriPicioare);
        magazin.getLocatii().add(l);
    }


    @Override
    public void eventIsFinished(Eveniment e) {
        e.setStatus(false);

    }

    @Override
    public List<Eveniment> findAllActiveEvents() {
//        List<Eveniment> activeEvents = new ArrayList<>();
////        for(Eveniment e : magazin.getEvenimente())
////            if(e.getStatus())
////                activeEvents.add(e);
//        magazin.getEvenimente().stream()
//                .filter(e -> e.getStatus())
//                .map(e -> activeEvents.add(e));
//        return activeEvents;
        return magazin.getEvenimente().stream()
                .filter(e -> e.getStatus())
                .collect(Collectors.toList());
        //nu facem atribuiri de referinte in lambda expresie!!!!
    }
}
