package org.example.springboot_leanning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/home")
    public String home(@RequestParam() List<String> color, @RequestParam String name, Model page) {
        logger.info("request processing!!!");
        page.addAttribute("username", name);
        page.addAttribute("colors", color);
        return "home.html";
    }
}
