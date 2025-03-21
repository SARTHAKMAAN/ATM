public class BankAccount {
    private double balance;
    private int pin;

    public BankAccount(double initialBalance, int initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean validatePIN(int enteredPin) {
        return this.pin == enteredPin;
    }

    public boolean changePIN(int oldPin, int newPin) {
        if (validatePIN(oldPin) && newPin > 999 && newPin < 10000) { // Ensuring a 4-digit PIN
            this.pin = newPin;
            return true;
        }
        return false;
    }
}
