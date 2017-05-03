package pl.banking.enums;

import java.io.Serializable;

public enum CreditCategories implements Serializable{
    SOME_CATEGORY("some category");
    
    private String categoryName;
    
    private CreditCategories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
