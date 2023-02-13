package com.prommt.payments.service;

import com.prommt.payments.dao.PaymentDao;
import com.prommt.payments.entities.Payment;
import com.prommt.payments.errors.PaymentsApiErrors;
import com.prommt.payments.exception.PaymentApiException;
import com.prommt.payments.exception.PaymentNotFoundException;
import com.prommt.payments.model.CreatePaymentRequest;
import com.prommt.payments.model.PaymentDto;
import com.prommt.payments.model.PaymentStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.prommt.payments.converter.PaymentConverter.convert;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    @Transactional
    public PaymentDto createPayment(CreatePaymentRequest request) {

        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setCurrency(request.getCurrency());
        payment.setPayerEmail(request.getPayerEmail());
        payment.setStatus(PaymentStatus.NOT_PAYED);
        paymentDao.createPayment(payment);

        return convert(payment);
    }

    @Override
    @Transactional(readOnly = true)
    public PaymentDto getPayment(long id) throws PaymentNotFoundException {

        Payment payment = paymentDao.getPayment(id);
        if (payment == null) {
            throw new PaymentNotFoundException();
        }
        return convert(payment);
    }

    @Override
    @Transactional
    public PaymentDto markAsPaid(long id) {
        Payment payment = paymentDao.getPayment(id);
        payment.setPaidDate(new Date());
        payment.setStatus(PaymentStatus.PAYED);
        return convert(payment);
    }

    @Override
    @Transactional
    public void deletePayment(long id) throws PaymentApiException {
        Payment payment = paymentDao.getPayment(id);
        if (payment.getStatus() == PaymentStatus.PAYED) {
            throw new PaymentApiException(PaymentsApiErrors.PAYMENT_PAID_NOT_DELETABLE);
        }
        paymentDao.deletePayment(payment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentDto> listPayments() {
        List<Payment> payments = paymentDao.getAllPayments();
        List<PaymentDto> paymentDtos = new ArrayList<>();
        payments.forEach(payment -> paymentDtos.add(convert(payment)));
        return paymentDtos;
    }
}
