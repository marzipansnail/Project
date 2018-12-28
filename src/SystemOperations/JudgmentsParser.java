package SystemOperations;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JudgmentsParser {

    public List<Judgment> judgments = new ArrayList<>();


    public List<Judgment> parse(String dir1, String dir2) throws IOException {

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

        File htmlfiles = new File (dir2);
        File[] hdirectoryListing = htmlfiles.listFiles();

        if (hdirectoryListing != null) {
            for (File file : hdirectoryListing) {

                Document doc =  Jsoup.parse(file, "UTF-8");



                Elements caseNumH = doc.getElementsByClass("war_header");
                String casetext = caseNumH.text();
                String caseNumber = casetext.split(" -")[0];
                List<CourtCase> cases = new ArrayList<>();
                CourtCase courtcase = new CourtCase();
                courtcase.caseNumber = caseNumber;
                cases.add(courtcase);


                Elements des = doc.select("td.info-list-value");


                String judgmentDate = des.get(0).text().split(" ")[0];

                String ctype = des.get(2).text();
                CourtType t = null;

                if(ctype.contains("Wojewódzki Sąd Administracyjny")) t=CourtType.ADMINISTRATIVE;
                if(ctype.contains("Naczelny Sąd Administracyjny")) t=CourtType.SUPREME_ADMINISTRATIVE;

                String judgesH = des.get(3).text();
                String[] judgesHTML = judgesH.split(" ");

                List<Judge> judges = new ArrayList<>();


                for(int i=0; i<judgesHTML.length-1;i++) {

                    Judge judge = new Judge();
                    judge.name = judgesHTML[i]+ " " + judgesHTML[i+1];

                    List<JudgeRole> specialRoles = new ArrayList<>();

                    int j=i+2;

                    while(j<judgesHTML.length){

                        if(!judgesHTML[j].contains("/")) break;
                       else {
                            if (judgesHTML[j].contains("przewodniczący")) {
                                specialRoles.add(JudgeRole.PRESIDING_JUDGE);
                            }
                            if (judgesHTML[j].contains("sprawozdawca")) {
                                specialRoles.add(JudgeRole.REPORTING_JUDGE);
                            }
                            if (judgesHTML[j].contains("autor")) {
                                specialRoles.add(JudgeRole.REASONS_FOR_JUDGMENT_AUTHOR);
                            }
                            j++;
                        }
                    }
                    i=j-1;

                    judge.specialRoles = specialRoles;
                    judges.add(judge);

                }

                //uzasadnienie
                Elements content = doc.select("td.info-list-label-uzasadnienie");
                String textContent = "brak uzasadnienia";
                if(content.size()>1){
                    textContent = content.get(content.size()-1).text();
                    textContent =  textContent.split(" ", 2)[1];
                }

                List<Regulation> regList = new ArrayList<>();

                Elements reg = doc.select("td.info-list-label");

                for(int i=0;i<reg.size();i++){

                    if(reg.get(i).text().contains("Powołane przepisy")){

                        String regulations = des.get(i).text();
                        String[] regArray = regulations.split("Dz.U. ");

                        for(int j=1; j<regArray.length;j++){

                            Regulation r = new Regulation();
                            if(!regArray[j].split(" ")[0].contains("nr"))r.journalYear = Integer.parseInt(regArray[j].split(" ")[0]);
                            else r.journalYear = -1;
                            String[] regs = regArray[j].split(" ");

                            for(int k=0; k<regs.length; k++){
                                if(regs[k].contains("poz")) {
                                    r.journalEntry = Integer.parseInt(regs[k + 1]);
                                }
                            }
                            if( regArray[j].split("Ustawa").length>1)r.journalTitle = "Ustawa " + regArray[j].split("Ustawa")[1];
                            else r.journalTitle = "nieokreślone";
                            regList.add(r);
                        }

                        break;

                    }
                }





                //tworzenie orzeczenia z powyższymi atrybutami i dodanie do listy wynikowej:

                Judgment j = new Judgment(t,cases,judges,textContent,regList, judgmentDate);
                judgments.add(j);


                }
            }

        return judgments;

        }
    }






