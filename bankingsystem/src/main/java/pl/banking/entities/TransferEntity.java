package pl.banking.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transfer")
@Table(name = "transfers")
@SequenceGenerator(name = "transfer_gen", sequenceName = "transfer_seq", allocationSize = 1)
public class TransferEntity {

    @Id
    @NotNull
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "creditor_id")
    private BankAccountEntity creditor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "debtor_id")
    private BankAccountEntity debtor;

    @Digits(integer = 24, fraction = 2)
    private BigDecimal amount;

    @NotNull
    private String title;

    @NotNull
    @Size(min = 3)
    private String creditorName;

    @NotNull
    @Size(min = 10)
    private String creditorAddress;

    @NotNull
    private LocalDateTime dateTime;

    private boolean finalized;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BankAccountEntity getCreditor() {
        return creditor;
    }

    public void setCreditor(BankAccountEntity creditor) {
        this.creditor = creditor;
    }

    public BankAccountEntity getDebtor() {
        return debtor;
    }

    public void setDebtor(BankAccountEntity debtor) {
        this.debtor = debtor;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }

    public String getCreditorAddress() {
        return creditorAddress;
    }

    public void setCreditorAddress(String creditorAddress) {
        this.creditorAddress = creditorAddress;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isFinalized() {
        return finalized;
    }

    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }
}
