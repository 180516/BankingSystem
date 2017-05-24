package pl.banking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.banking.entities.TransferEntity;

import java.util.List;

@Transactional
public interface TransferRepository extends CrudRepository<TransferEntity, Long> {

    List<TransferEntity> findByFinalizedFalse();
}
