package pl.banking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.banking.entities.BankAccountEntity;
import pl.banking.repositories.BankAccountRepository;
import pl.banking.service.wrappers.BankAccountWrapper;

/**
 * Created by dpp on 4/10/17.
 */

@Transactional
@Service
public class BankAccountService {

    private final Logger log = LoggerFactory.getLogger(BankAccountService.class);

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public boolean openBankAccount (BankAccountWrapper bankAccountWrapper) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity();

        return true;
    }

}
