import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {

    public static void main (String[] args){

       // String textPath = "C:\Users\Zuzanna\Desktop\plik.json";
        Path path = Paths.get(System.getProperty("user.home"),"Desktop", "pliki");
        Judgment jud = new Parser().parse(path);

        System.out.println(jud.toString());







      /*  Gson gson = new Gson();

        try (Reader reader = new FileReader("C:\\Users\\Zuzanna\\Desktop\\plik.json")) {

            // Convert JSON to Java Object
            Judgment judgment = gson.fromJson(reader, Judgment.class);
            System.out.println(judgment.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
*/

    }


}
