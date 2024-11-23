public class SavingsAccount extends BankAccount {
    // Instance variables
    private static final double RATE = 0.025; // Annual interest rate
    private int savingsNumber = 0;            // Savings account identifier
    private String accountNumber;             // Hidden account number

    // Constructor
    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance);
        // Initialize account number with "-0"
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    // Method to post monthly interest
    public void postInterest() {
        // Calculate one month's worth of interest
        double monthlyInterest = (getBalance() * RATE) / 12;
        // Deposit the interest into the account
        deposit(monthlyInterest);
    }

    // Override getAccountNumber method
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    // Copy constructor
    public SavingsAccount(SavingsAccount original, double initialBalance) {
        super(original, initialBalance);
        this.savingsNumber = original.savingsNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }
}