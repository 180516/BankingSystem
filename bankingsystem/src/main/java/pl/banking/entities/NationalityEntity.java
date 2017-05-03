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

import pl.banking.enums.Nationalities;

@Entity(name = "nationality")
@Table(name = "nationalities")
public class NationalityEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "nationality_id", nullable = false, updatable = false)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "nationality_type", nullable = false, insertable = false, updatable = false)
    private Nationalities nationalityType;
    
    @OneToOne(mappedBy = "nationality")
    @PrimaryKeyJoinColumn
    private ClientEntity clientEntity;
    
    public NationalityEntity(){
        
    }
    
    

    public NationalityEntity(Long id, Nationalities nationalityType, ClientEntity clientEntity) {
        super();
        this.id = id;
        this.nationalityType = nationalityType;
        this.clientEntity = clientEntity;
    }



    public Long getId() {
        return id;
    }

    public Nationalities getNationalityType() {
        return nationalityType;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }
    
    
}
