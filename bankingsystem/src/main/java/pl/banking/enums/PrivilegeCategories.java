package pl.banking.enums;

import java.io.Serializable;

public enum PrivilegeCategories implements Serializable{
    SOME_CATEGORY("some category");
    
    private String categoryName;
    
    private PrivilegeCategories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
