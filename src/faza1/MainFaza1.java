package faza1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.*;

public class MainFaza1 {
    public static void main(String[] args) {
        MagazinFaza1 magazinFaza1 = new MagazinFaza1();
        //Scanner
        Scanner citeste = new Scanner(System.in);

//        Persoana p1 = new Persoana(citeste.next(), citeste.next());
//        Persoana p2 = new Persoana(citeste.next(), citeste.next());

//        magazinFaza1.addClient(p1,"parola1");
//        magazinFaza1.addClient(p2,"parola2");
//
//        System.out.println("Numar de scaune:");
//        magazinFaza1.addLocation("adresa1", Integer.valueOf(citeste.next()));
//        System.out.println("Numar de scaune si numar de locuri in picioare:");
//        magazinFaza1.addLocation("adresa2", Integer.valueOf(citeste.next()), Integer.valueOf(citeste.next()));
//        magazinFaza1.addEvent(1,"event1", "20190521", true);
//        magazinFaza1.addEvent(1,"event2", "20190526", true);
//        magazinFaza1.addEvent(2,"event3", "20190121", false);

//        List<Eveniment> events = magazinFaza1.findAllActiveEvents();
//        for(Eveniment ev : events) {
//            if(ev.getId().equals(1))
//                magazinFaza1.eventIsFinished(ev);
//        }
        String arataMeniu;
        System.out.println("Doriti sa vedeti meniul?(Da/Nu)");
        arataMeniu = citeste.next();
        if(arataMeniu.equals("Da"))
            openMenu();
        else
            System.out.println("Multumim!");
    }

    public static void openMenu() {
        int option = 1;
        MagazinFaza1 magazinFaza1 = new MagazinFaza1();
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
                    "10. Vizionati toate evenimentele active\n"+
                    "11. Am terminat!");

            option = scanner.nextInt();
            if(option == 1) {
                System.out.println(magazinFaza1.findAllEvents());
            }
            else if(option == 2) {
                System.out.println("Dati numele evenimentului: ");
                System.out.println(magazinFaza1.findEventsLike(scanner.next()));

            }
            else if(option == 3) {
                System.out.println("Dati numele locatiei: ");
                System.out.println(magazinFaza1.findEventLocation(scanner.next()));
            }
            else if(option == 4) {
                System.out.println("Dati numele: ");
                String numeAux = scanner.next();
                System.out.println("Dati emailul: ");
                String emailAux = scanner.next();
                System.out.println("Dati parola: ");
                String parolaAux = scanner.next();
                Persoana p = new Persoana(numeAux, emailAux);
                magazinFaza1.addClient(p, parolaAux);
            }
            else if(option == 5) {
                System.out.println("Dati id-ul clientului: ");
                System.out.println(magazinFaza1.findEventsClientGotTicketFor(scanner.nextInt()));
            }
            else if(option == 6) {

            }
            else if(option == 7) {
                //System.out.println("Dati id-ul locatiei: ");//o sa cer numele si apoi o sa caut eu id-ul
                //Integer idAux = scanner.nextInt();
                //------
                System.out.println("Dati adresa locatiei: ");
                String numeLocatie;
                numeLocatie = scanner.next();
                Integer idLocatie = magazinFaza1.getMagazin().getLocatii().stream()
                        .filter(l -> l.getAdresa().equals(numeLocatie))
                        .map(l -> l.getId())
                        .findFirst().orElseThrow(()->new RuntimeException("locatie nu a fost gasita"));

                //------
                System.out.println("Dati numele evenimentului: ");
                String numeAux = scanner.next();
                System.out.println("Dati data evenimentului: "); //transient
                String dataAux = scanner.next();// data va fi de forma "aaaallzz"
                magazinFaza1.addEvent(idLocatie, numeAux,dataAux, true);
            }
            else if(option == 8) {
                System.out.println("Dati adresa locatiei: ");
                String adresaAux = scanner.next();
                System.out.println("Dati numarul de locuri(scaune): ");
                Integer nrScaune = scanner.nextInt();
                System.out.println("Dati numarul de locuri(in picioare): ");
                Integer nrLocuriP = scanner.nextInt();
                magazinFaza1.addLocation(adresaAux,nrScaune,nrLocuriP);
            }
            else if(option == 9) {
                System.out.println("Dati adresa locatiei: ");
                String adresaAux = scanner.next();
                System.out.println("Dati numarul de locuri(scaune): ");
                Integer nrScaune = scanner.nextInt();
                magazinFaza1.addLocation(adresaAux,nrScaune);
            }
            else if(option == 10) {
                System.out.println(magazinFaza1.findAllActiveEvents());
            }
            else option = 0;
        }
    }
}
