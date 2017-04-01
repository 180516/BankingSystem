package pl.banking.entities.ror;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * Created by dpp on 3/30/17.
 */

@Entity (name = "bank_account")
@Table (name="BANK_ACCOUNT")
@SequenceGenerator (name = "bank_account_gen", sequenceName = "bank_account_gen", allocationSize = 1)
public class BankAccountEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "bank_account_gen")
    @Column (name = "bank_account_id", nullable = false, updatable = false)
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @NotNull
    @Column (name = "open_date")
    private LocalDateTime openDate;

    @NotNull
    @Column (name = "close_date")
    private LocalDateTime closeDate;

    @NotNull
    @Column (name = "suspend_date")
    private LocalDateTime suspendDate;

    @Digits (integer = 24, fraction = 2)
    @Column (name = "balance")
    private BigDecimal accountBalance;

    @Digits (integer = 3, fraction = 2)
    @Column (name = "percentage")
    private BigDecimal accountPercentage;

    @Digits (integer = 30, fraction = 0)
    @Column (name = "account_number")
    private BigInteger accountNumber;

    @Digits (integer = 24, fraction = 2)
    @Column (name = "capitalization")
    private BigDecimal accountCapitalization;


    @Digits (integer = 24, fraction = 2)
    @Column (name = "credit")
    private BigDecimal accountCreadit;

    public BankAccountEntity() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }

    public LocalDateTime getSuspendDate() {
        return suspendDate;
    }

    public void setSuspendDate(LocalDateTime suspendDate) {
        this.suspendDate = suspendDate;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getAccountPercentage() {
        return accountPercentage;
    }

    public void setAccountPercentage(BigDecimal accountPercentage) {
        this.accountPercentage = accountPercentage;
    }

    public BigInteger getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(BigInteger accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountCapitalization() {
        return accountCapitalization;
    }

    public void setAccountCapitalization(BigDecimal accountCapitalization) {
        this.accountCapitalization = accountCapitalization;
    }

    public BigDecimal getAccountCreadit() {
        return accountCreadit;
    }

    public void setAccountCreadit(BigDecimal accountCreadit) {
        this.accountCreadit = accountCreadit;
    }
}
