package com.istinL3.GestionStock.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Approvisionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int refArticle;
    private int qt;
    private LocalDate dateApp;

}