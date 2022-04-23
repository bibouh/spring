package com.istinL3.GestionStock.Repository;

import com.istinL3.GestionStock.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArticleRepo extends JpaRepository<Article, Integer> {
}
