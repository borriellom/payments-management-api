package com.prommt.payments.entities.converters;

import com.prommt.payments.model.PaymentStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PaymentStatus paymentStatus) {
        return paymentStatus.getId();
    }

    @Override
    public PaymentStatus convertToEntityAttribute(Integer id) {
        return PaymentStatus.fromId(id);
    }
}
