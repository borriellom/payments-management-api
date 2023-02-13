package com.prommt.payments.exception;

import com.prommt.payments.errors.PaymentsApiErrors;

public class PaymentNotFoundException extends PaymentApiException {

    public PaymentNotFoundException() {
        super(PaymentsApiErrors.PAYMENT_NOT_FOUND);
    }
}
