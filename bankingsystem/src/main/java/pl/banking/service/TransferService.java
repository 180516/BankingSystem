package pl.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.banking.entities.BankAccountEntity;
import pl.banking.entities.TransferEntity;
import pl.banking.exceptions.TransferException;
import pl.banking.repositories.BankAccountRepository;
import pl.banking.repositories.TransferRepository;
import pl.banking.service.wrappers.TransferDto;

import java.time.LocalDateTime;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    private final BankAccountRepository bankAccountRepository;

    private final BankAccountService bankAccountService;

    @Autowired
    public TransferService(TransferRepository transferRepository, BankAccountRepository bankAccountRepository,
                           BankAccountService bankAccountService) {
        this.transferRepository = transferRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountService = bankAccountService;
    }

    @Transactional
    public void makeTransfer(TransferDto transferDto) {
        BankAccountEntity creditor = bankAccountRepository.findByAccountNumber(transferDto.getCreditorAccountNumber())
                .orElseThrow(() ->  new TransferException("Creditor not found"));
        // TODO: I believe it is just a temporary solution, we should get debtor account number from logged user data
        BankAccountEntity debtor = bankAccountRepository.findByAccountNumber(transferDto.getDebtorAccountNumber())
                .orElseThrow(() ->  new TransferException("Debtor not found"));
        TransferEntity transferEntity = new TransferEntity();
        transferEntity.setCreditor(creditor);
        transferEntity.setDebtor(debtor);
        transferEntity.setAmount(transferDto.getAmount());
        transferEntity.setTitle(transferDto.getTitle());
        transferEntity.setCreditorName(transferDto.getCreditorName());
        transferEntity.setCreditorAddress(transferDto.getCreditorAddress());
        transferEntity.setDateTime(LocalDateTime.now());
        transferEntity.setFinalized(false);
        bankAccountService.reduceBalance(debtor.getAccountNumber(), transferDto.getAmount());
        transferRepository.save(transferEntity);
    }
}
