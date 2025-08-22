package ENCAPSULATION;

class BankAccount {
    private int balance;  // ✅ Private variable (hidden)

    public void deposit(int amount) {
        if (amount > 0) {  // ✅ Only positive deposits
            balance += amount;
        }
    }

    public void setBalance(int amount) {
        if (amount >= 0) {  // ✅ Condition ensures valid value
            this.balance = amount;
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class Bankpiku {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.deposit(500);  // ✅ Deposited: 500
        account.setBalance(-789);  // ❌ This will NOT modify balance because of validation

        System.out.println("Balance: " + account.getBalance());  // ✅ Balance: 500
    }
}
//setBalance() allows external code to change balance directly, which is risky.
//A better approach is removing setBalance() entirely and allowing modifications only through deposit().
// if it public without set method also it can change
//Even though you removed setBalance(), balance is public, so anyone can directly modify it:(no encapsulation)
//account.balance = -1000;  

