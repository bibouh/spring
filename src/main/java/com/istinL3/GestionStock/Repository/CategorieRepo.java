package com.istinL3.GestionStock.Repository;

import com.istinL3.GestionStock.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategorieRepo extends JpaRepository<Categorie, Integer> {
}
