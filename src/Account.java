import java.util.Date;
public abstract class Account {


    private int accountNumber;
    private String ownerName;
    private double balance;
    private Date openedOn;


    public Account(int accountNumber, String ownerName,
                   double balance, Date openedOn) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.openedOn = openedOn;
    }


    public int getAccountNumber() {
        return accountNumber;
    }


    public String getOwnerName() {
        return ownerName;
    }


    public double getBalance() {
        return balance;
    }


    public Date getOpenedOn() {
        return openedOn;
    }


    protected void setBalance(double balance) {
        this.balance = balance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }


    public abstract boolean withdraw(double amount);


    @Override
    public String toString() {
        String status = (balance < 0) ? "OVERDRAWN" : "OK";
        return String.format("Account #%d (%s) - Balance: $%.2f - %s",
                accountNumber, ownerName, balance, status);
    }
}
