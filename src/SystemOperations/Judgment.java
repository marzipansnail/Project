package SystemOperations;

import java.util.List;

public class Judgment {

    private int id;
    protected CourtType courtType;
    protected List<CourtCase> courtCases;
    protected JudgmentType judgmentType;
    protected List<Judge> judges;
    private List<String> courtReporters;
    private String decision;
    private String summary;
    protected String textContent;
    private List<String> legalBases;
    protected List<Regulation> referencedRegulations;
    private List<String> keywords;
    private List<CourtCase> referencedCourtCases;
    private String receiptDate;
    private String meansOfAppeal;
    private String judgmentResult;
    private List<String> lowerCourtJudgments;
    private List<Opinion> dissentingOpinions;
    protected String judgmentDate;



    Judgment(CourtType type, List<CourtCase> cases, List<Judge> judges, String content,
             List<Regulation> regulations, String date ){

        this.courtType = type;
        this.courtCases = cases;
        this.judges = judges;
        this.textContent = content;
        this.referencedRegulations = regulations;
        this.judgmentDate = date;

    }


    public String rubrum(){

        String jud = new String();
        for(Judge judge : judges){
            jud = jud + " " + judge.getJudge();
        }
        return this.getSignature() +  " " + this.judgmentDate + " " + courtType.toString() + " " + jud;

    }

    public String getSignature(){
        return this.courtCases.get(0).getCase();
    }

    public String content(){

        return this.textContent;

    }

    public int judgesNumber(){
        return judges.size();
    }





}
