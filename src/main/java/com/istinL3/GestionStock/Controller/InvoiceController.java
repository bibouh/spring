package com.istinL3.GestionStock.Controller;

import com.istinL3.GestionStock.Model.Vente;
import com.istinL3.GestionStock.Repository.VenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    private VenteRepo venteRepo;

    @GetMapping("/recu")
    public String listerecu(Model model){
        model.addAttribute("totale",venteRepo.getall()) ;
        return "invoices-list";
    }

    @GetMapping("/recu/{id}")
    public String invoice(Model model , @PathVariable("id") int id){
        model.addAttribute("recu",venteRepo.getleRecue(id)) ;
        model.addAttribute("nomclient",venteRepo.getNom(id)) ;
        model.addAttribute("totale",venteRepo.gettotale(id)) ;
        return "invoices-detail";
    }
}
