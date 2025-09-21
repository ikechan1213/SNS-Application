package com.example.sns.domain;

import lombok.Data;
import jakarta.persistence.*;

//ユーザー登録とログインに使う情報
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
}