package pl.banking.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.banking.entities.TransferEntity;
import pl.banking.repositories.TransferRepository;
import pl.banking.service.BankAccountService;

@Component
public class TransferFinalizer {

    private final Logger LOGGER = LoggerFactory.getLogger(TransferFinalizer.class);

    private final TransferRepository transferRepository;

    private final BankAccountService bankAccountService;

    @Autowired
    public TransferFinalizer(TransferRepository transferRepository, BankAccountService bankAccountService) {
        this.transferRepository = transferRepository;
        this.bankAccountService = bankAccountService;
    }

    //@Scheduled(cron="0 7 * * *") //we won't wait until 7AM next day
    @Scheduled(initialDelay = 60 * 1000, fixedRate = 60 * 1000)
    public void finalizeTransfers() {
        LOGGER.info("Finalizing transfers");
        transferRepository.findByFinalizedFalse().forEach(transferEntity -> finalizeTransfer(transferEntity));
    }

    @Transactional
    private void finalizeTransfer(TransferEntity transferEntity) {
        LOGGER.info("Finalizing transfer with id: {}", transferEntity.getId());
        bankAccountService.creditBalance(transferEntity.getCreditor().getAccountNumber(), transferEntity.getAmount());
        transferEntity.setFinalized(true);
    }
}
