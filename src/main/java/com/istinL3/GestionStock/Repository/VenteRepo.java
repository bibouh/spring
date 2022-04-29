package com.istinL3.GestionStock.Repository;
import com.istinL3.GestionStock.Model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VenteRepo extends JpaRepository<Vente, Integer> {
}
