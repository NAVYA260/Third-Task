import java.util.Scanner;
class ATM {
    private BankAccount userAccount;
    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        if (userAccount.getBalance() < amount) {
            System.out.println("Insufficient funds.");
            return;
        }
        userAccount.withdraw(amount);
        System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        userAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
    }
    public void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }
}
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        while (true) {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            double amount;

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
