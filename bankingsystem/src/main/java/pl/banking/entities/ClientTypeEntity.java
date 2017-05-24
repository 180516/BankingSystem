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
    @Enumerated(EnumType.STRING)
    @Column(name = "client_type_type", nullable = false, updatable = false)
    private ClientTypes clientTypeType;

    public ClientTypeEntity() {
        super();
    }

    public ClientTypeEntity(ClientTypes clientTypeType) {
        super();
        this.clientTypeType = clientTypeType;
    }

    public ClientTypes getClientTypeType() {
        return clientTypeType;
    }

    public void setClientTypeType(ClientTypes clientTypeType) {
        this.clientTypeType = clientTypeType;
    }

    
}
