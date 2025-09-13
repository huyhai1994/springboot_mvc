package org.example.springboot_leanning.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ValidateAspect {
    private Logger logger = LoggerFactory.getLogger(ValidateAspect.class);

    @Around("@annotation(ValidateInput)")
    public Object validate(ProceedingJoinPoint jp) throws InterruptedException {
        logger.info("validating");
        Object returnedValue;
        try {
            returnedValue = jp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return returnedValue;
    }

}
