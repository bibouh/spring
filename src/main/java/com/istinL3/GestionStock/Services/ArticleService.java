package com.istinL3.GestionStock.Services;

import com.istinL3.GestionStock.Model.Article;

import java.util.List;

public interface ArticleService {
    Article savearticle(Article article);
    List <Article> getArticles();
    void deleteArticle(int id);
    Article getArticle(int id);
    Article updatearticle(int id);
}
