package pl.banking.enums;

public enum ClientStatuses {
    SOME_STATUS("some status");
    
    private String statusName;
    
    private ClientStatuses(String activityName){
        this.statusName = activityName;
    }
    
    public String getStatusName(){
        return statusName;
    }
}
