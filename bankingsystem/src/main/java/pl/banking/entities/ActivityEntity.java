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

import pl.banking.enums.Activities;

@Entity(name = "activity")
@Table(name = "activities")
public class ActivityEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "activity_id", nullable = false, updatable = false)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "activityType", nullable = false, insertable = false, updatable = false)
    private Activities activityType;
    
    @OneToOne(mappedBy = "activity")
    @PrimaryKeyJoinColumn
    private ClientEntity clientEntity;
    
    public ActivityEntity(){
        
    }

    public ActivityEntity(Long id, Activities activityType, ClientEntity clientEntity) {
        super();
        this.id = id;
        this.activityType = activityType;
        this.clientEntity = clientEntity;
    }
    
    

    public Long getId() {
        return id;
    }

    public Activities getActivityType() {
        return activityType;
    }
}
