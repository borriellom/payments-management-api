package com.prommt.payments.model;

public enum PaymentStatus {

    NOT_PAYED(0),
    PAYED(1);

    private int id;

    PaymentStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static PaymentStatus fromId(int id) {
        return switch (id) {
            case 0 -> PaymentStatus.NOT_PAYED;
            case 1 -> PaymentStatus.PAYED;
            default -> throw new IllegalArgumentException("PaymentStatus [" + id + "] not supported.");
        };
    }
}
