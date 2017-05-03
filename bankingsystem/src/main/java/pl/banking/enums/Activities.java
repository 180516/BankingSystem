package pl.banking.enums;

public enum Activities {
    SOME_ACTIVITY("some activity");
    
    private String activityName;
    
    private Activities(String activityName){
        this.activityName = activityName;
    }
    
    public String getActivityName(){
        return activityName;
    }
}
