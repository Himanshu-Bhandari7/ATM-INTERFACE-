import java.util.Scanner;
import java.util.ArrayList;

public class ATM {
    // Data variables for account balance, pin and transaction history
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;

    // Constructor to initialize the ATM machine with default values
    public ATM(int initialPin, double initialBalance) {
        this.balance = initialBalance;
        this.pin = initialPin;
        this.transactionHistory = new ArrayList<>();
    }

    // Main method to run the ATM simulation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample initial account with pin 1234 and balance $1000
        ATM atm = new ATM(1234, 1000.00);

        // ATM simulation menu
        while (true) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");

            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    atm.withdrawCash(scanner);
                    break;
                case 3:
                    atm.depositCash(scanner);
                    break;
                case 4:
                    atm.changePin(scanner);
                    break;
                case 5:
                    atm.viewTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to check account balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        addTransaction("Checked balance");
    }

    // Method to withdraw cash
    public void withdrawCash(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal successful. You withdrew: $" + amount);
            addTransaction("Withdrew $" + amount);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to deposit cash
    public void depositCash(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. You deposited: $" + amount);
            addTransaction("Deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to change PIN
    public void changePin(Scanner scanner) {
        System.out.print("Enter your current PIN: ");
        int currentPin = scanner.nextInt();

        if (currentPin == pin) {
            System.out.print("Enter your new PIN: ");
            int newPin = scanner.nextInt();
            pin = newPin;
            System.out.println("PIN changed successfully.");
            addTransaction("Changed PIN");
        } else {
            System.out.println("Incorrect current PIN.");
        }
    }

    // Method to view transaction history
    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // Helper method to add transactions to the history
    private void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
}
