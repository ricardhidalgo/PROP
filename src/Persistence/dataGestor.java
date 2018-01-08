package Persistence;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author albert.ortiz
 */


import static java.nio.file.StandardOpenOption.CREATE;

public class dataGestor {

    public dataGestor(){

    }

    private void checkDir() {
        File theDir = new File("Saved");
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;

            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                System.out.println("DIR created");
            }
        }
    }

    private void saveInfo(String path, ArrayList<String> info){
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


    public void createUser(String username, String password) {
        checkDir();
        String fileName = "./Saved/" + username + ".txt";
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

        } catch (FileNotFoundException ex) {
            //If user info doesn't exists, we must initialize it
            ArrayList<String> a = new ArrayList<>();
            a.add(password);
            a.add("SCORES");
            saveInfo(fileName, a);
        }
    }


    private ArrayList<String> arrPatch (ArrayList<String> in){
        String s = "";
        s += in.get(0);
        for(int i=1; i<in.size(); i++) s+=" " + in.get(i);
        ArrayList<String> out = new ArrayList<>();
        out.add(s);
        return out;
    }

    public void save(String username, ArrayList<String> info, boolean score){
        info = arrPatch(info);
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

    public void deleteIndex(String username, int i, boolean score){

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
                if(counter != i) out.add(line);
                if(!score) found = true;
                if(line.equals("SCORES") && score) found = true;
                if(found){counter++;}
            }

            // Always close files.
            bufferedReader.close();
            saveInfo(fileName, out);
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
    }

    public ArrayList<String> retrieveAll(String username, boolean score) {

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
            while((line = bufferedReader.readLine()) != null) {
                if(line.equals("SCORES") && !score) break;
                if(found) out.add(line);
                if(!score) found = true;
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

    public ArrayList<String> findUser(String username){
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
            out.add(username);
            out.add(line = bufferedReader.readLine());
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            out.add("NULL");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
        return out;
    }

}

