package com.example.sns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // /timelineと/login, /registerへのアクセスは認証なしで許可する
                        .requestMatchers("/timeline", "/login", "/register", "/api/auth/**").permitAll()
                        // それ以外の全てのリクエストは認証を必須とする
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {})
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}