package week5.lab.answers.partC;

// C1 answer. A BankAccount that refuses bad deposits and withdrawals
// (LMS Securing Data with Encapsulation, Part 12, exercise 1).
// Unlike the LMS example, withdraw also refuses a negative amount.
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit refused: " + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        System.out.println("Withdrawal refused: " + amount);
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

public class C1BankAccount {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.deposit(500);
        acc.deposit(-20);
        System.out.println(acc.withdraw(200));
        System.out.println(acc.withdraw(1000));
        System.out.println(acc.withdraw(-50));
        System.out.println("Balance: " + acc.getBalance());
        // acc.balance = 1000000;   // does not compile: balance has private access in BankAccount
        // That is good: no code outside the class can give the account an impossible balance.
        // Every change has to go through deposit or withdraw, and both of them check.
    }
}

// C4 answer (a sample). If balance were public, any code could write acc.balance = -500;
// and skip every check, so the account could hold a value the bank never allowed.
// Making it private means the only way in is through deposit and withdraw. Their if checks
// decide what counts as a valid change, in one place.
