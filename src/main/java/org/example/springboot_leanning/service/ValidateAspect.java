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
    public Object validate(ProceedingJoinPoint jp) {
        Object[] requestObject = jp.getArgs();
        logger.info("AOP intercept for method with arg- {}", requestObject);
        logger.info("AOP intercept for method with signatures- {}", jp.getSignature());
        Object returnedValue;
        try {
            returnedValue = jp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return returnedValue;
    }

}
