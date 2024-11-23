public class CheckingAccount extends BankAccount {
    // Static constant for check-clearing fee
    private static final double FEE = 0.15;

    // Constructor
    public CheckingAccount(String name, double initialAmount) {
        super(name, initialAmount);
        // Append "-10" to the account number using the mutator
        setAccountNumber(getAccountNumber() + "-10");
    }

    // Override withdraw method
    @Override
    public boolean withdraw(double amount) {
        // Add the fee to the withdrawal amount
        double totalAmount = amount + FEE;
        // Call the superclass withdraw method
        return super.withdraw(totalAmount);
    }
}