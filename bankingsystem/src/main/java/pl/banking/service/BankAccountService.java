package pl.banking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.banking.entities.BankAccountEntity;
import pl.banking.exceptions.BankAccountException;
import pl.banking.exceptions.BankAccountNotFoundException;
import pl.banking.exceptions.TransferException;
import pl.banking.repositories.BankAccountRepository;
import pl.banking.service.wrappers.BankAccountDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by dpp on 4/10/17.
 */

@Service
@Transactional
public class BankAccountService {

    private final Logger log = LoggerFactory.getLogger(BankAccountService.class);

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void openBankAccount (BankAccountDto bankAccountWrapper) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountWrapper.applyToEntity(bankAccountEntity);
    }

    public void editBankAccountDeatils (BankAccountDto bankAccountWrapper, String accountNumber) throws
            BankAccountNotFoundException {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {
        } else {
            throw new BankAccountNotFoundException("Account with number "+ accountNumber.toString() + " not found ");
        }
    }

    public void suspendBankAccount (String accountNumber, LocalDateTime suspensionDate) throws BankAccountNotFoundException {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {
            bankAccountEntity.get().setSuspendDate(suspensionDate);
        } else {
            throw new BankAccountNotFoundException("Account with number "+ accountNumber.toString() + " not found ");
        }
    }

    public void deleteBankAccount (String accountNumber) throws BankAccountNotFoundException {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {
            if (!bankAccountEntity.get().isDeleted()) {
                bankAccountEntity.get().setDeleted(true);
            }
        } else {
            throw new BankAccountNotFoundException("Account with number "+ accountNumber.toString() + " not found ");
        }
    }

    public void reduceBalance(String accountNumber, BigDecimal amount) {
        BankAccountEntity bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber).
                orElseThrow(() -> new BankAccountException(String.format("Bank Account with number %s not found.",
                        accountNumber)));
        if(bankAccountEntity.getAccountBalance().compareTo(amount) == -1) {
            throw new TransferException(String.format("Insufficient balance on account with number %s", accountNumber));
        }
        bankAccountEntity.setAccountBalance(bankAccountEntity.getAccountBalance().subtract(amount));
        bankAccountRepository.save(bankAccountEntity);
    }

    public void creditBalance(String accountNumber, BigDecimal amount) {
        BankAccountEntity bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber).
                orElseThrow(() -> new BankAccountException(String.format("Bank Account with number %s not found.",
                        accountNumber)));
        bankAccountEntity.setAccountBalance(bankAccountEntity.getAccountBalance().add(amount));
        bankAccountRepository.save(bankAccountEntity);
    }

    public void changeAccountsCreditAndDebitSides (String debitAccountNumber, String creditAccountNumber, BigDecimal amount) throws BankAccountNotFoundException{
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
