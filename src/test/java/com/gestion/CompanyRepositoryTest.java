package com.gestion;

import com.gestion.model.Company;
import com.gestion.repository.CompanyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void altaCompanyTest() {
        Company company = Company.builder()
                .name("BME")
                .address("Margarita 14")
                .build();
        companyRepository.save(company);

        Assertions.assertThat(company.getIdCompany()).isGreaterThan(0);
    }

    @Test
    public void getCompanyTest() {
        companyRepository.save(new Company(1, "BME", "m"));
        Company company = companyRepository.findById(1).get();
        Assertions.assertThat(company.getIdCompany()).isEqualTo(1);
    }

    @Test
    public void getListOfCompanyTest() {
        companyRepository.save(new Company(1, "BME", "m"));
        List<Company> company = companyRepository.findAll();
        Assertions.assertThat(company.size()).isGreaterThan(0);
    }

    @Test
    public void updateCompanyTest() {
        companyRepository.save(new Company(1, "BME", "m"));
        Company companyUp = companyRepository.findById(1).get();
        companyUp.setAddress("C/Flor");
        Assertions.assertThat(companyUp.getAddress()).isEqualTo("C/Flor");
    }

    @Test
    public void deleteCompanyTest() {
        Company company = companyRepository.save(new Company(1, "BME", "m"));
        companyRepository.deleteById(1);
        Company company1 = null;
        Optional<Company> optionalCompany = companyRepository.findByName("BME");
        if (optionalCompany.isPresent()) {
            company1 = optionalCompany.get();
        }
        Assertions.assertThat(company1).isNull();
    }

}