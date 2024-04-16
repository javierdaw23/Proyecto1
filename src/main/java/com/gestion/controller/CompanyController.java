package com.gestion.controller;

import com.gestion.model.Company;
import com.gestion.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/listar")
    public List<Company> mostrar(){
        return companyService.todas();
    }

    @PostMapping("/alta")
    public ResponseEntity<?> alta(@RequestBody Company company){
        if (companyService.alta(company) != null){
            return ResponseEntity.status(201).body(company);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Alta no realizada");
        }
    }

    @GetMapping("/una/{id}")
    public Company buscarUna(@PathVariable("id") int idCompany){
        return companyService.buscarUna(idCompany);
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarUna(@RequestBody Company company){
        if (companyService.update(company) != null){
            return ResponseEntity.status(201).body(company);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Modificacion no realizada");
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public int eliminarUna(@PathVariable("id") int idCompany){
        return companyService.delete(idCompany);
    }

}
