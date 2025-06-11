import java.util.*;

class BankAccount {
    private double balance = 0;
    private ArrayList<String> history = new ArrayList<>();

    public void deposit(double amount) {
        balance += amount;
        history.add("Deposited: ₹" + amount);
        System.out.println("✅ ₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            history.add("Withdrew: ₹" + amount);
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("❌ Insufficient balance!");
        }
    }

    public void transfer(double amount, String receiver) {
        if (amount <= balance) {
            balance -= amount;
            history.add("Transferred ₹" + amount + " to " + receiver);
            System.out.println("✅ ₹" + amount + " transferred to " + receiver + ".");
        } else {
            System.out.println("❌ Insufficient balance!");
        }
    }

    public void showBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    public void printHistory() {
        System.out.println("📜 Transaction History:");
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String entry : history) {
                System.out.println("- " + entry);
            }
        }
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount user = new BankAccount();

        String userId = "admin";
        String userPin = "1234";

        System.out.print("Enter User ID: ");
        String id = sc.nextLine();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (id.equals(userId) && pin.equals(userPin)) {
            int choice;
            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Balance");
                System.out.println("5. History");
                System.out.println("6. Exit");
                System.out.print("Choose option: ");

                while (!sc.hasNextInt()) {
                    System.out.println("❌ Please enter a valid option number.");
                    sc.next(); // clear invalid input
                }

                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("❌ Please enter a valid amount.");
                            sc.next();
                        }
                        double depositAmount = sc.nextDouble();
                        sc.nextLine(); // clear buffer
                        user.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("❌ Please enter a valid amount.");
                            sc.next();
                        }
                        double withdrawAmount = sc.nextDouble();
                        sc.nextLine(); // clear buffer
                        user.withdraw(withdrawAmount);
                        break;

                    case 3:
                        System.out.print("Enter amount to transfer: ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("❌ Please enter a valid amount.");
                            sc.next();
                        }
                        double transferAmount = sc.nextDouble();
                        sc.nextLine(); // clear buffer
                        System.out.print("Enter receiver name: ");
                        String receiver = sc.nextLine();
                        user.transfer(transferAmount, receiver);
                        break;

                    case 4:
                        user.showBalance();
                        break;

                    case 5:
                        user.printHistory();
                        break;

                    case 6:
                        System.out.println("👋 Thank you for using the ATM. Goodbye!");
                        break;

                    default:
                        System.out.println("❌ Invalid choice. Please select a number from 1 to 6.");
                }
            } while (choice != 6);
        } else {
            System.out.println("❌ Invalid ID or PIN.");
        }

        sc.close();
    }
}
