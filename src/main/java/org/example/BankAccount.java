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
            throw new NegativeAmountException("Сума не може бути від'ємною");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Сума не може бути від'ємною");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Недостатньо коштів");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountName(){
        return accountName;
    }
    public String getAccountSummary() {
        return "Номер рахунку: " + accountNumber + ", Ім'я: " + accountName + ", Сума: " + balance;
    }
}
