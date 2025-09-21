package org.example.springboot_leanning.service;

import org.example.springboot_leanning.entity.PaymentDetails;
import org.example.springboot_leanning.exception.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
