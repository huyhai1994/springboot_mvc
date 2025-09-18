package org.example.springboot_leanning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        boolean loggedIn = false;

        if (loggedIn)
            model.addAttribute("message", "you are logged in.");
        else
            model.addAttribute("message", "Login failed!");
        return "login.html";
    }
}
