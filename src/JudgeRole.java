enum JudgeRole{

    PRESIDING_JUDGE,

    REPORTING_JUDGE,

    REASONS_FOR_JUDGMENT_AUTHOR;


    public String toString(){
        switch(this) {
            case PRESIDING_JUDGE:
                return "Przewodniczacy Składu Sędziowskiego";

            case REPORTING_JUDGE:
                return "Sędzia Sprawozdawca";

            case REASONS_FOR_JUDGMENT_AUTHOR:
                return "Autor Uzasadnienia";

        }
        return "";
    }


}