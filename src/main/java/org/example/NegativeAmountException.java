package org.example;

public class NegativeAmountException extends Throwable {
    public NegativeAmountException(String message) {
        super(message);
    }
}
