package com.prommt.payments.dao;

import com.prommt.payments.entities.Payment;

import java.util.List;

public interface PaymentDao {

    void createPayment(Payment payment);

    Payment getPayment(long id);

    void deletePayment(Payment payment);

    List<Payment> getAllPayments();

}
