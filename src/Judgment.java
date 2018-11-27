import java.util.List;

public class Judgment {

    public int id;
    public CourtType courtType;
    public List<CourtCase> courtCases;
    public JudgmentType judgmentType;
    public List<Judge> judges;
    public List<String> courtReporters;
    public String decision;
    public String summary;
    public String textContent;
    public List<String> legalBases;
    public List<Regulation> referencedRegulations;
    public List<String> keywords;
    public List<CourtCase> referencedCourtCases;
    public String receiptDate;
    public String meansOfAppeal;
    public String judgmentResult;
    public List<String> lowerCourtJudgments;
    //personnelType
    public List<Opinion> dissentingOpinions;
    public String judgmentDate;



    public String toString(){

        return id + " " + courtType.toString();

    }





}
