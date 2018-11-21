import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class Main {

    public static void main (String[] args){

        Gson gson = new Gson();

        try (Reader reader = new FileReader("C:\\Users\\Zuzanna\\Desktop\\plik.json")) {

            // Convert JSON to Java Object
            Judgment judgment = gson.fromJson(reader, Judgment.class);
            System.out.println(judgment.type());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
