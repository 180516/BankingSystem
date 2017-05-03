package pl.banking.entities;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by dpp on 4/1/17.
 */


@Entity(name = "client")
@Table(name = "CLIENTS")
@SequenceGenerator(name = "client_gen", sequenceName = "client_gen", allocationSize = 1)
public class ClientEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_gen")
    @Column (name = "client_id", nullable = false, updatable = false)
    private Long id;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private ClientTypeEntity clientType;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "pesel")
    private String pesel;
    
    @Column(name = "id_card_series")
    private String idCardSeries;
    
    @Column(name = "id_card_number")
    private String idCardNumber;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "company_name")
    private String companyName;
    
    @Column(name = "regon")
    private String regon;
    
    @Column(name = "nip")
    private String nip;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "maiden_name")
    private String maidenName;
    
    @Column(name = "parent_names")
    private String parentNames;
    
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime birthDate;
    
    @Column(name = "birth_place")
    private String birthPlace;
    
    @Column(name = "company_open_date")
    private LocalDateTime companyOpenDate;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private NationalityEntity nationality;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private ActivityEntity activity;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private CreditCategoryEntity creditCategory;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private PrivilegeCategoryEntity privilegeCategory;
    
    @Column(name = "last_contact_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime lastConcactDate;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private ClientStatusEntity clientStatus;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private BillCapitalizationEntity billCapitalization;

    public ClientEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getIdCardSeries() {
        return idCardSeries;
    }

    public void setIdCardSeries(String idCardSeries) {
        this.idCardSeries = idCardSeries;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getParentNames() {
        return parentNames;
    }

    public void setParentNames(String parentNames) {
        this.parentNames = parentNames;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public LocalDateTime getCompanyOpenDate() {
        return companyOpenDate;
    }

    public void setCompanyOpenDate(LocalDateTime companyOpenDate) {
        this.companyOpenDate = companyOpenDate;
    }

    public NationalityEntity getNationality() {
        return nationality;
    }

    public void setNationality(NationalityEntity nationality) {
        this.nationality = nationality;
    }

    public ActivityEntity getActivity() {
        return activity;
    }

    public void setActivity(ActivityEntity activity) {
        this.activity = activity;
    }

    public CreditCategoryEntity getCreditCategory() {
        return creditCategory;
    }

    public void setCreditCategory(CreditCategoryEntity creditCategory) {
        this.creditCategory = creditCategory;
    }

    public PrivilegeCategoryEntity getPrivilegeCategory() {
        return privilegeCategory;
    }

    public void setPrivilegeCategory(PrivilegeCategoryEntity privilegeCategory) {
        this.privilegeCategory = privilegeCategory;
    }

    public LocalDateTime getLastConcactDate() {
        return lastConcactDate;
    }

    public void setLastConcactDate(LocalDateTime lastConcactDate) {
        this.lastConcactDate = lastConcactDate;
    }

    public ClientStatusEntity getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(ClientStatusEntity clientStatus) {
        this.clientStatus = clientStatus;
    }

    public BillCapitalizationEntity getBillCapitalization() {
        return billCapitalization;
    }

    public void setBillCapitalization(BillCapitalizationEntity billCapitalization) {
        this.billCapitalization = billCapitalization;
    }

    public ClientTypeEntity getClientType() {
        return clientType;
    }

    public void setClientType(ClientTypeEntity clientType) {
        this.clientType = clientType;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ClientEntity [id=" + id + ", clientType=" + clientType + ", name=" + name + ", surname=" + surname
                + ", pesel=" + pesel + ", idCardSeries=" + idCardSeries + ", idCardNumber=" + idCardNumber
                + ", address=" + address + ", city=" + city + ", companyName=" + companyName + ", regon=" + regon
                + ", nip=" + nip + ", email=" + email + ", phoneNumber=" + phoneNumber + ", maidenName=" + maidenName
                + ", parentNames=" + parentNames + ", birthDate=" + birthDate + ", birthPlace=" + birthPlace
                + ", companyOpenDate=" + companyOpenDate + ", nationality=" + nationality + ", activity=" + activity
                + ", creditCategory=" + creditCategory + ", privilegeCategory=" + privilegeCategory
                + ", lastConcactDate=" + lastConcactDate + ", clientStatus=" + clientStatus + ", billCapitalization="
                + billCapitalization + "]";
    }
    
    
}
