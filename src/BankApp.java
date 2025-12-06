import java.util.Scanner;


public class BankApp {


    private static final Scanner input = new Scanner(System.in);
    private static Bank bank = new Bank("My Beginner Bank");


    public static void main(String[] args) {


        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice: ");


            while (!input.hasNextInt()) {
                System.out.println("Please enter a number.");
                input.nextLine();
            }
            choice = input.nextInt();
            input.nextLine();


            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    showAccount();
                    break;
                case 0:
                    System.out.println("Thank you for using the bank system!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }


        } while (choice != 0);


        input.close();
    }


    private static void printMenu() {
        System.out.println("\n=== BANK MENU ===");
        System.out.println("1. Open new account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Show account details");
        System.out.println("0. Exit");
    }


    private static void createAccount() {
        System.out.print("Enter customer name: ");
        String name = input.nextLine();


        System.out.print("Initial deposit: ");
        double amount = input.nextDouble();
        input.nextLine();


        bank.openCheckingAccount(name, amount);
    }


    private static void deposit() {
        System.out.print("Enter account number: ");
        int accNum = input.nextInt();
        System.out.print("Amount to deposit: ");
        double amount = input.nextDouble();
        input.nextLine();


        Account acc = bank.findAccount(accNum);
        if (acc != null) {
            acc.deposit(amount);
            System.out.println("Deposit complete.");
            System.out.println("New balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }


    private static void withdraw() {
        System.out.print("Enter account number: ");
        int accNum = input.nextInt();
        System.out.print("Amount to withdraw: ");
        double amount = input.nextDouble();
        input.nextLine();


        Account acc = bank.findAccount(accNum);


        if (acc != null) {
            boolean success = acc.withdraw(amount);
            String message = success ? "Withdrawal successful."
                    : "Withdrawal failed (not enough funds or over limit).";
            System.out.println(message);
            System.out.println("Balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }


    private static void showAccount() {
        System.out.print("Enter account number: ");
        int accNum = input.nextInt();
        input.nextLine();


        Account acc = bank.findAccount(accNum);
        if (acc != null) {
            System.out.printf("%s%n", acc);
        } else {
            System.out.println("Account not found.");
        }
    }
}






