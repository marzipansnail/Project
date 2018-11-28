
import java.util.List;

public class JudgmentsSystem {

    protected List<Judgment> judgments;
    protected List<Regulation> regulations;



    JudgmentsSystem(List<Judgment> judgments){
        this.judgments = judgments;
    }

    public String getRubrum(List<Integer> id){

        String result = " ";
        for(Judgment j : judgments){
            for(Integer i : id ){
                if(j.id==i) {
                    result = result + "\n " + j.rubrum();
                }
            }
        }
        return result;
    }

    public int judges(String name){
        int i = 0;
        for(Judgment j : judgments){
            for(Judge jud : j.judges){
                if((jud.name).equals(name)){
                    i++;
                }
            }
        }
        return i;
    }

    public String topTen(){
        return " ";
    }






}
