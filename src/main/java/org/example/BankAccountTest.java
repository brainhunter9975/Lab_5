package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void deposit_ValidAmount_Success() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        assertDoesNotThrow(() -> account.deposit(500));
        assertEquals(1500, account.getBalance());
    }

    @Test
    void deposit_NegativeAmount_ExceptionThrown() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        assertThrows(NegativeAmountException.class, () -> account.deposit(-500));
    }

    @Test
    void withdraw_ValidAmount_Success() throws InsufficientFundsException, NegativeAmountException {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    void withdraw_NegativeAmount_ExceptionThrown() {
        BankAccount account = new BankAccount(1, "John Doe", 1000);
        assertThrows(NegativeAmountException.class, () -> account.withdraw(-500));
    }

    @Test
    void withdraw_InsufficientFunds_ExceptionThrown() {
        BankAccount account = new BankAccount(1, "John Doe", 100);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(500));
    }
}

