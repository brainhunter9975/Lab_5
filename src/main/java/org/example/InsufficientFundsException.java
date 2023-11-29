package org.example;

public class InsufficientFundsException extends Throwable {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
