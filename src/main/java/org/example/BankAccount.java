package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Amount cannot be negative");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Amount cannot be negative");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + ", Name: " + accountName + ", Balance: " + balance;
    }
}
