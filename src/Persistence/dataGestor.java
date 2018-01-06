package Persistence;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class dataGestor {

    static void saveInfo(String path, ArrayList<String> info){
        for(int i=0; i<info.size(); i++) {
            byte data[] = info.get(i).getBytes();

            Path p = Paths.get("./Saved/usr001.txt");
            try (OutputStream out = new BufferedOutputStream(
                    Files.newOutputStream(p, CREATE, APPEND))) {
                out.write(data, 0, data.length);
                out.write(System.getProperty("line.separator").getBytes());

            } catch (IOException x) {
                System.err.println(x);
            }
        }
    }


    static void saveScore(String username, ArrayList<String> info){
        String fileName = "./Saved/"+username+".txt";
        // This will reference one line at a time
        String line = null;
        String[] out = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            int counter = -1;
            while((line = bufferedReader.readLine()) != null) {
                //We must save the score here
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            //If user info doesn't exists, we must initialize it
            ArrayList<String> a = new ArrayList<>();
            info.add(0,"SCORES");
            saveInfo(fileName, info);
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }

    static String[] retrieveScore(String ID, int i){

        // The name of the file to open.
        String fileName = "./Saved/usr001.txt";

        // This will reference one line at a time
        String line = null;
        String[] out = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            boolean found = false;
            int counter = -1;
            while((line = bufferedReader.readLine()) != null) {
                if(found) counter++;
                if(counter == i) out = line.split(" ");
                if(line.equals("SCORES")) found = true;
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
        return out;
    }


    void retrieveMatch(String ID, int i){

    }

    void saveMatch(String userId, ArrayList<String> matchParam){

    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        String t = "0101040";
        arr.add(t);
        saveScore("001",arr);
    }
}
