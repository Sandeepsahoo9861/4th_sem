//Develop a Java banking application using polymorphism with three classes: Account,   
//SavingsAccount, and CurrentAccount. The abstract Account class  has private 
//attributes (accountNumber, balance) and abstract methods for deposit and 
//withdrawal. SavingsAccount adds an interestRate attribute, overrides deposit to 
//calculate interest, and ensures sufficient balance in withdrawal. CurrentAccount 
//introduces an overdraftLimit and overrides withdrawal to check this limit. In the 
//BankingApp class, instantiate both account types, perform transactions, and display 
//account details to demonstrate polymorphism. 
// for access the moltiple copy text enter the windows + v
//An abstract class can contain both abstract methods (methods without a body) and
//concrete methods (methods with a body).


package important;
abstract class Account {
    private String accountNumber;
    protected double balance;
    public Account(String accountNumber, double balance) {// it is the parent constructor
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}

class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);// super will call the parent constructor 
        this.interestRate = interestRate;
    }
    @Override
    public void deposit(double amount) {
        balance += amount + (amount * interestRate / 100);
    }
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) balance -= amount;//if the body of an if statement consists of only one statement,
                                                 //you can omit the curly braces {}
        else System.out.println("Insufficient funds for withdrawal");
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;
    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
    }
    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) balance -= amount;
        else System.out.println("Exceeds overdraft limit");
    }
}

public class Q8 {
    public static void main(String[] args) {
        Account savings = new SavingsAccount("SA123", 1000, 5.0);
        Account current = new CurrentAccount("CA456", 2000, 1000);

        savings.deposit(500);
        savings.withdraw(200);
        current.withdraw(1500);

        displayAccountDetails(savings);
        displayAccountDetails(current);
    }

    public static void displayAccountDetails(Account account) {
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: $" + account.getBalance());
        System.out.println();
    }
}