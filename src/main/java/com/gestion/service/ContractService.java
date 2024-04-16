package com.gestion.service;

import com.gestion.model.Contract;

import java.util.List;

public interface ContractService {


    List<Contract> listar();
    Contract addContract(Contract contract);
    Contract updateContract (Contract contract);
    int deleteContract (int idContract);
}
