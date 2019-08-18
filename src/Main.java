import model.*;

public class Main {

    public static void main(String[] args) {
        Persoana p = new Persoana("Andrei", "mailAndrei");
        //Persoana p2 = new Persoana("Andrei", "mailAndrei");
        Persoana p2 = new Persoana("Mihai", "mailMihai");
        System.out.println(p);
        System.out.println(p2);
        Client c = new Client("Maria", "emailMaria", 7,"parolaMaria" );
        Client c2 = new Client("Maria", "emailMaria", 7,"parolaMaria" );
        //Client c2 = new Client("Aria", "emailAria", 8,"parolaAria" );
        System.out.println(c);
        System.out.println(c2);
        if(c.equals(c2))
            System.out.println("p = p2");
        else
            System.out.println("p != p2");

    };
}

