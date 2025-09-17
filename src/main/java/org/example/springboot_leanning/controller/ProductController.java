package org.example.springboot_leanning.controller;

import org.example.springboot_leanning.entity.Product;
import org.example.springboot_leanning.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model) {
        productService.addProduct(
                Product.builder()
                        .name(name)
                        .price(price)
                        .build());
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
}
