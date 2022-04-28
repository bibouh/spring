package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Categorie;
import com.istinL3.GestionStock.Model.Client;
import com.istinL3.GestionStock.Repository.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService{

    @Autowired
    private CategorieRepo categorieRepo;

    @Override
    public Categorie savecategorie(Categorie categorie) {
        return categorieRepo.save( categorie);
    }

    @Override
    public List<Categorie> getCategories() {
        return categorieRepo.findAll();
    }

    @Override
    public void deleteCategorie(int id) {
        categorieRepo.deleteById(id);
    }

    @Override
    public Categorie getCategorie(int id) {
        Optional<Categorie> categorieOptional = categorieRepo.findById(id);
        Categorie categorie =null;
        if (categorieOptional.isPresent()){
            categorie = categorieOptional.get();
        }else {
            throw new RuntimeException("Categorie nom trouver"+id) ;
        }
        return categorie;
    }

    @Override
    public Categorie updatecategorie(int id) {
        return null;
    }
}
