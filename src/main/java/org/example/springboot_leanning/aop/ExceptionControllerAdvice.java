package org.example.springboot_leanning.aop;

import org.example.springboot_leanning.entity.ErrorDetail;
import org.example.springboot_leanning.exception.NotEnoughMoneyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetail> exceptionNotEnoughMoneyHandler() {
        return ResponseEntity
                .badRequest()
                .body(ErrorDetail
                        .builder()
                        .message("Not enough money to make the payment. ")
                        .build());
    }
}
