package pl.banking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.banking.entities.BankAccountEntity;
import pl.banking.repositories.BankAccountRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class BankingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingsystemApplication.class, args);
	}


	//For E2E purposes of testing - should ALWAYS BE commented on REPO side - problamatic with others
	//@Bean
	public CommandLineRunner demo (BankAccountRepository bankAccountRepository) {
		BankAccountEntity entity1 = new BankAccountEntity();
		BankAccountEntity entity2 = new BankAccountEntity();

		LocalDateTime localDateTime = LocalDateTime.now();
		entity1.setOpenDate(localDateTime);
		entity2.setOpenDate(localDateTime);

		entity1.setAccountPercentage(new BigDecimal("50"));
		entity2.setAccountPercentage(new BigDecimal("50"));

		entity1.setAccountCapitalization(new BigDecimal("50"));
		entity2.setAccountCapitalization(new BigDecimal("50"));

		entity1.setAccountNumber("PL83172971532576629824360301");
		entity2.setAccountNumber("PL31295993325375123180390764");

		return (args) -> {
			bankAccountRepository.save(entity1);
			bankAccountRepository.save(entity2);
		};
	}
}
