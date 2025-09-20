package org.example.springboot_leanning.controller;

import org.example.springboot_leanning.dto.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @GetMapping("/france")
    public Country country() {
        Country country = Country.of("France", 67);
        return  country;
    }
}
