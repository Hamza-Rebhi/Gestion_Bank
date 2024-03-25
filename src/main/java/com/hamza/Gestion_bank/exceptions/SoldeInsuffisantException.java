package com.hamza.Gestion_bank.exceptions;

public class SoldeInsuffisantException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public SoldeInsuffisantException(String message) {
        super(message);
    }

    public SoldeInsuffisantException(String message, Throwable cause) {
        super(message, cause);
    }
}
