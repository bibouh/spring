package com.istinL3.GestionStock.Controller;

import com.istinL3.GestionStock.Model.Categorie;

import com.istinL3.GestionStock.Services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categorie")
    public String pageCategorie(Model model){
       Categorie categorie = new Categorie();
        model.addAttribute("categorie",categorie) ;
        model.addAttribute("listeCategorie",categorieService.getCategories()) ;
        return "categorie";
    }
    @PostMapping("/saveCategorie")
    public String savecategorie(@ModelAttribute("categorie") Categorie categorie, RedirectAttributes ra){
        ra.addFlashAttribute("message","categorie ajoute avec succes");
        categorieService.savecategorie(categorie);
        return "redirect:/categorie";
    }
    @GetMapping("/supprimerCategorie/{id}")
    public String supprimercategorie(@PathVariable(value = "id") int id,RedirectAttributes ra){
        ra.addFlashAttribute("message","categorie supprime avec succes");
        this.categorieService.deleteCategorie(id);
        return "redirect:/categorie";
    }


}
