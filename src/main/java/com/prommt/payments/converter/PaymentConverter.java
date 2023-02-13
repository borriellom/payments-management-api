package com.prommt.payments.converter;

import com.prommt.payments.entities.Payment;
import com.prommt.payments.model.PaymentDto;

public class PaymentConverter {

    private PaymentConverter() {}

    public static PaymentDto convert(Payment payment) {

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setCurrency(payment.getCurrency());
        paymentDto.setPayerEmail(payment.getPayerEmail());
        paymentDto.setId(payment.getId());
        paymentDto.setCreatedDate(payment.getCreatedDate());
        paymentDto.setStatus(payment.getStatus());
        paymentDto.setPaidDate(payment.getPaidDate());
        return paymentDto;
    }
}
