import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Parser {


    public Judgment parse(Path dir){

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file: stream) {

                Gson gson = new Gson();

                String name = file.getParent().toString();
                name = name +"\\" + file.getFileName();

                try (Reader reader = new FileReader(name)) {

                    Judgment judgment = gson.fromJson(reader, Judgment.class);
                    return judgment;


                } catch (IOException e) {
                    e.printStackTrace();
                }




            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }


        return null;

    }



}
