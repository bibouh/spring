package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Approvisionnement;

import java.util.List;

public interface ApprovisionnementService {
    Approvisionnement saveapprovisionnement(Approvisionnement approvisionnement);
    List<Approvisionnement> getApprovisionnements();
    void deleteApprovisionnement(int id);
    Approvisionnement getApprovisionnement(int id);
    Approvisionnement updateapprovisionnement(int id);


}
