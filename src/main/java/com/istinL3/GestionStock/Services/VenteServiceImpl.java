package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Article;
import com.istinL3.GestionStock.Model.Vente;
import com.istinL3.GestionStock.Repository.VenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteServiceImpl implements VenteService{
    @Autowired
    private VenteRepo venteRepo;
    @Override
    public Vente savevente(Vente vente) {
        return venteRepo.save(vente);
    }

    @Override
    public List<Vente> getVentes() {
        return venteRepo.findAll();
    }

    @Override
    public void deleteVente(int id) {
        venteRepo.deleteById(id);
    }

    @Override
    public Vente getVente(int id) {
        Optional<Vente> venteOptional =venteRepo.findById(id);
        Vente vente =null;
        if (venteOptional.isPresent()){
            vente = venteOptional.get();
        }else {
            throw new RuntimeException("Vente nom trouver"+id) ;
        }
        return vente;
    }

    @Override
    public Vente updatevente(int id) {
        return null;
    }
}
