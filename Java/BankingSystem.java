import java.util.ArrayList;
import java.util.Scanner;

public class problem5 {

    private static ArrayList<Account> accounts = new ArrayList<>();  // Using ArrayList to store accounts

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
        
        // Create and add account to the ArrayList
        Account account = new Account(accountNumber, initialBalance);
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    public static void deposit(Scanner scanner) {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        Account account = findAccountByNumber(accountNumber);
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

        Account account = findAccountByNumber(accountNumber);
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

        Account account = findAccountByNumber(accountNumber);
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

    // Method to find account by account number
    public static Account findAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // Account class to store account details
    private static class Account {
        private int accountNumber;
        private double balance;

        public Account(int accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        public int getAccountNumber() {
            return accountNumber;
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
