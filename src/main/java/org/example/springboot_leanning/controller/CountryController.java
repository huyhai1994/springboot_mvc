package org.example.springboot_leanning.controller;

import org.example.springboot_leanning.dto.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @GetMapping("/france")
    public ResponseEntity<Country> country() {
        var country = Country.of("France", 67);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .header("Capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(country);
    }
}
