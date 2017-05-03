package pl.banking.exceptions;

/**
 * Created by dpp on 5/3/17.
 */
public class AccountBalanceOverdoneException extends Exception{


    public AccountBalanceOverdoneException(String message) {
        super(message);
    }
}
