package pl.banking.enums;

public enum ClientTypes {
    SOME_TYPE("some type");
    
    private String typeName;

    private ClientTypes(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
