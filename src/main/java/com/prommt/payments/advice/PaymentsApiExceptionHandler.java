package com.prommt.payments.advice;

import com.prommt.payments.errors.PaymentsApiErrors;
import com.prommt.payments.exception.PaymentApiException;
import com.prommt.payments.exception.PaymentNotFoundException;
import com.prommt.payments.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PaymentsApiExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(PaymentsApiExceptionHandler.class);

    @ExceptionHandler({PaymentNotFoundException.class})
    public ResponseEntity<ErrorResponse> handlePaymentNotFound(PaymentNotFoundException exception) {

        logger.error("Payment not found", exception);
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({PaymentApiException.class})
    public ResponseEntity<ErrorResponse> handlePaymentNotFound(PaymentApiException exception) {

        logger.error("API Exception", exception);
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleUnexpectedException(Exception exception) {

        logger.error("Unexpected error", exception);
        ErrorResponse errorResponse = new ErrorResponse(PaymentsApiErrors.UNEXPECTED_ERROR);
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
