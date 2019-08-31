package test;

import model.*;

import java.util.*;

public class Exemple {
    public static void main(String[] args){
        List<Eveniment> events = new ArrayList<>();
        events.add(new Eveniment(3, null, "event1","20190717", null));
        events.add(new Eveniment(5, null, "event2","20190614", null));
        events.add(new Eveniment(1, null, "event0","20190915", null));
        events.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        Comparator<Eveniment> comparator = new Comparator<Eveniment>() {
            @Override
            public int compare(Eveniment o1, Eveniment o2) {
                return o1.getNume().compareTo(o2.getNume());
            }
        };// apare ; pt ca este o clasa

        events.stream()
                .sorted(comparator)
                .forEach(System.out::println);
        System.out.println();

        events.stream()
                .sorted((e1,e2) -> e1.getId() - e2.getId()) ///(e1,e2) -> e1.getId().compareTo(e2.getId())
                .forEach(System.out::println);
        System.out.println();

        events.sort((e1,e2) -> e1.getId() - e2.getId());
        System.out.println(events);
        System.out.println();

        SortedMap<Eveniment, String> sMap = new TreeMap<>(comparator);//!!!!
        events.forEach(e -> sMap.put(e, e.getNume()));
        System.out.println(sMap);
        

    }

    //RWEveniment, RWLocatie, RWBilet cu lambda
    //termin + testez
}
