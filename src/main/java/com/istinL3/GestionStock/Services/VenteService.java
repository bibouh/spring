package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Vente;

import java.util.List;

public interface VenteService {
    Vente savevente(Vente vente);
    List<Vente> getVentes();
    void deleteVente(int id);
    Vente getVente(int id);
    Vente updatevente(int id);
}
