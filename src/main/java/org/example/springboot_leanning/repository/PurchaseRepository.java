package org.example.springboot_leanning.repository;

import org.example.springboot_leanning.entity.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase VALUES(NULL, ?, ?)";
        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper =
                (r, i) -> Purchase.builder()
                        .id(r.getInt("id"))
                        .product(r.getString("product"))
                        .price(r.getBigDecimal("price"))
                        .build();
        return jdbc.query(sql, purchaseRowMapper);
    }

}
