package org.example.springboot_leanning.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Purchase {
    private int id;
    private String product;
    private BigDecimal price;
}
