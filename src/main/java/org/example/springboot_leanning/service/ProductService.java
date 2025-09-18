package org.example.springboot_leanning.service;

import org.example.springboot_leanning.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private static final List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> findAll() {
        return products;
    }

    static {
        products.add(new Product("Apple", 1.99));
        products.add(new Product("Banana", 0.99));
        products.add(new Product("Orange", 1.49));
        products.add(new Product("Grapes", 2.99));
        products.add(new Product("Mango", 3.49));
        products.add(new Product("Pineapple", 2.79));
        products.add(new Product("Strawberry", 4.99));
        products.add(new Product("Blueberry", 5.49));
        products.add(new Product("Watermelon", 6.99));
        products.add(new Product("Peach", 2.59));
        products.add(new Product("Cherry", 7.99));
        products.add(new Product("Kiwi", 1.89));
        products.add(new Product("Pear", 2.19));
    }
}
