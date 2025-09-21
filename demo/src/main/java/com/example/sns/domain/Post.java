package com.example.sns.domain;

import lombok.Data;
import jakarta.persistence.*;
//↑上の「javax.persistence」パッケージからバージョンの問題で「jakarta.persistence」パッケージに名称を変更
import java.time.LocalDateTime;

//誰が何を投稿したかを把握するための情報

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}