package test;

import faza2.repositoryCSV.RWClient;

import java.util.TreeMap;

public class TestCSV {
    public static void main(String[] args) {
        RWClient rwClient = new RWClient();
        rwClient.wClient(new TreeMap<>());
    }
}
