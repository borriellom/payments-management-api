package com.prommt.payments.service;

import com.prommt.payments.exception.PaymentApiException;
import com.prommt.payments.exception.PaymentNotFoundException;
import com.prommt.payments.model.CreatePaymentRequest;
import com.prommt.payments.model.PaymentDto;

import java.util.List;

public interface PaymentService {

    PaymentDto createPayment(CreatePaymentRequest request);

    PaymentDto getPayment(long id) throws PaymentNotFoundException;

    PaymentDto markAsPaid(long id);

    void deletePayment(long id) throws PaymentApiException;

    List<PaymentDto> listPayments();
}
