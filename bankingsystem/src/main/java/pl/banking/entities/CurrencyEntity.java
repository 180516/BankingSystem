package pl.banking.entities;

import javax.persistence.*;

import pl.banking.enums.Currency;

/**
 * Created by dpp on 4/1/17.
 */


@Entity(name = "currency")
@Table(name="CURRENCIES")
@SequenceGenerator(name = "currency_gen", sequenceName = "currency_gen", allocationSize = 1)
public class CurrencyEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_gen")
    @Column (name = "currency_id", nullable = false, updatable = false)
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column (name = "currencyType", nullable = false, insertable = false, updatable = false)
    private Currency currencyType;

    @OneToOne (mappedBy = "currency")
    @PrimaryKeyJoinColumn
    private BankAccountEntity bankAccountEntity;

    public CurrencyEntity() {
    }

    public Long getId() {
        return id;
    }

    public Currency getCurrencyType() {
        return currencyType;
    }
}
