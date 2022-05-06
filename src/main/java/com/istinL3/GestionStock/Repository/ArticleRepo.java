package com.istinL3.GestionStock.Repository;

import com.istinL3.GestionStock.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {
    @Query("select count(*)  from Article a where a.qtSeuil > a.stocks ")
    public String getruine();

    @Query("select sum(a.stocks)  from Article a ")
    public String getstock();

    @Query("select sum(v.article.prix * v.qtVendue )  from Vente v ")
    public String getvendue();
}
