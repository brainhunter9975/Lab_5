package org.example;

public class AccountNotFoundException extends Throwable {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
