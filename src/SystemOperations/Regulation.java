package SystemOperations;

import java.util.Objects;

public class Regulation {

    protected String journalTitle;
    protected int journalYear;
    protected int journalNo;
    protected int journalEntry;
    protected String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regulation that = (Regulation) o;
        return journalYear == that.journalYear &&
                journalNo == that.journalNo &&
                journalEntry == that.journalEntry;
    }

    @Override
    public int hashCode() {
        return Objects.hash(journalYear, journalNo, journalEntry);
    }

   public String getTitle(){
        return this.journalTitle;
   }


}
