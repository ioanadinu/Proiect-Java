package faza2.repositoryCSV;

import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class RWClient {
    ReadWrite buffer = new ReadWrite();// daca metoda nu e statica, declar o instanta
    String fisierClienti = "D:\\Proiect\\src\\dateClienti.txt";


    public SortedMap<Integer, Client> rClient(){
        SortedMap<Integer, Client> listaClienti = new TreeMap<>();//!!!!!!!!!!sortedma--treemap
        List<List<String>> matrice = buffer.read(fisierClienti);
        for(List<String> i : matrice){
            String nume = i.get(0);
            String email = i.get(1);
            Integer id = Integer.parseInt(i.get(2));
            String parola = i.get(3);
            Client c = new Client(nume, email, id, parola);
            listaClienti.put(id, c);
        }
        return listaClienti;
    }

    public void wClient(SortedMap<Integer, Client> listaClienti){
        List<List<String>> matrice = new ArrayList<>();
        for(Integer id: listaClienti.keySet()){
            Client c = listaClienti.get(id);
            List<String> linie = new ArrayList<>();
            linie.add(c.getNume());
            linie.add(c.getEmail());
            linie.add(c.getId().toString());
            linie.add(c.getParola());
            matrice.add(linie);
        }
        buffer.write(fisierClienti,matrice);
    }

}
