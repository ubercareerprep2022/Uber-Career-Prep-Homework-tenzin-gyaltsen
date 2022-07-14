package Assignment2;

import java.io.*;
import java.util.*;

/**
 * DataSearch
 */
public class DataSearch {

    public static void main(String[] args) {
        PhoneDirectory phoneLists = new PhoneDirectory();
        File csv = new File("data.csv");
        System.out.println("14");
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            String line;
            while ((line = br.readLine()) !=  null) {
                String[] values = line.split(",");
                phoneLists.insert(values[0], (long) Integer.valueOf(values[1]));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Unable to read the file! The file does not exist or is in unreadable format");
            e.printStackTrace();
        }

        phoneLists.getListSize();   
    }
}