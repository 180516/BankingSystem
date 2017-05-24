package pl.banking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pl.banking.enums.CreditCategories;

@Entity(name = "credit_category")
@Table(name = "credit_categories")
public class CreditCategoryEntity {
    
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "credit_category_type", updatable = false)
    private CreditCategories creditCategoryType;
    
    public CreditCategoryEntity(){
        
    }

    public CreditCategoryEntity(CreditCategories creditCategoryType) {
        super();
        this.creditCategoryType = creditCategoryType;
    }

    public CreditCategories getCreditCategoryType() {
        return creditCategoryType;
    }

    public void setCreditCategoryType(CreditCategories creditCategoryType) {
        this.creditCategoryType = creditCategoryType;
    }
    
    
}
