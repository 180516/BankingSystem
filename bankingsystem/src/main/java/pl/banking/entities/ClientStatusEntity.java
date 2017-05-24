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

@Entity(name = "client_status")
@Table(name = "client_statuses")
public class ClientStatusEntity {
    
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "client_status_type", nullable = false, updatable = false)
    private ClientStatuses clientStatusType;
    
    public ClientStatusEntity(){
        
    }

    public ClientStatusEntity(ClientStatuses clientStatusType) {
        super();
        this.clientStatusType = clientStatusType;
    }

    public ClientStatuses getClientStatusType() {
        return clientStatusType;
    }

    public void setClientStatusType(ClientStatuses clientStatusType) {
        this.clientStatusType = clientStatusType;
    }

    
}