package com.prommt.payments.controller;

import com.prommt.payments.exception.PaymentApiException;
import com.prommt.payments.exception.PaymentNotFoundException;
import com.prommt.payments.model.CreatePaymentRequest;
import com.prommt.payments.model.PaymentDto;
import com.prommt.payments.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentsController {

    private final PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/message")
    public String getMessage() {
        return "hello!";
    }

    @GetMapping
    public List<PaymentDto> listPayments() {
        return paymentService.listPayments();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentDto getPayment(@PathVariable("id") Long id) throws PaymentNotFoundException {
        return paymentService.getPayment(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDto createPayment(@RequestBody CreatePaymentRequest request) {

        return paymentService.createPayment(request);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentDto markAsPaid(@PathVariable("id") Long id) {

        return paymentService.markAsPaid(id);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePayment(@PathVariable("id") Long id) throws PaymentApiException {

        paymentService.deletePayment(id);
    }

}
