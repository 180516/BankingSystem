package pl.banking.entities;

import javax.persistence.*;

/**
 * Created by dpp on 4/1/17.
 */

@Entity(name = "investment")
@Table(name="INVESTMENTS")
@SequenceGenerator(name = "investment_gen", sequenceName = "investment_gen", allocationSize = 1)
public class InvestmentEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "investment_gen")
    @Column (name = "investment_id", nullable = false, updatable = false)
    private Long id;

    public InvestmentEntity () {
    }

    public Long getId() {
        return id;
    }

}
