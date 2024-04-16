package com.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="nombre_tabla")
public class Company {

    @Id
    @Column(name="id_company")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompany;
    @Column(name="company_name")
    private String name;
    private String address;

}
