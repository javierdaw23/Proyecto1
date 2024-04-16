package com.gestion.service;

import com.gestion.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> todas();
    Company buscarUna(int idCompany);
    Company alta(Company company);
    Company update(Company company);
    int delete (int idCompany);

}
