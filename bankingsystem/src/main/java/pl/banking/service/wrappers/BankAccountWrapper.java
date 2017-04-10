package pl.banking.service.wrappers;

import org.springframework.format.annotation.DateTimeFormat;
import pl.banking.entities.BankAccountEntity;
import pl.banking.entities.CurrencyEntity;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;


/**
 * Created by dpp on 4/10/17.
 */
public class BankAccountWrapper {


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

    private BigInteger accountNumber;

    private BigDecimal accountCapitalization;

    private BigDecimal accountCreadit;

    private CurrencyEntity currency;

}
