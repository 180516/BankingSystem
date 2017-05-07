package pl.banking.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Matiz on 2017-05-07.
 */

@Entity(name = "repayment_schedule")
@Table(name="REPAYMENT_SCHEDULE")
@SequenceGenerator(name = "repayment_schedule_gen", sequenceName = "repayment_schedule_gen", allocationSize = 1)
public class RepaymentSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repayment_schedule_gen")
    @Column (name = "repayment_schedule_gen", nullable = false, updatable = false)
    private Long id;

    @Column (name = "repayment_date")
    private LocalDateTime repaymentDate;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "installment_number")
    private BigDecimal installmentNumber;

    @Digits(integer = 10, fraction = 2)
    @Column (name = "amount")
    private BigDecimal amount;

    @Digits(integer = 10, fraction = 2)
    @Column (name = "capital_installment")
    private BigDecimal capitalInstallment;

    @Digits(integer = 10, fraction = 2)
    @Column (name = "interest_installment")
    private BigDecimal interestInstallment;

    @Digits(integer = 10, fraction = 2)
    @Column (name = "charge_installment")
    private BigDecimal chargeInstallment;

    @Digits(integer = 10, fraction = 2)
    @Column (name = "penalty_installment")
    private BigDecimal penaltyInstallment;

    @Digits(integer = 10, fraction = 2)
    @Column (name = "excess_payment")
    private BigDecimal excessPayment;

    @Digits(integer = 10, fraction = 2)
    @Column (name = "additional_payment")
    private BigDecimal additionalPayment;

    @Digits(integer = 3, fraction = 2)
    @Column (name = "interest")
    private BigDecimal interest;

    @Digits(integer = 24, fraction = 2)
    @Column (name = "payment_type")
    private BigDecimal paymentType;

    @Column (name = "is_repaid")
    private Boolean isRepaid;
}