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

            // String line = "C:\\Users\\Zuzanna\\Desktop\\json";
            // C:\\Users\\Zuzanna\\Desktop\\html
            JudgmentsSystem j = new JudgmentsSystem(new JudgmentsParser().parse(line1, line2));




       while (true) {
            line=lineReader.readLine(prompt);
            try {

                String[] command = line.split("  ");
                String method = command[0];

                switch(method) {
                    case "rubrum":
                        int size = command.length;
                        List<String> sig = new ArrayList<>();
                        for(int i=1; i<size; i++) {
                            sig.add(command[i]);
                        }
                        System.out.println(j.getRubrum(sig));
                        sig.clear();
                        break;



                    case "content":
                        String i = command[1];
                        System.out.println(j.getContent(i));
                        break;


                    case "judge":
                        String name = command[1];
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












