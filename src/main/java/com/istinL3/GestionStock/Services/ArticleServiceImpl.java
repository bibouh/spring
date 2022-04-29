package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Article;
import com.istinL3.GestionStock.Model.Client;
import com.istinL3.GestionStock.Repository.ArticleRepo;
import com.istinL3.GestionStock.Repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{
   @Autowired
   private ArticleRepo articleRepo;
    @Override
    public Article savearticle(Article article) {
        return articleRepo.save(article);
    }

    @Override
    public List<Article> getArticles() {
        return articleRepo.findAll();
    }

    @Override
    public void deleteArticle(int id) {
        articleRepo.deleteById(id);
    }

    @Override
    public Article getArticle(int id) {
        Optional<Article> articleOptional = articleRepo.findById(id);
        Article article =null;
        if (articleOptional.isPresent()){
            article = articleOptional.get();
        }else {
            throw new RuntimeException("Client nom trouver"+id) ;
        }
        return article;
    }

    @Override
    public Article updatearticle(int id) {
        return null;
    }
}
