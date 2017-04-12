package pl.banking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.banking.entities.BankAccountEntity;
import pl.banking.repositories.BankAccountRepository;
import pl.banking.service.wrappers.BankAccountWrapper;

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

    public void openBankAccount (BankAccountWrapper bankAccountWrapper) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity();

    }

    public void editBankAccountDeatils (BankAccountWrapper bankAccountWrapper, BigInteger accountNumber) {
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

    public void changeBalance (BigInteger accountNumber, BigDecimal amount) {
        Optional<BankAccountEntity> bankAccountEntity = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccountEntity.isPresent()) {

            if (Math.signum(amount.doubleValue()) == -1.0 && Math.abs(bankAccountEntity.get().getAccountBalance().doubleValue() - amount.doubleValue()) < 0) {
                //TODO: throw exception about getting TOO much from account and get it
            }

            bankAccountEntity.get().setAccountBalance(amount);
        } else {
            //TODO throw new exception
        }
    }

}
