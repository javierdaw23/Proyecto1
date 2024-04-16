package com.gestion.service;

import com.gestion.model.Contract;
import com.gestion.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContractServiceImpl implements ContractService{

    @Autowired
    ContractRepository contractRepository;
    @Override
    public List<Contract> listar() {
        return contractRepository.findAll();
    }

    @Override
    public Contract addContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Contract contract) {

        return contractRepository.save(contract);
    }

    @Override
    public int deleteContract(int idContract) {
        return 0;
    }
}
