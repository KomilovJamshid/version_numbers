package uz.jamshid;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filePath = "/src/uz/jamshid/version.txt";

        ArrayList<String> arrayList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrayList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        arrayList.sort(new VersionComparator());

        try {
            BufferedWriter writer
                    = new BufferedWriter(new FileWriter(
                    "src/uz/jamshid/sorted_version.txt"));
            for (String line : arrayList) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

