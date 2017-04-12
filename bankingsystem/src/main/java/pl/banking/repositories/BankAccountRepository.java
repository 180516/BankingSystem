package pl.banking.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.banking.entities.BankAccountEntity;

import java.math.BigInteger;
import java.util.Optional;

/**
 * Created by dpp on 4/1/17.
 */

@Transactional (propagation = Propagation.MANDATORY)
public interface BankAccountRepository extends PagingAndSortingRepository <BankAccountEntity, Long> {

    Optional<BankAccountEntity> findByAccountNumber(BigInteger accountNumber);

}
