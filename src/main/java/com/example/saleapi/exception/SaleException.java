package com.example.saleapi.exception;

public class SaleException extends RuntimeException {

    public SaleException(final String message) {
        super(message);
    }

    public SaleException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
