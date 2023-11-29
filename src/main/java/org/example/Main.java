package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n1. Створити рахунок\n2. Знайти рахунок\n3. Перевести кошти\n4. Вийти");
            System.out.print("Ввеіть номер дії: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введіть ім'я рахунку: ");
                    String accountName = scanner.nextLine();
                    System.out.print("Введіть стартовий депозит: ");
                    double initialDeposit = scanner.nextDouble();
                    scanner.nextLine(); // Очистка буфера

                    BankAccount createdAccount = bank.createAccount(accountName, initialDeposit);
                    System.out.println("Рахунок створено: " + createdAccount.getAccountSummary());
                    break;
                case 2:
                    System.out.print("Введіть номер рахунку: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера

                    try {
                        BankAccount foundAccount = bank.findAccount(accountNumber);
                        System.out.println("Рахунок знайдено: " + foundAccount.getAccountSummary());
                    } catch (AccountNotFoundException e) {
                        System.out.println("Рахунок не знайдено.");
                    }
                    break;
                case 3:
                    System.out.print("Введіть номер рахунку відправника: ");
                    int senderAccountNumber = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Введіть номер рахунку отримувача: ");
                    int receiverAccountNumber = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Введіть суму переказу: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // Очистка буфера

                    try {
                        bank.transferMoney(senderAccountNumber, receiverAccountNumber, transferAmount);
                        System.out.println("Переказ успішний!");
                    } catch (InsufficientFundsException | AccountNotFoundException | NegativeAmountException e) {
                        System.out.println("Переказ відхилено : " + e.getMessage());
                    }
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неправильний вибір.");
            }
        }
    }
}