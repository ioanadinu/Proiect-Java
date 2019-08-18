package faza1;

import java.util.List;
import java.util.Scanner;
import model.*;

public class MainFaza1 {
    public static void main(String[] args) {
        MagazinFaza1 magazinFaza1 = new MagazinFaza1();
        //Scanner
        Scanner citeste = new Scanner(System.in);
        //citeste.next
        //verificare metode
        //subiecte examennnnn
        //-------------------
        Persoana p1 = new Persoana("Ana","emailAna");
        Persoana p2 = new Persoana("Bogdan","emailBogdan");

//        Persoana p1 = new Persoana(citeste.next(), citeste.next());
//        Persoana p2 = new Persoana(citeste.next(), citeste.next());

        magazinFaza1.addClient(p1,"parola1");
        magazinFaza1.addClient(p2,"parola2");

        System.out.println("Numar de scaune:");
        magazinFaza1.addLocation("adresa1", Integer.valueOf(citeste.next()));
        System.out.println("Numar de scaune si numar de locuri in picioare:");
        magazinFaza1.addLocation("adresa2", Integer.valueOf(citeste.next()), Integer.valueOf(citeste.next()));
        magazinFaza1.addEvent(1,"event1", "20190521", true);
        magazinFaza1.addEvent(1,"event2", "20190526", true);
        magazinFaza1.addEvent(2,"event3", "20190121", false);

//        List<Eveniment> events = magazinFaza1.findAllActiveEvents();
//        for(Eveniment ev : events) {
//            if(ev.getId().equals(1))
//                magazinFaza1.eventIsFinished(ev);
//        }
        System.out.println(magazinFaza1.findAllActiveEvents());


        //cum iau clientii???? o noua metoda in MagazinService?---------------------------------??
        //System.out.println(magazinFaza1.findEventsClientGotTicketFor(1));


        System.out.println(magazinFaza1.findEventLocation("1"));


    }
}
