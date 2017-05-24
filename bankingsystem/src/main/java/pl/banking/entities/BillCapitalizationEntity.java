package pl.banking.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import pl.banking.enums.BillCapitalizations;

@SuppressWarnings("serial")
@Entity(name = "bill_capitalization")
@Table(name = "bill_capitalizations")
public class BillCapitalizationEntity implements Serializable{
    
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "bill_capitalization_type", nullable = false, updatable = false)
    private BillCapitalizations billCapitalizationType;
    
    public BillCapitalizationEntity(){
        
    }

    public BillCapitalizationEntity(BillCapitalizations billCapitalizationType) {
        super();
        this.billCapitalizationType = billCapitalizationType;
    }

    public BillCapitalizations getBillCapitalizationType() {
        return billCapitalizationType;
    }

    public void setBillCapitalizationType(BillCapitalizations billCapitalizationType) {
        this.billCapitalizationType = billCapitalizationType;
    }

    
}
