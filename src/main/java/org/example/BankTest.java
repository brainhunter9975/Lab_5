package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void createAccount_ValidData_Success() {
        Bank bank = new Bank();
        BankAccount account = bank.createAccount("John Doe", 1000);
        assertEquals("John Doe", account.getAccountName());
        assertEquals(1000, account.getBalance());
    }

    @Test
    void findAccount_AccountExists_Success() throws AccountNotFoundException {
        Bank bank = new Bank();
        BankAccount account = bank.createAccount("John Doe", 1000);
        assertEquals(account, bank.findAccount(account.getAccountNumber()));
    }

    @Test
    void findAccount_AccountNotExists_ExceptionThrown() {
        Bank bank = new Bank();
        assertThrows(AccountNotFoundException.class, () -> bank.findAccount(123));
    }

    @Test
    void transferMoney_ValidTransfer_Success() throws InsufficientFundsException, AccountNotFoundException, NegativeAmountException {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("John Doe", 1000);
        BankAccount account2 = bank.createAccount("Alice Smith", 500);

        bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 300);

        assertEquals(700, account1.getBalance());
        assertEquals(800, account2.getBalance());
    }

    @Test
    void transferMoney_NegativeAmount_ExceptionThrown() {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("John Doe", 1000);
        BankAccount account2 = bank.createAccount("Alice Smith", 500);

        assertThrows(NegativeAmountException.class, () -> bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), -300));
    }
}
