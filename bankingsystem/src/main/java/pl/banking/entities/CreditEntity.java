package pl.banking.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Matiz on 2017-05-07.
 */

@Entity(name = "credit")
@Table(name="CREDITS")
@SequenceGenerator(name = "credit_gen", sequenceName = "credit_gen", allocationSize = 1)
public class CreditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_gen")
    @Column (name = "credit_gen", nullable = false, updatable = false)
    private Long id;

    @Column (name = "grant_date")
    private LocalDateTime grantDate;

    @Column (name = "start_date")
    private LocalDateTime startDate;

    @Column (name = "end_date")
    private LocalDateTime endDate;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "contract_number")
    private BigDecimal contractNumber;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "amount")
    private BigDecimal amount;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "interest_type")
    private BigDecimal interestType;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "interest")
    private BigDecimal interest;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "capitalization_of_interest")
    private BigDecimal capitalizationOfInterest;

    @Column (name = "purpose")
    private String purpose;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "repayment_period")
    private BigDecimal repaymentPeriod;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "grace_period")
    private BigDecimal gracePeriod;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "credit_condition")
    private BigDecimal creditCondition;

    @Column (name = "overdue_interest_calculation_method")
    private String overdueInterestCalculationMethod;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "overdue_interest")
    private BigDecimal overdueInterest;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "credit_type")
    private BigDecimal creditType;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "preparatory_commission")
    private BigDecimal preparatoryCommission;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "readiness_commission")
    private BigDecimal readinessCommission;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "earlier_repayment_commission")
    private BigDecimal earlierRepaymentCommission;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "max_debit")
    private BigDecimal maxDebit;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "bank_account_id")
    private BigDecimal bankAccountId;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "credit_type_id")
    private BigDecimal creditTypeId;

    public CreditEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(LocalDateTime grantDate) {
        this.grantDate = grantDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(BigDecimal contractNumber) {
        this.contractNumber = contractNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInterestType() {
        return interestType;
    }

    public void setInterestType(BigDecimal interestType) {
        this.interestType = interestType;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getCapitalizationOfInterest() {
        return capitalizationOfInterest;
    }

    public void setCapitalizationOfInterest(BigDecimal capitalizationOfInterest) {
        this.capitalizationOfInterest = capitalizationOfInterest;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public BigDecimal getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(BigDecimal repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public BigDecimal getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(BigDecimal gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public BigDecimal getCreditCondition() {
        return creditCondition;
    }

    public void setCreditCondition(BigDecimal creditCondition) {
        this.creditCondition = creditCondition;
    }

    public String getOverdueInterestCalculationMethod() {
        return overdueInterestCalculationMethod;
    }

    public void setOverdueInterestCalculationMethod(String overdueInterestCalculationMethod) {
        this.overdueInterestCalculationMethod = overdueInterestCalculationMethod;
    }

    public BigDecimal getOverdueInterest() {
        return overdueInterest;
    }

    public void setOverdueInterest(BigDecimal overdueInterest) {
        this.overdueInterest = overdueInterest;
    }

    public BigDecimal getCreditType() {
        return creditType;
    }

    public void setCreditType(BigDecimal creditType) {
        this.creditType = creditType;
    }

    public BigDecimal getPreparatoryCommission() {
        return preparatoryCommission;
    }

    public void setPreparatoryCommission(BigDecimal preparatoryCommission) {
        this.preparatoryCommission = preparatoryCommission;
    }

    public BigDecimal getReadinessCommission() {
        return readinessCommission;
    }

    public void setReadinessCommission(BigDecimal readinessCommission) {
        this.readinessCommission = readinessCommission;
    }

    public BigDecimal getEarlierRepaymentCommission() {
        return earlierRepaymentCommission;
    }

    public void setEarlierRepaymentCommission(BigDecimal earlierRepaymentCommission) {
        this.earlierRepaymentCommission = earlierRepaymentCommission;
    }

    public BigDecimal getMaxDebit() {
        return maxDebit;
    }

    public void setMaxDebit(BigDecimal maxDebit) {
        this.maxDebit = maxDebit;
    }

    public BigDecimal getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BigDecimal bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public BigDecimal getCreditTypeId() {
        return creditTypeId;
    }

    public void setCreditTypeId(BigDecimal creditTypeId) {
        this.creditTypeId = creditTypeId;
    }
}
