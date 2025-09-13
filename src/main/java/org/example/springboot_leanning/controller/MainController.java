package org.example.springboot_leanning.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot_leanning.service.ValidateInput;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class MainController {

    @RequestMapping("/home/{color}")
    @ValidateInput
    public String home(@PathVariable @NonNull String color, Model page) {
        page.addAttribute("username", "Hai");
        page.addAttribute( "color", color);
        return "home.html";
    }
}
