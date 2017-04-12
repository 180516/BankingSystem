package pl.banking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.banking.entities.BankAccountEntity;
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

    }

    public void editBankAccountDeatils (BankAccountDto bankAccountWrapper, BigInteger accountNumber) {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {
        } else {
            //TODO throw new exception
        }
    }

    public void suspendBankAccount (BigInteger accountNumber, LocalDateTime suspensionDate) {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {
            bankAccountEntity.get().setSuspendDate(suspensionDate);
        } else {
            //TODO throw new exception
        }
    }

    public void deleteBankAccount (BigInteger accountNumber) {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {
            //TODO: setup entity to have boolean field with active or deleted
        } else {
            //TODO throw new exception
        }
    }

    public void changeBalance (BigInteger accountNumber, BigDecimal amount) throws BankAccountNotFoundException{
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {

            if (Math.signum(amount.doubleValue()) == -1.0 && Math.abs(bankAccountEntity.get().getAccountBalance().doubleValue() - amount.doubleValue()) < 0) {
                //TODO: throw exception about getting TOO much from account and get it
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
