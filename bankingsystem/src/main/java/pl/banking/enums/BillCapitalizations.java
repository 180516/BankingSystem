package pl.banking.enums;

public enum BillCapitalizations {
    SOME_CAP("some capitalization");
    
    private String capitaliztionName;
    
    private BillCapitalizations(String capitaliztionName){
        this.capitaliztionName = capitaliztionName;
    }
    
    public String getCapitalizationName(){
        return capitaliztionName;
    }
}
