package org.example.springboot_leanning.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class ValidateAspect {

    @Around("@annotation(ValidateInput)")
    public Object validate(ProceedingJoinPoint jp) {
        Object[] requestObject = jp.getArgs();
        log.info("AOP intercept for method with arg- {}", requestObject);
        log.info("AOP intercept for method with signatures- {}", jp.getSignature());
        Object returnedValue;
        try {
            returnedValue = jp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return returnedValue;
    }

}
