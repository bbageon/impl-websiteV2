package com.example.implwebsitev2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

    @Entity
    @Getter
    @Setter

    public class Article {
        public enum ArticleCategory {
            project,
            research,
            memorize,
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Article_id; // 식별자 (기본 키)

        @NonNull
        @Column()
        private String Title; // 게시글 제목

        @NonNull
        @Column()
        private String content; // 게시글 내용

        @NonNull
        @Column()
        private String author; // 게시글 작성자

        @NonNull
        @Enumerated(EnumType.STRING)
        @Column()
        private ArticleCategory category; // 게시글 카테고리

        @Column
        @CreationTimestamp
        private LocalDateTime created_at; // 게시글 생성시간

        @Column
        @UpdateTimestamp
        private LocalDateTime updated_at; // 게시글 수정시간
    }

