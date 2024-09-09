// # Problem: Banking System
// # Objective: Create a simple banking system in python that allows users to create accounts, deposit money, withdraw money, and check their balance.

// # Instructions:

// # Account Creation:

// # The user should be able to create a new bank account with an initial balance.
// # Each account should have a unique account number.
// # Deposit Money:

// # The user should be able to deposit money into their account by providing the account number and the deposit amount.
// # Withdraw Money:

// # The user should be able to withdraw money from their account by providing the account number and the withdrawal amount.
// # The system should check if there are sufficient funds in the account before allowing the withdrawal.
// # Check Balance:

// # The user should be able to check the balance of their account by providing the account number.
// # Exit System:

// # Provide an option to exit the banking system.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problem5 {
    private static Map<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    exitSystem();
                    break;
            }
        }
    }

    public static void createAccount(Scanner scanner) {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        Account account = new Account(initialBalance);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully!");
    }

    public static void deposit(Scanner scanner) {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }

    public static void withdraw(Scanner scanner) {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        Account account = accounts.get(accountNumber);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.withdraw(amount);
                System.out.println("Amount withdrawn successfully!");
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    public static void checkBalance(Scanner scanner) {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    public static void exitSystem() {
        System.out.println("Exiting system...");
        System.exit(0);
    }

    private static class Account {
        private double balance;

        public Account(double initialBalance) {
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }
}