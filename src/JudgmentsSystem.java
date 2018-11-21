import java.util.List;

public class JudgmentsSystem {

    protected List<Judgment> judgments;
    protected List<Regulation> regulations;

    public String getRubrum(int id){
        return judgments.get(id).toString();
    }







}
