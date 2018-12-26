package SystemOperations;

import org.jline.reader.*;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        String prompt = "judgments> ";



       Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();


        LineReader lineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build();

        String line = null;

        System.out.println("Wprowadź ścieżkę do folderu zawierającego pliki typu .json:");
        String line1 = lineReader.readLine(prompt);
        System.out.println("Wprowadź ścieżkę do folderu zawierającego pliki typu html");
        String line2 = lineReader.readLine(prompt);

       // String line = "C:\\Users\\Zuzanna\\Desktop\\judgments-sample\\json";
        JudgmentsSystem j = new JudgmentsSystem(new JudgmentsParser().parse(line1,line2));
        List<String> sig = new ArrayList<>();
        sig.add("II AKa 42/14");






       while (true) {
            line=lineReader.readLine(prompt);
            try {


                switch(line) {
                    case "rubrum":
                        System.out.println(j.getRubrum(sig));
                        break;



                    case "content":
                        String i = "II AKa 42/14";
                        System.out.println(j.getContent(i));
                        break;


                    case "judge":
                        String name = "Edward Stelmasik";
                        System.out.println(j.getJudge(name));
                        break;


                    case "judges":
                        System.out.println(j.topTenJudges());
                        break;


                    case "months":
                        System.out.println(j.monthsStatistic());
                        break;

                    case "courts":
                        System.out.println(j.courtStatistic());
                        break;


                    case "regulations":
                        System.out.println(j.topTenRegulations());
                        break;


                    case "jury":
                        System.out.println(j.juryStatistic());
                        break;

                    case "help":
                        System.out.println(j.instructions());
                        break;

                        default:
                         System.out.println("Taka metoda nie istnieje.");
                        System.out.println(j.instructions());
                        break;
                }


            } catch (UserInterruptException e) {
                // Ignore
            } catch (EndOfFileException e) {
                return;
            }

        }



    }
}












