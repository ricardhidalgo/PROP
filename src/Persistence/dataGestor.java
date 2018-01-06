package Persistence;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class dataGestor {

    static void saveInfo(String path, ArrayList<String> info){
        Path p = Paths.get(path);
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE))) {
            byte data[];
            for(int i=0; i<info.size()-1; i++) {
                data = info.get(i).getBytes();
                out.write(data, 0, data.length);
                out.write(System.getProperty("line.separator").getBytes());
            }
            data = info.get(info.size()-1).getBytes();
            out.write(data, 0, data.length);
            } catch (IOException x) {
            System.err.println(x);
        }
    }

    static void save(String username, ArrayList<String> info, boolean score){
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
            ArrayList<String> text = new ArrayList<>();
            boolean added = false;
            while((line = bufferedReader.readLine()) != null) {
                if(!score && line.equals("SCORES"))
                    for(int i=0; i<info.size(); i++) text.add(info.get(i));
                text.add(line);
            }
            if (score) for(int i=0; i<info.size(); i++) text.add(info.get(i));
            saveInfo(fileName, text);

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            //If user info doesn't exists, we must initialize it
            ArrayList<String> a = new ArrayList<>();
            if(score) {
                a.add("SCORES");
                for (int i = 0; i < info.size(); i++) a.add(info.get(i));
                saveInfo(fileName, a);
            }else{
                for (int i = 0; i < info.size(); i++) a.add(info.get(i));
                a.add("SCORES");
                saveInfo(fileName, a);
            }
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }

    static String[] retrieveIndex(String username, int i, boolean score){

        // The name of the file to open.
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
            boolean found = false;
            int counter = -1;
            while((line = bufferedReader.readLine()) != null) {
                if(found) counter++;
                if(score) found = true;
                if(counter == i) out = line.split(" ");
                if(line.equals("SCORES") && score) found = true;
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

    static ArrayList<String> retrieveAll(String username, boolean score) {

        // The name of the file to open.
        String fileName = "./Saved/"+username+".txt";

        // This will reference one line at a time
        String line = null;
        ArrayList<String> out = new ArrayList<>();
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
                if(line.equals("SCORES") && !score) break;
                if(!score) found = true;
                if(found) out.add(line);
                if(line.equals("SCORES") && score) found = true;
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

        public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        String t = "232";
        arr.add(t);
        save("102",arr,false);
        ArrayList<String> out = retrieveAll("102",false);
        for(int i=0; i<out.size(); i++) System.out.println(out.get(i));
    }
}

