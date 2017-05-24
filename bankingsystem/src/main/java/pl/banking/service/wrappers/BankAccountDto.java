package pl.banking.service.wrappers;

import org.springframework.format.annotation.DateTimeFormat;
import pl.banking.entities.BankAccountEntity;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Created by dpp on 4/10/17.
 */
public class BankAccountDto {


    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime openDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime closeDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime suspendDate;

    private BigDecimal accountBalance;

    private BigDecimal accountPercentage;

    private String accountNumber;

    private BigDecimal accountCapitalization;

    private BigDecimal accountCredit;

    public void applyToEntity (BankAccountEntity bankAccountEntity) {
        bankAccountEntity.setOpenDate(openDate);
        bankAccountEntity.setAccountBalance(accountBalance);
        bankAccountEntity.setAccountPercentage(accountPercentage);
        bankAccountEntity.setAccountNumber(accountNumber);
        bankAccountEntity.setAccountCapitalization(accountCapitalization);
        bankAccountEntity.setAccountCredit(accountCredit);
    }

}
