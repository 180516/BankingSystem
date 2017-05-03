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
    @GeneratedValue
    @Column(name = "privilege_category_id", nullable = false, updatable = false)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "privilege_category_type", nullable = false, insertable = false, updatable = false)
    private PrivilegeCategories privilegeCategoryType;
    
    @OneToOne(mappedBy = "privilegeCategory")
    @PrimaryKeyJoinColumn
    private ClientEntity clientEntity;

    public PrivilegeCategoryEntity() {
    }
    
    

    public PrivilegeCategoryEntity(Long id, PrivilegeCategories privilegeCategoryType, ClientEntity clientEntity) {
        super();
        this.id = id;
        this.privilegeCategoryType = privilegeCategoryType;
        this.clientEntity = clientEntity;
    }



    public Long getId() {
        return id;
    }

    public PrivilegeCategories getPrivilegeCategoryType() {
        return privilegeCategoryType;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }
}
