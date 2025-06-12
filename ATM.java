import java.util.*;

public class ATM {
    static Scanner sc = new Scanner(System.in);
    static float balance = 10000f;
    static List<String> miniStatement = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Enter Admin Name: ");
        String adminName = sc.nextLine();

        System.out.print("Enter ATM PIN: ");
        int enteredPin = sc.nextInt();

        int pin = 1234;

        if (enteredPin != pin) {
            System.out.println("Incorrect PIN! Access Denied.");
            return;
        }

        System.out.println("Welcome, " + adminName + "! Account Authorized.");

        int choice;
        do {
            System.out.println("\n========= ATM MENU =========");
            System.out.println("1. View Available Balance");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Deposit Amount");
            System.out.println("4. View Mini Statement");
            System.out.println("5. Transfer Amount");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    float withdraw = sc.nextFloat();
                    if (withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("Please collect your cash: ₹" + withdraw);
                        miniStatement.add("Withdrawn: ₹" + withdraw);
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    float deposit = sc.nextFloat();
                    balance += deposit;
                    System.out.println("Successfully Deposited: ₹" + deposit);
                    miniStatement.add("Deposited: ₹" + deposit);
                    break;

                case 4:
                    System.out.println("----- Mini Statement -----");
                    for (String transaction : miniStatement) {
                        System.out.println(transaction);
                    }
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 5:
                    System.out.print("Enter Receiver Account Number: ");
                    String receiver = sc.next();
                    System.out.print("Enter amount to transfer: ₹");
                    float transferAmount = sc.nextFloat();
                    if (transferAmount <= balance) {
                        balance -= transferAmount;
                        System.out.println("Successfully transferred ₹" + transferAmount + " to account " + receiver);
                        miniStatement.add("Transferred ₹" + transferAmount + " to A/C " + receiver);
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 6:
                    System.out.println("Thank you, " + adminName + ". Have a nice day!");
                    break;

                default:
                    System.out.println("Invalid Option. Try again.");
            }

        } while (choice != 6);
    }
}
