package pl.banking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.banking.entities.BankAccountEntity;
import pl.banking.exceptions.AccountBalanceOverdoneException;
import pl.banking.exceptions.BankAccountNotFoundException;
import pl.banking.repositories.BankAccountRepository;
import pl.banking.service.wrappers.BankAccountDto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by dpp on 4/10/17.
 */

@Transactional
@Service
public class BankAccountService {

    private final Logger log = LoggerFactory.getLogger(BankAccountService.class);

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void openBankAccount (BankAccountDto bankAccountWrapper) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountWrapper.applyToEntity(bankAccountEntity);
    }

    public void editBankAccountDeatils (BankAccountDto bankAccountWrapper, BigInteger accountNumber) throws BankAccountNotFoundException {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {
        } else {
            throw new BankAccountNotFoundException("Account with number "+ accountNumber.toString() + " not found ");
        }
    }

    public void suspendBankAccount (BigInteger accountNumber, LocalDateTime suspensionDate) throws BankAccountNotFoundException {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {
            bankAccountEntity.get().setSuspendDate(suspensionDate);
        } else {
            throw new BankAccountNotFoundException("Account with number "+ accountNumber.toString() + " not found ");
        }
    }

    public void deleteBankAccount (BigInteger accountNumber) throws BankAccountNotFoundException {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {
            if (!bankAccountEntity.get().isDeleted()) {
                bankAccountEntity.get().setDeleted(true);
            }
        } else {
            throw new BankAccountNotFoundException("Account with number "+ accountNumber.toString() + " not found ");
        }
    }

    public void changeBalance (BigInteger accountNumber, BigDecimal amount) throws BankAccountNotFoundException, AccountBalanceOverdoneException {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {

            if (Math.signum(amount.doubleValue()) == -1.0 && Math.abs(bankAccountEntity.get().getAccountBalance().doubleValue() - amount.doubleValue()) < 0) {
                throw new AccountBalanceOverdoneException ("Cannot take that much money from this account");
            }

            bankAccountEntity.get().setAccountBalance(amount);
        } else {
            throw new BankAccountNotFoundException("Bank Account with number: " + accountNumber.toString() + " not found in database");
        }
    }

    public void changeAccountsCreditAndDebitSides (BigInteger debitAccountNumber, BigInteger creditAccountNumber, BigDecimal amount) throws BankAccountNotFoundException{
        Optional <BankAccountEntity> debitAccount = bankAccountRepository.findByAccountNumber(debitAccountNumber);
        Optional <BankAccountEntity> creditAccount = bankAccountRepository.findByAccountNumber(creditAccountNumber);

        if (debitAccount.isPresent() && creditAccount.isPresent()) {
            debitAccount.get().setDebitSide(debitAccount.get().getDebitSide().add(amount));
            creditAccount.get().setCreditSide(creditAccount.get().getCreditSide().add(amount));
        } else {
            if (!debitAccount.isPresent()) {
                throw new BankAccountNotFoundException("Debit account with number: " + debitAccountNumber.toString() + " not found in database");
            } else {
                throw new BankAccountNotFoundException("Credit account with number: " + creditAccountNumber.toString() + " not found in database");
            }
        }
    }
}
