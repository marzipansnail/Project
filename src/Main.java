import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main (String[] args){


       Path path = Paths.get(System.getProperty("user.home"),"Desktop", "judgments-sample", "json");
       JudgmentsSystem j = new JudgmentsSystem(new Parser().parse(path));

       List<Integer> id = new ArrayList<>();
       id.add(283463);
       id.add(178305);
       System.out.println(j.getRubrum(id));
       System.out.println(j.judges("Edward Stelmasik"));



     /* for( Judgment j : jud){
          i++;
          System.out.println(i + " "  +j .toString());
      }
     */


    }


}
