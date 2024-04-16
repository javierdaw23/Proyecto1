package com.gestion;

import com.gestion.model.Company;
import com.gestion.service.CompanyService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Test
    public void altaCompanyTest() {
        Company company = Company.builder()
                .name("BME")
                .address("Margarita 14")
                .build();
        companyService.alta(company);
        Assertions.assertThat(company.getIdCompany()).isGreaterThan(0);
    }

    @Test
    public void getCompanyTest() {
        companyService.alta(new Company(1, "BME", "m"));
        Company company = companyService.buscarUna(1);
        Assertions.assertThat(company.getIdCompany()).isEqualTo(1);
    }

    @Test
    public void getListOfCompanyTest() {
        companyService.alta(new Company(1, "BME", "m"));
        List<Company> company = companyService.todas();
        Assertions.assertThat(company.size()).isGreaterThan(0);
    }

    @Test
    public void updateCompanyTest() {
        companyService.alta(new Company(1, "BME", "m"));
        Company companyUp = companyService.buscarUna(1);
        companyUp.setName("INTEL");
        companyService.update(companyUp);
        Assertions.assertThat(companyUp.getName()).isEqualTo("INTEL");
    }

    @Test
    public void deleteCompanyTest() {
        Company company = companyService.alta(new Company(1, "BME", "m"));
        companyService.delete(1);
        Company company1 = null;
        Optional<Company> optionalCompany = Optional.ofNullable(companyService.buscarUna(1));
        if (optionalCompany.isPresent()) {
            company1 = optionalCompany.get();
        }
        Assertions.assertThat(company1).isNull();
    }




}
