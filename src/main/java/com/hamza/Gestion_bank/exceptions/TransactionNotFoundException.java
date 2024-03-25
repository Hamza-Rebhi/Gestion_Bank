package com.hamza.Gestion_bank.exceptions;

public class TransactionNotFoundException  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public TransactionNotFoundException(String message) {
        super(message);
    }

    public TransactionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
