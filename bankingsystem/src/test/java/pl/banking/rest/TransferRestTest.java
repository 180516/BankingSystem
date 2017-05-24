package pl.banking.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import pl.banking.repositories.BankAccountRepository;
import pl.banking.repositories.TransferRepository;
import pl.banking.service.wrappers.TransferDto;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("classpath:/test.sql")
public class TransferRestTest {

    private final static String baseUrl = "/api/transfers";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Test
    public void shouldMakeTransferWhenBalanceIsGreaterThanTransferAmount() throws Exception {
        // given
        String debtorAccountNumber = "PL83172971532576629824360301";
        String creditorAccountNumber = "PL83172971532576629824360302";
        TransferDto transferDto = new TransferDto(new BigDecimal(30.00), "Transfer", creditorAccountNumber,
                debtorAccountNumber, "Goldstein", "GoldStreet 12/13, 93-123 Israel");

        //when
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(baseUrl, transferDto, Void.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(bankAccountRepository.findByAccountNumber(debtorAccountNumber).get().getAccountBalance
                ().compareTo(new BigDecimal(70.00)) == 0).isTrue();
        assertThat(bankAccountRepository.findByAccountNumber(creditorAccountNumber).get().getAccountBalance
                ().compareTo(new BigDecimal(100.00)) == 0).isTrue();
        assertThat(transferRepository.findOne(0L)).isNotNull();
    }

    @Test
    public void shouldMakeTransferWhenBalanceEqualsTransferAmount() throws Exception {
        // given
        String debtorAccountNumber = "PL83172971532576629824360301";
        String creditorAccountNumber = "PL83172971532576629824360302";
        TransferDto transferDto = new TransferDto(new BigDecimal(100.00), "Transfer", creditorAccountNumber,
                debtorAccountNumber, "Goldstein", "GoldStreet 12/13, 93-123 Israel");

        //when
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(baseUrl, transferDto, Void.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(bankAccountRepository.findByAccountNumber(debtorAccountNumber).get().getAccountBalance
                ().compareTo(new BigDecimal(0.00)) == 0).isTrue();
        assertThat(bankAccountRepository.findByAccountNumber(creditorAccountNumber).get().getAccountBalance
                ().compareTo(new BigDecimal(100.00)) == 0).isTrue();
        assertThat(transferRepository.findOne(0L)).isNotNull();
    }

    @Test
    public void shouldNotMakeTransferWhenBalanceIsLowerThanTransferAmount() throws Exception {
        // given
        String debtorAccountNumber = "PL83172971532576629824360301";
        String creditorAccountNumber = "PL83172971532576629824360302";
        TransferDto transferDto = new TransferDto(new BigDecimal(130.00), "Transfer", creditorAccountNumber,
                debtorAccountNumber, "Goldstein", "GoldStreet 12/13, 93-123 Israel");

        //when
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(baseUrl, transferDto, Void.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(bankAccountRepository.findByAccountNumber(debtorAccountNumber).get().getAccountBalance
                ().compareTo(new BigDecimal(100.0)) == 0).isTrue();
        assertThat(bankAccountRepository.findByAccountNumber(creditorAccountNumber).get().getAccountBalance
                ().compareTo(new BigDecimal(100.00)) == 0).isTrue();
        assertThat(transferRepository.findOne(0L)).isNull();
    }


}
