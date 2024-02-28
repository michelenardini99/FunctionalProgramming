package example.model;

public class SimpleBankAccountWithAtm implements BankAccount{

    private static final int FEE_AMOUNT = 1;
    private AccountHolder accountHolder;
    private int balance;

    public SimpleBankAccountWithAtm(AccountHolder accountHolder, int balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.accountHolder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (checkUserId(userID) && isAmountPositive(amount)) {
            this.balance += amount - FEE_AMOUNT;
        }    
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (checkUserId(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount + FEE_AMOUNT;
        }
    }

    private boolean isWithdrawAllowed(double amount) {
        return amount < this.balance && isAmountPositive(amount);
    }

    private boolean isAmountPositive(double amount) {
        return amount >= 0;
    }

    private boolean checkUserId(int userID) {
        return accountHolder.getId() == userID;
    }

}
