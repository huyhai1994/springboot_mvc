package org.example.springboot_leanning.controller;

import org.example.springboot_leanning.entity.ErrorDetail;
import org.example.springboot_leanning.entity.PaymentDetails;
import org.example.springboot_leanning.exception.NotEnoughMoneyException;
import org.example.springboot_leanning.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException e) {
            ErrorDetail errorDetails = new ErrorDetail();
            errorDetails.setMessage("Not enough money to make the payment");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(errorDetails);
        }
    }
}
