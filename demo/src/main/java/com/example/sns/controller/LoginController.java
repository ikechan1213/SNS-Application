package com.example.sns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

//    @GetMapping("/")
//    public String root() {
//        // ルートURL("/")にアクセスされたら"/login"にリダイレクトする
//        return "redirect:/login";
//    }
//

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // register.jspを返す
    }
}