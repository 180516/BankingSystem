package pl.banking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pl.banking.enums.Activities;

@Entity(name = "activity")
@Table(name = "activities")
public class ActivityEntity {
    
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "activityType", nullable = false, updatable = false)
    private Activities activityType;
    
    public ActivityEntity(){
        
    }

    public ActivityEntity(Activities activityType) {
        super();
        this.activityType = activityType;
    }

    public Activities getActivityType() {
        return activityType;
    }

    public void setActivityType(Activities activityType) {
        this.activityType = activityType;
    }
    
    
}
