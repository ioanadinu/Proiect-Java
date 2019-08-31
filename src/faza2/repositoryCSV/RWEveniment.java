package faza2.repositoryCSV;

import model.Eveniment;

import java.util.ArrayList;
import java.util.List;

public class RWEveniment {
    ReadWrite buffer = new ReadWrite();// daca metoda nu e statica, declar o instanta
    String fisierEvenimente= "dateEvenimente.txt";

    public ArrayList<Eveniment> rEveniment(){
        ArrayList<Eveniment> listaEvenimente = new ArrayList<>();
        List<List<String>> matrice = buffer.read(fisierEvenimente);
        for(List<String> i : matrice){
            Integer id = Integer.parseInt(i.get(0));
            Integer idLocatie = Integer.parseInt(i.get(1));
            String nume = i.get(2);
            String data = i.get(3);
            Boolean status = Boolean.parseBoolean(i.get(4));
            Eveniment e = new Eveniment(id, idLocatie, nume, data, status);
            listaEvenimente.add(e);
        }
        return listaEvenimente;
    }

    public void wEveniment(ArrayList<Eveniment> listaEvenimente){
        List<List<String>> matrice = new ArrayList<>();
        for(Eveniment i : listaEvenimente){ //de ce vrea Object si nu List?
            List<String> linie = new ArrayList<>();
            linie.add(i.getId().toString());
            linie.add(i.getIdLocatie().toString());
            linie.add(i.getNume());
            linie.add(i.getData());
            linie.add(i.getStatus().toString());
            matrice.add(linie);
        }
        buffer.write(fisierEvenimente,matrice);
    }

}
