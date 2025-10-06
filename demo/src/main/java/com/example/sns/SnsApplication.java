package com.example.sns;

//Gemini-SnsApplication.java
//エントリーポイントになるJavaファイル

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.sns") // ★ この部分を追加
public class SnsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SnsApplication.class, args);
    }
}

