package pl.banking.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by dpp on 3/30/17.
 */

@Entity (name = "bank_account")
@Table (name="BANK_ACCOUNTS")
@SequenceGenerator (name = "bank_account_gen", sequenceName = "bank_account_seq", allocationSize = 1)
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

    @Column (name = "close_date")
    private LocalDateTime closeDate;

    @Column (name = "suspend_date")
    private LocalDateTime suspendDate;

    @Digits (integer = 24, fraction = 2)
    @Column (name = "balance")
    private BigDecimal accountBalance;

    @Digits (integer = 3, fraction = 2)
    @Column (name = "percentage")
    private BigDecimal accountPercentage;

    @NotNull
    @Pattern(regexp = "[A-Z]{2}\\d{26}")
    @Column (name = "account_number", updatable = false)
    private String accountNumber;

    @Digits (integer = 24, fraction = 2)
    @Column (name = "capitalization")
    private BigDecimal accountCapitalization;

    @Digits (integer = 24, fraction = 2)
    @Column (name = "account_credit")
    private BigDecimal creditSide;

    @Digits (integer = 24, fraction = 2)
    @Column (name = "account_debit")
    private BigDecimal debitSide;

    @Digits (integer = 24, fraction = 2)
    @Column (name = "credit")
    private BigDecimal accountCredit;

    @Column (name = "deleted")
    private boolean deleted = false;

    @OneToOne
    @PrimaryKeyJoinColumn
    private CurrencyEntity currency;


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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountCapitalization() {
        return accountCapitalization;
    }

    public void setAccountCapitalization(BigDecimal accountCapitalization) {
        this.accountCapitalization = accountCapitalization;
    }

    public BigDecimal getCreditSide() {
        return creditSide;
    }

    public void setCreditSide(BigDecimal creditSide) {
        this.creditSide = creditSide;
    }

    public BigDecimal getDebitSide() {
        return debitSide;
    }

    public void setDebitSide(BigDecimal debitSide) {
        this.debitSide = debitSide;
    }

    public BigDecimal getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(BigDecimal accountCreadit) {
        this.accountCredit = accountCreadit;
    }

    public CurrencyEntity getCurrency() {
        return currency;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
