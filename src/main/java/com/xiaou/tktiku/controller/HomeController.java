package com.xiaou.tktiku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/question_banks";
    }

    @GetMapping("/admin/questions")
    public String questions() {
        return "admin/questions";
    }
}