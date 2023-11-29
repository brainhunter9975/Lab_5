package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Створення рахунків і додавання їх до банку
        BankAccount account1 = bank.createAccount("John Doe", 1000);
        BankAccount account2 = bank.createAccount("Alice Smith", 500);

        // Виведення початкового стану рахунків
        System.out.println("Initial Account Summary:");
        System.out.println(account1.getAccountSummary());
        System.out.println(account2.getAccountSummary());

        try {
            // Переказ коштів між рахунками
            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 300);

            // Виведення оновленого стану рахунків після переказу
            System.out.println("\nAccount Summary after transfer:");
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());
        } catch (InsufficientFundsException | AccountNotFoundException | NegativeAmountException e) {
            // Обробка винятків
            e.printStackTrace();
        }
    }
}