import java.util.List;

public class Judge {

    public String name;
    public String function;
    public List<JudgeRole> specialRoles;

    public String getJudge(){
        String roles = new String();
        for(JudgeRole r : specialRoles){
            roles = roles + " " + r.toString();
        }
        return roles + " " + name;
    }



}
