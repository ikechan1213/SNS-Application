package com.example.sns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Gemini-SnsApplication.java
//エントリーポイントになるJavaファイル
@SpringBootApplication(scanBasePackages = "com.example.sns")
public class SnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnsApplication.class, args);
	}

}

