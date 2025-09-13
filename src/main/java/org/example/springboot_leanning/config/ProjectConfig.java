package org.example.springboot_leanning.config;

import org.example.springboot_leanning.service.ValidateAspect;
import org.example.springboot_leanning.service.ValidateInput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
public class ProjectConfig {
    @Bean
    public ValidateAspect validateInput() {
        return new ValidateAspect();
    }
}
