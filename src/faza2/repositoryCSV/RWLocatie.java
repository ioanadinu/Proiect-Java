package faza2.repositoryCSV;

import model.Locatie;
import model.LocatieInAerLiber;
import model.Sala;

import java.util.ArrayList;
import java.util.List;

public class RWLocatie {

    ReadWrite buffer = new ReadWrite();// daca metoda nu e statica, declar o instanta
    String fisierLocatii = "dateLocatii.txt";

    public ArrayList<Locatie> rLocatie(){
        ArrayList<Locatie> listaLocatii = new ArrayList<>();//!!!!!!!!!!sortedma--treemap
        List<List<String>> matrice = buffer.read(fisierLocatii);
        for(List<String> i : matrice){
            Locatie l = null;
            if(i.size() == 4){
                Integer id = Integer.parseInt(i.get(0));
                String adresa = i.get(1);
                Integer nrscaune = Integer.parseInt(i.get(2));
                Integer nrlocPicioare = Integer.parseInt(i.get(3));
                l = new LocatieInAerLiber(id, adresa, nrscaune, nrlocPicioare);
            }
            else{
                Integer id = Integer.parseInt(i.get(0));
                String adresa = i.get(1);
                Integer nrscaune = Integer.parseInt(i.get(2));
                l = new Sala(id, adresa, nrscaune);
            }

            listaLocatii.add(l);
        }
        return listaLocatii;
    }

    public void wLocatie(ArrayList<Locatie> listaLocatii){
        List<List<String>> matrice = new ArrayList<>();
        for(Locatie i : listaLocatii){
            List<String> linie = new ArrayList<>();
            if(i instanceof LocatieInAerLiber){
                linie.add(((LocatieInAerLiber)i).getId().toString());
                linie.add(((LocatieInAerLiber)i).getAdresa());
                linie.add(((LocatieInAerLiber)i).getNrScaune().toString());
                linie.add(((LocatieInAerLiber)i).getNrLocuriPicioare().toString());
            }
            else {
                linie.add(((Sala)i).getId().toString());
                linie.add(((Sala)i).getAdresa());
                linie.add(((Sala)i).getNrScaune().toString());
            }
            matrice.add(linie);
        }
        buffer.write(fisierLocatii,matrice);
    }

}
