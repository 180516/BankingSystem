package pl.banking.bankAccountTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by dpp on 4/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
@Commit
public class BankAccountCrud {

    @Test
    public void shouldCreateNewBankAccount () throws Exception {

    }

}
