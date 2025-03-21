import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    changePIN();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount that you want to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    private void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    private void changePIN() {
        System.out.print("Enter current PIN: ");
        int oldPIN = scanner.nextInt();

        if (account.validatePIN(oldPIN)) {
            System.out.print("Enter new 4-digit PIN: ");
            int newPIN = scanner.nextInt();
            if (account.changePIN(oldPIN, newPIN)) {
                System.out.println("PIN updated successfully.");
            } else {
                System.out.println("Invalid new PIN. Please enter a 4-digit number.");
            }
        } else {
            System.out.println("Incorrect PIN.");
        }
    }
}
