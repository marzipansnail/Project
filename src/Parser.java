import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Judgment> judgments = new ArrayList<>();


    public List<Judgment> parse(Path dir){

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file: stream) {
//for item in items albo coś w tym stylu
                Gson gson = new Gson();

                String name = file.getParent().toString();
                name = name +"\\" + file.getFileName();

                try (Reader reader = new FileReader(name)) {

                    Items wydmuszka = gson.fromJson(reader, Items.class);
                    List<Judgment> j = wydmuszka.items;
                    judgments.addAll(j);


                } catch (IOException e) {
                    e.printStackTrace();
                }




            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }


        return judgments;

    }



}
