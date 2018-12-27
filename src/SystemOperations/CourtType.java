package SystemOperations;

enum CourtType {

    COMMON,
    SUPREME,
    ADMINISTRATIVE,
    CONSTITUTIONAL_TRIBUNAL,
    NATIONAL_APPEAL_CHAMBER,
    SUPREME_ADMINISTRATIVE;


    public String toString(){
        switch(this) {
            case COMMON:
                return "Sąd Powszechny";

            case SUPREME:
                return "Sąd Najwyższy";

            case ADMINISTRATIVE:
                return "Sąd Administracyjny";

            case CONSTITUTIONAL_TRIBUNAL:
                return "Trybunał Konstytucyjny";

            case NATIONAL_APPEAL_CHAMBER:
                return "Krajowa Izba Odwoławcza";

            case SUPREME_ADMINISTRATIVE:
                return "Naczelny Sąd Administracyjny";

        }
        return "";
    }

}