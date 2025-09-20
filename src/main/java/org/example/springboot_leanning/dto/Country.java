package org.example.springboot_leanning.dto;

import lombok.Builder;

@Builder
public class Country {
    private String name;
    private int population;

    public static Country of(
            String name,
            int population
    ) {
        return Country.builder()
                .name(name)
                .population(population)
                .build();
    }
}
