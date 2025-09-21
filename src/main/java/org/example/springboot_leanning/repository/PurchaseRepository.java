package org.example.springboot_leanning.repository;

import org.example.springboot_leanning.entity.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "insert into purchase values(null, ?, ?)";
        jdbc.update(sql, purchase.getProduct(),purchase.getPrice());
    }

}
