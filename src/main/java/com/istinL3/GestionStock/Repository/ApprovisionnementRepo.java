package com.istinL3.GestionStock.Repository;

import com.istinL3.GestionStock.Model.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ApprovisionnementRepo extends JpaRepository<Approvisionnement, Integer> {
}
