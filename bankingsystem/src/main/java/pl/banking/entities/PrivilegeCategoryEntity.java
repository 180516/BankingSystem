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

import pl.banking.enums.PrivilegeCategories;

@Entity(name = "privilege_category")
@Table(name = "privilege_categories")
public class PrivilegeCategoryEntity {
    
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "privilege_category_type", nullable = false, updatable = false)
    private PrivilegeCategories privilegeCategoryType;

    public PrivilegeCategoryEntity() {
    }

    public PrivilegeCategoryEntity(PrivilegeCategories privilegeCategoryType) {
        super();
        this.privilegeCategoryType = privilegeCategoryType;
    }

    public PrivilegeCategories getPrivilegeCategoryType() {
        return privilegeCategoryType;
    }

    public void setPrivilegeCategoryType(PrivilegeCategories privilegeCategoryType) {
        this.privilegeCategoryType = privilegeCategoryType;
    }
    
    
}
