package com.istinL3.GestionStock.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitController {
    @GetMapping("/produits")
    public String produit(){
        return "form-elements";
    }

    @GetMapping("/liste-des-produits")
    public String listeproduit(){
        return "produit";
    }

    @GetMapping("/modal")
    public String modal(){
        return "ui-modals";
    }


}
