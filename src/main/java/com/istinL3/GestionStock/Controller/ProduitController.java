package com.istinL3.GestionStock.Controller;

import com.istinL3.GestionStock.Model.Article;
import com.istinL3.GestionStock.Model.Client;
import com.istinL3.GestionStock.Services.ArticleService;
import com.istinL3.GestionStock.Services.CategorieService;
import com.istinL3.GestionStock.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class ProduitController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/article")
    public String pageArticle(Model model){
        Article article = new Article();

        model.addAttribute("article",article) ;
        model.addAttribute("listeClient",clientService.getClients()) ;
        model.addAttribute("listeArticle",articleService.getArticles());
        model.addAttribute("listeCategorie",categorieService.getCategories());
        return "produit";
    }

    @PostMapping("/saveArticle")
    public String savearticle(@ModelAttribute("article") Article article , RedirectAttributes ra){
        article.setDateCreation(LocalDate.now());
        articleService.savearticle(article);
        ra.addFlashAttribute("message","produit ajouter avec succes");
        return "redirect:/article";
    }

    @GetMapping("/supprimerArticle/{id}")
    public String supprimerarticle(@PathVariable(value = "id") int id){
        this.articleService.deleteArticle(id);
        return "redirect:/article";
    }
}
