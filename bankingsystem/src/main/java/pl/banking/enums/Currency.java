package pl.banking.enums;

import java.io.Serializable;

/**
 * Created by dpp on 4/1/17.
 */
public enum Currency implements Serializable {

    USD("USD"),
    PLN("PLN"),
    EUR("EUR");

    private String currencyName;

    public String getCurrencyName() {
        return currencyName;
    }

    Currency(String currencyName) {
        this.currencyName = currencyName;
    }
}
