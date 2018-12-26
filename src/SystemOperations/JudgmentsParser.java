package SystemOperations;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JudgmentsParser {

    public List<Judgment> judgments = new ArrayList<>();


    public List<Judgment> parse(String dir1, String dir2) throws FileNotFoundException {

        File jsonfiles = new File(dir1);
        File[] directoryListing = jsonfiles.listFiles();
        if (directoryListing != null) {
            for (File file : directoryListing) {

                Gson gson = new Gson();

                Items wydmuszka = gson.fromJson(new FileReader(file.getAbsolutePath()), Items.class);
                List<Judgment> j = wydmuszka.items;
                judgments.addAll(j);


            }
        }

       /* File htmlfiles = new File (dir2);
        File[] hdirectoryListing = htmlfiles.listFiles();
        if (directoryListing != null) {
            for (File file : directoryListing) {





            }
        }*/

        return judgments;
    }

}









      /*  try (DirectoryStream<String> stream = Files.newDirectoryStream(dir)) {





        }
            for (String file: stream) {

                Gson gson = new Gson();

                //swing zeby dzialalo pod linuxem
                //napraw to, przegladanie katalogu
                //pliki mogą być w tym samym katalogu, które mogą być podane po rozszerzeniu
                // html to java - poczytaj
                // przeglądanie katalogu w javie - poczytaj for(File file : files) a nie żaden stream

                String name = file.getParent().toString();
                name = name +"\\" + file.getFileName();

                try (Reader reader = new FileReader(name)) {

                    SystemOperations.Items wydmuszka = gson.fromJson(reader, SystemOperations.Items.class);
                    List<SystemOperations.Judgment> j = wydmuszka.items;
                    judgments.addAll(j);


                } catch (IOException e) {
                    e.printStackTrace();
                }




            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }
*/








