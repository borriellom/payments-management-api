package com.prommt.payments.dao;

import com.prommt.payments.entities.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDaoImpl extends AbstractJpaDAO<Payment> implements PaymentDao {

    public PaymentDaoImpl() {
        setClazz(Payment.class);
    }

    @Override
    public void createPayment(Payment payment) {
        create(payment);
        refresh(payment);
    }

    @Override
    public Payment getPayment(long id) {
        return findOne(id);
    }

    @Override
    public void deletePayment(Payment payment) {
        delete(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return findAll();
    }
}
