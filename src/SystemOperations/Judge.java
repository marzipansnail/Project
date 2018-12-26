package SystemOperations;

import java.util.List;
import java.util.Objects;

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

    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Judge judge = (Judge) o;
        return Objects.equals(name, judge.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
