package com.istinL3.GestionStock.Controller;

import com.istinL3.GestionStock.Model.Article;
import com.istinL3.GestionStock.Model.Categorie;

import com.istinL3.GestionStock.Model.Vente;
import com.istinL3.GestionStock.Services.ArticleService;
import com.istinL3.GestionStock.Services.CategorieService;
import com.istinL3.GestionStock.Services.ClientService;
import com.istinL3.GestionStock.Services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Random;

@Controller
public class VenteController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private VenteService venteService;

    @GetMapping("/vente")
    public String pageVente(Model model){
       Vente vente = new Vente();
        Random random = new Random();
        int rnd = random.nextInt(6);
        model.addAttribute("aleatoire",rnd) ;
        model.addAttribute("vente",vente) ;
        model.addAttribute("listeClient",clientService.getClients());
        model.addAttribute("listeArticle",articleService.getArticles());
        model.addAttribute("listeVente",venteService.getVentes()) ;
        return "vente";
    }
    @PostMapping("/saveVente")
    public String savevente(@ModelAttribute("vente") Vente vente , Article article, RedirectAttributes ra){
        vente.setDateDeVente(LocalDate.now());
        if (article.getStocks() < vente.getQtVendue()){
            return "redirect:/approvisionnement";
        }
        article.setStocks(article.getStocks()-vente.getQtVendue());
        ra.addFlashAttribute("message","vente ajoute avec succes");
        venteService.savevente(vente);
        return "redirect:/vente";
    }
    @GetMapping("/supprimerVente/{id}")
    public String supprimervente(@PathVariable(value = "id") int id , Article article , Vente vente,RedirectAttributes ra){
        ra.addFlashAttribute("message","vente supprime avec succes");
        this.venteService.deleteVente(id);
//        article.setId(vente.getArticle().getId());
//        article.setStocks(article.getStocks()+vente.getQtVendue());
//        articleService.savearticle(article);
        return "redirect:/vente";
    }
}
