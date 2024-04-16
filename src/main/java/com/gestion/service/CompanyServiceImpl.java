package com.gestion.service;

import com.gestion.model.Company;
import com.gestion.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> todas() {
        return companyRepository.findAll();
    }

    @Override
    public Company buscarUna(int idCompany) {
        return companyRepository.findById(idCompany).orElse(null);
    }

    @Override
    public Company alta(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company) {
        if(this.buscarUna(company.getIdCompany()) != null ) {
            companyRepository.save(company);
            return company;
        }
        return null;
    }

    @Override
    public int delete(int idCompany) {
        if(this.buscarUna(idCompany) != null){
            companyRepository.deleteById(idCompany);
            return 1;
        }
        return 0;
    }
}
