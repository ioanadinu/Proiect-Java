package faza2.repositoryCSV;


import faza2.MagazinFaza2;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class RWBilet {
    ReadWrite buffer = new ReadWrite();// daca metoda nu e statica, declar o instanta
    String fisierBilete = "dateBilete.txt";


    public ArrayList<Bilet> rBilet(Magazin magazin){
        ArrayList<Bilet> listaBilete = new ArrayList<>();
        List<List<String>> matrice = buffer.read(fisierBilete);
        for(List<String> i : matrice){
            Integer id = Integer.parseInt(i.get(0));
            Integer idClient = Integer.parseInt(i.get(1));
            String tipLoc = i.get(2);
            Integer idEveniment = Integer.parseInt(i.get(3));
            Eveniment eveniment = magazin.getEvenimente().stream()
                    .filter(e -> e.getId().equals(idEveniment))
                    .findFirst().get();//--imi da eveninimentul din Optional!!!!!!!!!!!!!!!!!!!

            Bilet b = new Bilet(id, idClient, tipLoc, eveniment);
            listaBilete.add(b);
        }
        return listaBilete;
    }

    public void wClient(ArrayList<Bilet> listaBilete){
        List<List<String>> matrice = new ArrayList<>();
        for(Bilet i : listaBilete){
            List<String> linie = new ArrayList<>();
            linie.add(i.getId().toString());
            linie.add(i.getIdClient().toString());
            linie.add(i.getTipLoc());
            linie.add(i.getEveniment().getId().toString());
            matrice.add(linie);
        }
        buffer.write(fisierBilete,matrice);
    }


}
