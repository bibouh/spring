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

public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int numero;
    @OneToOne
    private Article article;
    @Column(nullable = false)
    private int qtVendue;
    @OneToOne
    private Client client;
    @Column(nullable = false)
    private LocalDate dateDeVente;
}
