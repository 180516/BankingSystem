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
    @GeneratedValue
    @Column(name = "client_status_id", nullable = false, updatable = false)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "client_status_type", nullable = false, updatable = false)
    private ClientStatuses clientStatusType;
    
    @OneToOne(mappedBy = "clientStatus")
    @PrimaryKeyJoinColumn
    private ClientEntity clientEntity;
    
    public ClientStatusEntity(){
        
    }

    public ClientStatusEntity(Long id, ClientStatuses clientStatusType, ClientEntity clientEntity) {
        super();
        this.id = id;
        this.clientStatusType = clientStatusType;
        this.clientEntity = clientEntity;
    }

    public Long getId() {
        return id;
    }

    public ClientStatuses getClientStatusType() {
        return clientStatusType;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }
}