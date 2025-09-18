package org.example.springboot_leanning.config;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot_leanning.service.ValidateAspect;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Slf4j
@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ValidateAspect validateInput() {
        log.info("validate aspect bean created!!!");
        return new ValidateAspect();
    }
}
