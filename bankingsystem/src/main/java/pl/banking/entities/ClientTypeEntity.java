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

import pl.banking.enums.ClientStatuses;
import pl.banking.enums.ClientTypes;

@Entity(name = "client_type")
@Table(name = "client_types")
public class ClientTypeEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "client_type_id", nullable = false, updatable = false)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "client_type_type", nullable = false, updatable = false)
    private ClientTypes clientTypeType;
    
    @OneToOne(mappedBy = "clientType")
    @PrimaryKeyJoinColumn
    private ClientEntity clientEntity;

    public ClientTypeEntity() {
        super();
    }

    public ClientTypeEntity(Long id, ClientTypes clientTypeType, ClientEntity clientEntity) {
        super();
        this.id = id;
        this.clientTypeType = clientTypeType;
        this.clientEntity = clientEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientTypes getClientTypeType() {
        return clientTypeType;
    }

    public void setClientTypeType(ClientTypes clientTypeType) {
        this.clientTypeType = clientTypeType;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }
    
    
}
