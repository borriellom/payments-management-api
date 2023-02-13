package com.prommt.payments.errors;

public interface PaymentsApiErrors {

    String PAYMENT_NOT_FOUND = "The payment does not exist.";
    String PAYMENT_PAID_NOT_DELETABLE = "Impossible to delete this payment: it has PAYED status.";
    String UNEXPECTED_ERROR = "An unexpected error occurred.";
}
