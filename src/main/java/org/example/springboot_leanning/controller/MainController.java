package org.example.springboot_leanning.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot_leanning.service.ValidateInput;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Slf4j
public class MainController {

    @RequestMapping("/home/{color}/{username}")
    @ValidateInput
    public String home(@PathVariable @NonNull Optional<String> color, @PathVariable String username, Model page) {
        page.addAttribute("username", username);
        page.addAttribute("color", color.orElse("black"));
        return "home.html";
    }
}
