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
    @GeneratedValue
    @Column(name = "credit_category_id", nullable = false, updatable = false)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "credit_category_type", updatable = false)
    private CreditCategories creditCategoryType;
    
    @OneToOne(mappedBy = "creditCategory")
    @PrimaryKeyJoinColumn
    private ClientEntity clientEntity;
    
    public CreditCategoryEntity(){
        
    }

    public CreditCategoryEntity(Long id, CreditCategories creditCategoryType, ClientEntity clientEntity) {
        super();
        this.id = id;
        this.creditCategoryType = creditCategoryType;
        this.clientEntity = clientEntity;
    }

    public Long getId() {
        return id;
    }

    public CreditCategories getCreditCategoryType() {
        return creditCategoryType;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }
}
