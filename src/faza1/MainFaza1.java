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

    public static void openMenu() {
        int option = 1;
        Scanner scanner = new Scanner(System.in);
        while(option!=0) {
            System.out.println("\n\nDoriti sa:\n" +
                    "1. Vizionati toate evenimentele\n" +
                    "2. Cautati evenimente dupa nume\n" +
                    "3. Cautati evenimente dupa localtie\n" +
                    "4. Va inscrieti (deveniti client)\n" +
                    "5. Vizionati istoricul unui client\n" +
                    "6. Cumparati un bilet\n" +
                    "7. Adaugati un eveniment\n" +
                    "8. Adaugati o locatie in aer liber\n" +
                    "9. Adaugati o locatie sala\n" +
                    "10. Vizionati toate evenimentele active\n");

            option = scanner.nextInt();
            if(option == 1) {

            }
            else if(option == 2) {

            }
            else if(option == 3) {

            }
            else if(option == 4) {

            }
            else if(option == 5) {

            }
            else if(option == 6) {

            }
            else if(option == 7) {

            }
            else if(option == 8) {

            }
            else if(option == 9) {

            }
            else if(option == 10) {

            }
            else option = 0;
        }
    }
}
