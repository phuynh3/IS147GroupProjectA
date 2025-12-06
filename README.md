( Group A ) Project name:
Banking System 

Members:
Alina Moughal, Phi Huynh, Ashraf Kizito, Alioune Mbaye, Fox Zhang, Jacob Kucinski.  

Roles: 
Project Manager-Alina, Coder-Phi Huynh, Tester-Alioune Mbaye, Frontend Developer-Fox Zhang, Systems Analyst-Ashraf Kizito. 

Project description:
Our group project focuses on developing a Banking System using IntelliJ- JAVA. The system is designed to allow users to create and manage bank accounts, perform deposits and withdrawals, check balances, and maintain transaction records. It demonstrates the use of object-oriented programming principles. The project’s main goal is to simulate a real-world banking operation, but in simpler terms. Showing how, as a group, we work together to develop a successful running program.

Task 2:
Pseudocode:
START {

  PROMPT user to enter a password
  READ password

  IF isValidPassword(password) {
    DISPLAY "Password is strong."
  } ELSE {
    DISPLAY "Password does not meet the required conditions."
  }

} END


FUNCTION isValidPassword(password) {

  IF length of password < 8 {
    RETURN false
  }

  SET hasDigit = false
  SET hasSpecialChar = false
  SET specialCharacters = "!@#$%^&*()_+-=[]{};:'\"\\|,.<>?/"

  FOR each character in password {
    IF character is a digit {
      SET hasDigit = true
    }
    IF character is in specialCharacters {
      SET hasSpecialChar = true
    }
    IF hasDigit AND hasSpecialChar {
      RETURN true
    }
  }

  RETURN false

} END FUNCTION

Task 3: 
Docker is a platform that lets you package applications and their dependencies into lightweight, portable containers. These containers ensure your app runs the same way on any system regardless of the operating system or setup. Everything it needs (like libraries, runtime, and configuration) is bundled inside the container. This makes development, testing, and deployment faster and more consistent.

Task 4: 

 Overview

In this task, we containerized a simple Java application using Docker and automated the build and push process to Docker Hub using GitHub Actions.

Steps Performed

1. Dockerfile Setup
   Created a Dockerfile using the `openjdk:23` base image.
   The file copies Java source files, compiles them, and runs the `HelloWorld` class.

   ```dockerfile
   FROM openjdk:23
   WORKDIR /app
   COPY src/ /app/
   RUN javac *.java
   CMD ["java", "HelloWorld"]
   ```

2. Docker Hub Configuration

   * Logged into Docker Hub.
   * Created a **Personal Access Token** with read/write/delete permissions.
   * Saved credentials for use in GitHub Secrets (`DOCKER_USERNAME` and `DOCKER_PASSWORD`).

3. GitHub Actions Workflow

   * Created a workflow file: `.github/workflows/docker.yml`.
   * Configured it to automatically build and push the Docker image to Docker Hub whenever changes are pushed to the `master` branch.

4. Automation Trigger

   * Committed and pushed changes to GitHub.
   * The GitHub Action built the Docker image and pushed it to Docker Hub automatically.

5. Run Docker Image
   Pulled and ran the image from Docker Hub:

   ```bash
   docker pull your-dockerhub-username/hello-world:latest
   docker run your-dockerhub-username/hello-world:latest
   ```

### Result

Successfully automated the process of building and deploying a Dockerized Java app using GitHub Actions and Docker Hub.

ask 4: JavaDocs & GitHub Pages

This task involves adding JavaDoc comments to the project, generating documentation, and hosting it using GitHub Pages.

📝 JavaDocs Added

Java classes and methods were updated with JavaDoc comments using tags like:

/**
 * Example description.
 * @author Name
 * @version 1.0
 */

🧠 Generating JavaDocs
Option 1: IntelliJ IDEA

Go to Tools → Generate JavaDoc…

Set Output directory: docs/

Select project scope

Generate and open docs/index.html

Option 2: Terminal
javadoc -d docs -sourcepath src -subpackages your.package.name


Example:

javadoc -d docs -sourcepath src -subpackages com.example.myapp

🌐 Hosting with GitHub Pages

Go to Settings → Pages

Source:

Branch: main

Folder: /docs

Save

Your docs will be available at:
https://your-username.github.io/your-repo-name/

📄 Why JavaDocs?

Improves readability

Helps maintain and understand the code

Creates professional project documentation

Final: 

# Java Banking System

A beginner-friendly console banking program in Java.  
Features: create account, deposit, withdraw, show account details.

---

## How to Run

1. Open project in IntelliJ IDEA
2. Place all `.java` files below inside **src**
3. Run `BankApp.java`
4. Use menu to test program

---

## 📌 Project Files & Code

### BankApp.java
```java
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
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> showAccount();
                case 0 -> System.out.println("Thank you for using the bank system!");
                default -> System.out.println("Invalid option.");
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
            System.out.println(success ? "Withdrawal successful." :
                    "Withdrawal failed (insufficient funds).");
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



