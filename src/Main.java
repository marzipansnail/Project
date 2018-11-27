import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Main {

    public static void main (String[] args){


        Path path = Paths.get(System.getProperty("user.home"),"Desktop", "judgments-sample", "json");
        List<Judgment> jud = new Parser().parse(path);

        int i = 0;

      for( Judgment j : jud){
          i++;
          System.out.println(i + " "  +j .toString());
      }



    }


}
