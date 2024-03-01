package Data_Access_Layer;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {



    public static ArrayList<String[]> readLocationData(String filename) {
        ArrayList<String[]> locationArrayList = new ArrayList< >();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {



            Scanner scanner = new Scanner(new File(filename));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] locations = line.split(",");


                    locationArrayList.add(locations);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return locationArrayList;
    }






}