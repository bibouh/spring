package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie savecategorie(Categorie categorie);
    List<Categorie> getCategories();
    void deleteCategorie(int id);
    Categorie getCategorie(int id);
    Categorie updatecategorie(int id);
}
