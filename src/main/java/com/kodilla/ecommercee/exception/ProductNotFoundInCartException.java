package com.kodilla.ecommercee.exception;

public class ProductNotFoundInCartException extends RuntimeException {
    public ProductNotFoundInCartException(final String message) {
        super(message);
    }
}
