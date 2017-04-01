package pl.banking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.banking.entities.ror.BankAccountEntity;

/**
 * Created by dpp on 4/1/17.
 */

@Transactional (propagation = Propagation.MANDATORY)
public interface BankAccountRepository extends CrudRepository <BankAccountEntity, Long> {
}
