package faza2;

import java.util.*;
import java.util.stream.Collectors;

import model.*;

public class MainFaza2 {
    public static void main(String[] args) {
        MagazinFaza2 magazinFaza2 = new MagazinFaza2();

        magazinFaza2.open();

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
                    "10. Vizionati toate evenimentele active\n"+
                    "11. Am terminat!");

            option = scanner.nextInt();
            if(option == 1) {
                System.out.println(magazinFaza2.findAllEvents());
            }
            else if(option == 2) {
                System.out.println("Dati numele evenimentului: ");
                System.out.println(magazinFaza2.findEventsLike(scanner.next()));

            }
            else if(option == 3) {
                System.out.println("Dati numele locatiei: ");
                System.out.println(magazinFaza2.findEventLocation(scanner.next()));
            }
            else if(option == 4) {
                System.out.println("Dati numele: ");
                String numeAux = scanner.next();
                System.out.println("Dati emailul: ");
                String emailAux = scanner.next();
                System.out.println("Dati parola: ");
                String parolaAux = scanner.next();
                Persoana p = new Persoana(numeAux, emailAux);
                magazinFaza2.addClient(p, parolaAux);
            }
            else if(option == 5) {
                System.out.println("Dati id-ul clientului: ");
                System.out.println(magazinFaza2.findEventsClientGotTicketFor(scanner.nextInt()));
            }
            else if(option == 6) {
                System.out.println("Dati numele clientului: ");
                String numeClient = scanner.next();
                System.out.println("Dati parola clientului: ");
                String parola = scanner.next();
                System.out.println("Dati numele evenimentului: ");
                String numeEven = scanner.next();
                System.out.println("Dati data evenimentului: ");
                String data = scanner.next();
                System.out.println("Dati tipul de loc: (scaun/picioare)");
                String loc = scanner.next();
                List<Client> clienti = new ArrayList<>(magazinFaza2.getMagazin().getClienti().values());
                Client c = clienti.stream().filter(x -> x.getNume().equals(numeClient))
                        .filter(x -> x.getParola().equals(parola))
                        .findFirst().orElseThrow(()->new RuntimeException("clientul nu a fost gasit"));
                //System.out.println(c);
                Eveniment e = magazinFaza2.getMagazin().getEvenimente().stream()
                        .filter(x -> x.getNume().equals(numeEven))
                        .filter(x -> x.getData().equals(data))
                        .findFirst().orElseThrow(()->new RuntimeException("evenimentul nu a fost gasit"));
                System.out.println("Biletul cumparat este ");
                System.out.println(magazinFaza2.buyTicket(c,e,loc));

            }
            else if(option == 7) {
                //System.out.println("Dati id-ul locatiei: ");//o sa cer numele si apoi o sa caut eu id-ul
                //Integer idAux = scanner.nextInt();
                //------
                System.out.println("Dati adresa locatiei: ");
                String numeLocatie;
                numeLocatie = scanner.next();
                Integer idLocatie = magazinFaza2.getMagazin().getLocatii().stream()
                        .filter(l -> l.getAdresa().equals(numeLocatie))
                        .map(l -> l.getId())
                        .findFirst().orElseThrow(()->new RuntimeException("locatia nu a fost gasita"));

                //------
                System.out.println("Dati numele evenimentului: ");
                String numeAux = scanner.next();
                System.out.println("Dati data evenimentului: "); //transient
                String dataAux = scanner.next();// data va fi de forma "aaaallzz"
                magazinFaza2.addEvent(idLocatie, numeAux,dataAux, true);
            }
            else if(option == 8) {
                System.out.println("Dati adresa locatiei: ");
                String adresaAux = scanner.next();
                System.out.println("Dati numarul de locuri(scaune): ");
                Integer nrScaune = scanner.nextInt();
                System.out.println("Dati numarul de locuri(in picioare): ");
                Integer nrLocuriP = scanner.nextInt();
                magazinFaza2.addLocation(adresaAux,nrScaune,nrLocuriP);
            }
            else if(option == 9) {
                System.out.println("Dati adresa locatiei: ");
                String adresaAux = scanner.next();
                System.out.println("Dati numarul de locuri(scaune): ");
                Integer nrScaune = scanner.nextInt();
                magazinFaza2.addLocation(adresaAux,nrScaune);
            }
            else if(option == 10) {
                System.out.println(magazinFaza2.findAllActiveEvents());
            }
            else option = 0;
        }

        magazinFaza2.open();

    }
}
