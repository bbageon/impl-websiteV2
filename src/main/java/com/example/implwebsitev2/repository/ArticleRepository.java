package com.example.implwebsitev2.repository;

import com.example.implwebsitev2.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
