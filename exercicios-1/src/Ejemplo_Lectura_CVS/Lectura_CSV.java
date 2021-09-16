package Ejemplo_Lectura_CVS;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class Lectura_CSV {

    public static void main(String[] args) throws IOException {
        String sCarpAct = System.getProperty("user.dir");
        //System.out.println("Carpeta: "+sCarpAct+"\\Products.csv");
        String fileName = sCarpAct+"\\Products.csv";

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (CsvException e) {
            e.printStackTrace();
        }


    }


}
