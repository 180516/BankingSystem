package pl.banking.clientTests;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.banking.entities.ActivityEntity;
import pl.banking.entities.BillCapitalizationEntity;
import pl.banking.entities.ClientEntity;
import pl.banking.entities.ClientStatusEntity;
import pl.banking.entities.ClientTypeEntity;
import pl.banking.entities.CreditCategoryEntity;
import pl.banking.entities.NationalityEntity;
import pl.banking.entities.PrivilegeCategoryEntity;
import pl.banking.enums.Activities;
import pl.banking.enums.BillCapitalizations;
import pl.banking.enums.ClientStatuses;
import pl.banking.enums.ClientTypes;
import pl.banking.enums.CreditCategories;
import pl.banking.enums.Nationalities;
import pl.banking.enums.PrivilegeCategories;
import pl.banking.repositories.ClientRepository;
import pl.banking.repositories.InvestmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTests {
    
    // Póki co taki zapychacz
    private static final Long DEFAULT_ID = 1L;    
    private static ClientEntity DEFAULT_CLIENT_ENTITY;
    
    @Autowired
    private ClientRepository clientRepo;
    
    @Autowired
    private InvestmentRepository invRepo;

    @Test
    public void testClientCreationAndSaving() {
        ClientEntity client1 = deepClone(DEFAULT_CLIENT_ENTITY);
        ClientEntity client2 = deepClone(DEFAULT_CLIENT_ENTITY);
        
        client2.setId(2L);
        
        clientRepo.save(client1);
        clientRepo.save(client2);
    }

    @BeforeClass
    public static void setUp(){
        ClientEntity client = new ClientEntity();

        //Tutaj blok klas encji (walić długość linii)
        ActivityEntity activity                     = new ActivityEntity          (Activities.SOME_ACTIVITY);
        BillCapitalizationEntity billCapitalization = new BillCapitalizationEntity(BillCapitalizations.SOME_CAP);
        ClientStatusEntity clientStatus             = new ClientStatusEntity      (ClientStatuses.SOME_STATUS);
        ClientTypeEntity clientType                 = new ClientTypeEntity        (ClientTypes.SOME_TYPE);
        CreditCategoryEntity creditCategory         = new CreditCategoryEntity    (CreditCategories.SOME_CATEGORY);
        NationalityEntity nationality               = new NationalityEntity       (Nationalities.UZBEKISTANI);
        PrivilegeCategoryEntity privilegeCategory   = new PrivilegeCategoryEntity (PrivilegeCategories.SOME_CATEGORY);
        

        //Tutaj dodaję klasy encji do klienta
        client.setActivity(activity);
        client.setBillCapitalization(billCapitalization);
        client.setClientStatus(clientStatus);
        client.setClientType(clientType);
        client.setCreditCategory(creditCategory);
        client.setNationality(nationality);
        client.setPrivilegeCategory(privilegeCategory);
        
        //Tutaj usupełniam inne pola klienta
        client.setId(DEFAULT_ID);
        client.setName("Mateusz");
        client.setSurname("Kozłowski");
        client.setPesel("0101016666");
        client.setIdCardSeries("ABS");
        client.setIdCardNumber("123456");
        client.setAddress("Kozie bobki 3/4");
        client.setCity("Sosnowiec");
        client.setCompanyName("Studio masażu kolan");
        client.setRegon("732065814");
        client.setNip("725-18-01-126");
        client.setEmail("alan_destroyer@gmail.com");
        client.setPhoneNumber("0-700-666-696");
        client.setMaidenName("");
        client.setParentNames("Leokadia Chryzostom");
        client.setBirthDate(LocalDateTime.of(2001, 1, 1, 07, 00));
        client.setBirthPlace("Starograd Szczeciński, ul. Łąkotek Obolałych 5");
        client.setCompanyOpenDate(LocalDateTime.of(2015, 3, 23, 11, 44));
        client.setLastConcactDate(LocalDateTime.now());
        
        DEFAULT_CLIENT_ENTITY = client;
    }
    
    private ClientEntity deepClone(ClientEntity client){
        ClientEntity clone = new ClientEntity();
        
        ActivityEntity activity                     = client.getActivity();
        BillCapitalizationEntity billCapitalization = client.getBillCapitalization();
        ClientStatusEntity clientStatus             = client.getClientStatus();
        ClientTypeEntity clientType                 = client.getClientType();
        CreditCategoryEntity creditCategory         = client.getCreditCategory();
        NationalityEntity nationality               = client.getNationality();
        PrivilegeCategoryEntity privilegeCategory   = client.getPrivilegeCategory();
        
        activity = new ActivityEntity(activity.getActivityType());
        billCapitalization = new BillCapitalizationEntity(billCapitalization.getBillCapitalizationType());
        clientStatus = new ClientStatusEntity(clientStatus.getClientStatusType());
        clientType = new ClientTypeEntity(clientType.getClientTypeType());
        creditCategory = new CreditCategoryEntity(creditCategory.getCreditCategoryType());
        nationality = new NationalityEntity(nationality.getNationalityType());
        privilegeCategory = new PrivilegeCategoryEntity (privilegeCategory.getPrivilegeCategoryType());
        
        clone.setActivity(activity);
        clone.setBillCapitalization(billCapitalization);
        clone.setClientStatus(clientStatus);
        clone.setClientType(clientType);
        clone.setCreditCategory(creditCategory);
        clone.setNationality(nationality);
        clone.setPrivilegeCategory(privilegeCategory);
        
        clone.setId(client.getId());
        clone.setName(client.getName());
        clone.setSurname(client.getSurname());
        clone.setPesel(client.getPesel());
        clone.setIdCardSeries(client.getIdCardSeries());
        clone.setIdCardNumber(client.getIdCardNumber());
        clone.setAddress(client.getAddress());
        clone.setCity(client.getCity());
        clone.setCompanyName(client.getCompanyName());
        clone.setRegon(client.getRegon());
        clone.setNip(client.getNip());
        clone.setEmail(client.getEmail());
        clone.setPhoneNumber(client.getPhoneNumber());
        clone.setMaidenName(client.getMaidenName());
        clone.setParentNames(client.getParentNames());
        
        LocalDateTime d = client.getBirthDate();
        clone.setBirthDate(LocalDateTime.of(d.getYear(), d.getMonth(), 
                d.getDayOfMonth(), d.getHour(), d.getMinute(), d.getSecond()));
        clone.setBirthPlace(client.getBirthPlace());
        
        d = client.getCompanyOpenDate();
        clone.setCompanyOpenDate(LocalDateTime.of(d.getYear(), d.getMonth(), 
                d.getDayOfMonth(), d.getHour(), d.getMinute(), d.getSecond()));
        
        d = client.getLastConcactDate();
        clone.setLastConcactDate(LocalDateTime.of(d.getYear(), d.getMonth(),
                d.getDayOfMonth(), d.getHour(), d.getMinute(), d.getSecond()));
        
        return clone;
    }
}
