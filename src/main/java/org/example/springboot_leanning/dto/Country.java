package org.example.springboot_leanning.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
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
