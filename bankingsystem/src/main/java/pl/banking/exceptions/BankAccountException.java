package pl.banking.exceptions;

public class BankAccountException extends RuntimeException {

    public BankAccountException() {
    }

    public BankAccountException(String message) {
        super(message);
    }

    public BankAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}
