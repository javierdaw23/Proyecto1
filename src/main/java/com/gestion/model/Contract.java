package com.gestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contract {

    @Id
    @Column(name = "id_contract")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContract;
    @Column(name = "name_contract")
    private String nameContract;
    private String info;
    @ManyToOne()
    @JoinColumn(name="id_company")
    private Company company;
}
