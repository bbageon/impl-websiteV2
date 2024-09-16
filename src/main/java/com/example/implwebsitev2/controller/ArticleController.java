package com.example.implwebsitev2.controller;

import com.example.implwebsitev2.domain.Article;
import com.example.implwebsitev2.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {
    // 인스턴스 의존성 주입
    private final ArticleRepository articleRepository;

    // 게시글 생성
    @PostMapping("/create")
    public Article create(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    // 게시글 전체 조회
    @GetMapping("/search")
    public List<Article> searchAllArticle() {
        return articleRepository.findAll();
    }

    // 게시글 개별 조회
    @GetMapping("/search/{id}")
    public Article findById(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // 게시글 삭제
    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // 게시글 있는지 검사
        if (articleRepository.existsById(id)) {
            // 게시글 삭제
            articleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
