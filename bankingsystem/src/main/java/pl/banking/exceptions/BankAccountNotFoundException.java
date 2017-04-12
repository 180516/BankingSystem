package pl.banking.exceptions;

/**
 * Created by dpp on 4/12/17.
 */
public class BankAccountNotFoundException extends Exception {

    public BankAccountNotFoundException(String message) {
        super(message);
    }
}
