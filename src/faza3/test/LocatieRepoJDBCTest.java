package faza3.test;

import faza3.repository.LocatieRepoJDBC;

public class LocatieRepoJDBCTest {
    public static void main(String[] args) {
        LocatieRepoJDBC locatieRepo = new LocatieRepoJDBC();
        locatieRepo.addLocatie("strada;nr", 300);
        locatieRepo.addLocatie("stradaAlta,nr", 500,5000);
        locatieRepo.getAllLocations().forEach(System.out::println);
        locatieRepo.getByAdressLike("Alta").forEach(System.out::println);
        locatieRepo.deleteAll();
    }
}
