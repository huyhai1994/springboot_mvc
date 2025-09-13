package org.example.springboot_leanning.controller;

import org.example.springboot_leanning.service.ValidateInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/home/{color}")
    @ValidateInput
    public String home(@PathVariable @NonNull String color, Model page) {
        logger.info("request processing!!!");
        page.addAttribute("username", "Hai");
        page.addAttribute( "color", color);
        return "home.html";
    }
}
