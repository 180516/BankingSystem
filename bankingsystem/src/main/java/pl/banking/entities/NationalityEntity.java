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
    @Enumerated(EnumType.STRING)
    @Column(name = "nationality_type", nullable = false, updatable = false)
    private Nationalities nationalityType;
    
    public NationalityEntity(){
        
    }

    public NationalityEntity(Nationalities nationalityType) {
        super();
        this.nationalityType = nationalityType;
    }

    public Nationalities getNationalityType() {
        return nationalityType;
    }

    public void setNationalityType(Nationalities nationalityType) {
        this.nationalityType = nationalityType;
    }
    
    
}
