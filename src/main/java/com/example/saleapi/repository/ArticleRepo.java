package com.example.saleapi.repository;

import com.example.saleapi.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article,Integer> {
    List<Article> findByDenomination(String denomination);
    Article findByClientName(String clientName);
}
