package com.istinL3.GestionStock.Controller;

import com.istinL3.GestionStock.Model.Approvisionnement;
import com.istinL3.GestionStock.Model.Article;
import com.istinL3.GestionStock.Services.ApprovisionnementService;
import com.istinL3.GestionStock.Services.ArticleService;
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
public class ApprovisionnementController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ApprovisionnementService approvisionnementService;

    @GetMapping("/approvisionnement")
    public String pageApprovisionnement(Model model){
       Approvisionnement approvisionnement = new Approvisionnement();
        model.addAttribute("approvisionnement",approvisionnement) ;
        model.addAttribute("listeArticle",articleService.getArticles()) ;
        model.addAttribute("listeApprovisionnement",approvisionnementService.getApprovisionnements()) ;
        return "approvisionnement";
    }
    @PostMapping("/saveApprovisionnement")
    public String saveapprovisionnement(@ModelAttribute("approvisionnement") Approvisionnement approvisionnement , Article article, RedirectAttributes ra){
        approvisionnement.setDateApp(LocalDate.now());
        approvisionnementService.saveapprovisionnement(approvisionnement);
        article.setId( approvisionnement.getArticle().getId());
        article.setStocks(article.getStocks()+approvisionnement.getQt());
        ra.addFlashAttribute("message","approvisionnement ajoute avec succes");
        articleService.savearticle(article);

        return "redirect:/approvisionnement";
    }
    @GetMapping("/supprimerApprovisionnement/{id}")
    public String supprimerapprovisionnement(@PathVariable(value = "id") int id,RedirectAttributes ra){
        ra.addFlashAttribute("message","approvisionnement supprime avec succes");
        this.approvisionnementService.deleteApprovisionnement(id);
        return "redirect:/approvisionnement";
    }


}
