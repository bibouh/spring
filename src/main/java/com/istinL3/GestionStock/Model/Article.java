package com.istinL3.GestionStock.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String libelle;
    @Column(nullable = false)
    private int prix;
    @Column(nullable = false)
    private int qtSeuil;
    private LocalDate dateCreation;
    @OneToOne
    private Categorie categorie;
}
