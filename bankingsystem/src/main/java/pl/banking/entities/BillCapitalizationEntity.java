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
    @GeneratedValue
    @Column(name = "bill_capitalization_id", nullable = false, updatable = false)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "bill_capitalization_type", nullable = false, insertable = false, updatable = false)
    private BillCapitalizations billCapitalizationType;
    
    @OneToOne(mappedBy = "billCapitalization")
    @PrimaryKeyJoinColumn
    private ClientEntity clientEntity;
    
    public BillCapitalizationEntity(){
        
    }

    public BillCapitalizationEntity(Long id, BillCapitalizations billCapitalizationType, ClientEntity clientEntity) {
        super();
        this.id = id;
        this.billCapitalizationType = billCapitalizationType;
        this.clientEntity = clientEntity;
    }



    public Long getId() {
        return id;
    }

    public BillCapitalizations getBillCapitalizationType() {
        return billCapitalizationType;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }
}
