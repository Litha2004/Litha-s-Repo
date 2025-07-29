public class SavingsAccount extends BankAccount {
    private double rate = 0.025; // 2.5%
    private int savingsNumber = 0;
    private String accountNumber; // hides superclass accountNumber

    // Constructor: name and initial balance
    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    // Copy constructor: creates new savings account from an existing one
    public SavingsAccount(SavingsAccount original, double initialBalance) {
        super(original, initialBalance);
        this.savingsNumber = original.savingsNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
    }

    // Method to post monthly interest
    public void postInterest() {
        double monthlyInterest = getBalance() * (rate / 12);
        deposit(monthlyInterest);
    }

    // Override getAccountNumber
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}