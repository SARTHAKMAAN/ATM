public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000, 1234); // Initial balance: 5000, PIN: 1234
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
