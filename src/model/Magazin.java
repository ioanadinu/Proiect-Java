package model;

import javafx.collections.transformation.SortedList;

import java.util.*;

public class Magazin {
    private List<Eveniment> evenimente = new ArrayList<>();
    private SortedMap<Integer,Client> clienti = new TreeMap<>();
    private List<Locatie> locatii = new ArrayList<>();
    private List<Bilet> bilete = new ArrayList<>();

    public List<Eveniment> getEvenimente() {
        return evenimente;
    }

    public void setEvenimente(List<Eveniment> evenimente) {
        this.evenimente = evenimente;
    }

    public SortedMap<Integer, Client> getClienti() {
        return clienti;
    }

    public void setClienti(SortedMap<Integer, Client> clienti) {
        this.clienti = clienti;
    }

    public List<Locatie> getLocatii() {
        return locatii;
    }

    public void setLocatii(List<Locatie> locatii) {

        this.locatii = locatii;
    }

    public List<Bilet> getBilete() {

        return bilete;
    }

    public void setBilete(List<Bilet> bilete) {

        this.bilete = bilete;
    }
}
