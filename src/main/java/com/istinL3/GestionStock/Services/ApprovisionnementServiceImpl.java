package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Approvisionnement;
import com.istinL3.GestionStock.Model.Client;
import com.istinL3.GestionStock.Repository.ApprovisionnementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovisionnementServiceImpl implements ApprovisionnementService{
    @Autowired
    private ApprovisionnementRepo approvisionnementRepo;
    @Override
    public Approvisionnement saveapprovisionnement(Approvisionnement approvisionnement) {
        return approvisionnementRepo.save(approvisionnement);
    }

    @Override
    public List<Approvisionnement> getApprovisionnements() {
        return approvisionnementRepo.findAll();
    }

    @Override
    public void deleteApprovisionnement(int id) {
        approvisionnementRepo.deleteById(id);
    }

    @Override
    public Approvisionnement getApprovisionnement(int id) {
        Optional<Approvisionnement> approvisionnementOptional = approvisionnementRepo.findById(id);
        Approvisionnement approvisionnement =null;
        if (approvisionnementOptional.isPresent()){
            approvisionnement = approvisionnementOptional.get();
        }else {
            throw new RuntimeException("Approvisionnement nom trouver"+id) ;
        }
        return approvisionnement;    }

    @Override
    public Approvisionnement updateapprovisionnement(int id) {
        return null;
    }
}
