public class CheckingAccount extends BankAccount {
    private static final double FEE = 0.15;

    public CheckingAccount(String name, double initialAmount) {
        super(name, initialAmount);

        // Append "-10" to account number using provided mutator
        String currentAccountNumber = getAccountNumber();
        setAccountNumber(currentAccountNumber + "-10");
    }

    @Override
    public boolean withdraw(double amount) {
        // Withdraw amount plus fee using superclass method
        return super.withdraw(amount + FEE);
    }
}