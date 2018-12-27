package SystemOperations;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class JudgmentsSystem {

    protected List<Judgment> judgments;
    protected Map<Judge, Integer> judgesNum = new HashMap<>();
    protected Map<Regulation, Integer> regulationsNum = new HashMap<>();
    protected Map<Integer, Integer> judgesNumber = new HashMap<>();



    JudgmentsSystem(List<Judgment> judgments){
        this.judgments = judgments;
    }


    public String getRubrum(List<String> sig){

        String result = " ";
        for(Judgment judgment : judgments){
            for(String i : sig ){
                if(judgment.getSignature().equals(i)) {
                    result = result + "\n " + judgment.rubrum();
                }
            }
        }
        return result;
    }


    public String getContent(String s){
        for(Judgment judgment : judgments){
            if(judgment.getSignature().equals(s)) return judgment.content();
        }
        return "brak orzeczenia o podanej sygnaturze";
    }

    public int getJudge(String name){
        int i = 0;
        for(Judgment judgment : judgments){
            for(Judge jud : judgment.judges){
                if((jud.name).equals(name)){
                    i++;
                }
            }
        }
        return i;
    }

    public String topTenJudges(){

        for(Judgment judgment : judgments){
            for(Judge judge : judgment.judges){
                if(!judgesNum.containsKey(judge)){
                    String name = judge.getName();
                    Integer value = getJudge(name);
                    judgesNum.put(judge,value);
                }

            }
        }

        Map<Judge,Integer> topTen =
                judgesNum.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(10)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        String result = " ";

        for (Map.Entry<Judge, Integer> entry : topTen.entrySet()) {
            Judge j = entry.getKey();
            result = result + " " + j.getName() + " " + entry.getValue();
        }
        return result;
    }


    public String monthsStatistic(){

        String result = " ";
        int[] months = new int[12];
        for (int i=0; i<12; i++) months[0]=0;
        String[] monthName = {"Styczeń", "Luty", "Marzec",
        "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Październik",
        "Listopad", "Grudzień"};

        for(Judgment judgment : judgments){
            String month = judgment.judgmentDate.split("-")[1];
            if(month.startsWith("0")) month.substring(1);
            int m = parseInt(month);
            months[m-1]++;
        }

        for(int i=0; i<12; i++){
            result = result + "\n" + monthName[i] + " " + months[i];
        }
        return result;
    }

    public String courtStatistic(){

        String result = " ";

        int[] numbers = new int[6];
        for (int i=0; i<6; i++) numbers[0]=0;
        String[] courtTypes = {"Sąd Powszechny", "Sąd Najwyższy", "Sąd Administracyjny",
                "Trybunał Konstytucyjny", "Krajowa Izba Odwoławcza", "Naczelny Sąd Administracyjny"};

        for( Judgment judgment : judgments){
            for(int i=0; i<6; i++) {
                if(judgment.courtType.toString().equals(courtTypes[i])){
                    numbers[i]++;
                    break;
                }
            }
        }

        for(int i=0; i<6; i++){
            result = result + "\n" + courtTypes[i] + " " + numbers[i];
        }
        return result;
    }


    public String topTenRegulations(){

        for(Judgment judgment : judgments){
            for(Regulation reg : judgment.referencedRegulations){
                if(!regulationsNum.containsKey(reg)){
                    regulationsNum.put(reg,1);
                }
                else{
                    int freq = regulationsNum.get(reg);
                    regulationsNum.put(reg, freq+1);
                }

            }
        }

        Map<Regulation,Integer> topTen =
                regulationsNum.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(10)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        String result = " ";

        for (Map.Entry<Regulation, Integer> entry : topTen.entrySet()) {
            Regulation r = entry.getKey();
            result = result + "\n" + r.getTitle() + " " + entry.getValue();
        }
        return result;
    }



    public String juryStatistic(){

        String result = "";

        for(Judgment judgment : judgments){
            int size = judgment.judgesNumber();
            if(!judgesNumber.containsKey(size)){
                judgesNumber.put(size,1);
            }
            else{
                int freq = judgesNumber.get(size);
                judgesNumber.put(size, freq+1);
            }

        }
        for (Map.Entry<Integer, Integer> entry : judgesNumber.entrySet()) {
            result = result + "\n Liczba sędziów w składzie: " + entry.getKey() + " Liczba wystąpień: " + entry.getValue();
        }
        return result;
    }


    public String instructions(){
        String result =
                "Dostępne metody: " + "\n"
                + " \n" +
                        "    rubrum - wyświetlenie metryki jednego lub wielu orzeczeń, na podstawie sygnatury \n" +
                        "    content - wyświetlenie uzasadnienia orzeczenia na podstawie sygnatury \n" +
                        "    judge - wyświetlenie liczby orzeczeń dla wybranego sędziego \n" +
                        "    judges - wyświetlenie 10 sędziów, którzy wydali najwięcej orzeczeń \n" +
                        "    months - wyświetlenie liczby orzeczeń w poszczególnych miesiącach \n" +
                        "    courts - wyświetlenie liczby orzeczeń ze względu na typ sądu \n" +
                        "    regulations - wyświetlenie 10 najczęściej przywoływanych ustaw \n" +
                        "    jury - wyświetlenie liczby spraw przypadających na określony skład sędziowski \n" +
                        " Nazwę metody oraz nazwy argumentów oddzielają dwie spacje! \n";

        return result;
    }


}
