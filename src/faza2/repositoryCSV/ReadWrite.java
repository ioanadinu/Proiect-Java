package faza2.repositoryCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadWrite {
    public void write(String filename, List<List<String>> matrice){
        try {
            File file = new File(filename);
            BufferedWriter bufWrite = new BufferedWriter(new FileWriter(file));
            for(List<String> i : matrice){
                for(String j : i)
                    bufWrite.write(j + ";");
                bufWrite.newLine();
            }
            bufWrite.close();
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public List<List<String>> read(String filename){
        try{
            File file = new File(filename);
            BufferedReader bufRead = new BufferedReader(new FileReader(file));
            List<List<String>> matrice = new ArrayList<>();//!!!!!!!!
            String line = null;
            while((line = bufRead.readLine())!= null){
                String[] valori = line.split(";");
                matrice.add(Arrays.asList(valori));//din array in list
            }
            bufRead.close();
            return matrice;
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}


