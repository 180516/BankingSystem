package pl.banking.service.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public final class TransferDto {

    private BigDecimal amount;

    private String title;

    private String creditorAccountNumber;

    private String debtorAccountNumber;

    private String creditorName;

    private String creditorAddress;

    public TransferDto(@JsonProperty("amount") BigDecimal amount,
                       @JsonProperty("title") String title,
                       @JsonProperty("creditorAccountNumber") String creditorAccountNumber,
                       @JsonProperty("debtorAccountNumber") String debtorAccountNumber,
                       @JsonProperty("creditorName") String creditorName,
                       @JsonProperty ("creditorAddress") String creditorAddress) {
        this.amount = amount;
        this.title = title;
        this.creditorAccountNumber = creditorAccountNumber;
        this.debtorAccountNumber = debtorAccountNumber;
        this.creditorName = creditorName;
        this.creditorAddress = creditorAddress;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getTitle() {
        return title;
    }

    public String getCreditorAccountNumber() {
        return creditorAccountNumber;
    }

    public String getDebtorAccountNumber() {
        return debtorAccountNumber;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public String getCreditorAddress() {
        return creditorAddress;
    }
}
