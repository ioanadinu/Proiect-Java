package test;
import model.*;

public class MainLocatie {
    public static void main(String[] args) {
//        Locatie l1 = new Locatie(4, "adresa1");
//        Locatie l2 = new Locatie(4, "adresa1");
//        System.out.println(l1);
//        System.out.println(l2);
//        if(l1.equals(l2))
//            System.out.println("l1 = l2");
//        else
//            System.out.println("l1 != l2");
        Locatie la = new LocatieInAerLiber(12,"adresa outside",10,20);
        Locatie sala = new Sala(11,"adresa inside", 20);
        System.out.println(la);
        System.out.println(sala);



    }

}
