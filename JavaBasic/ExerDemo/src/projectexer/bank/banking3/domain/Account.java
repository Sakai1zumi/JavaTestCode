package projectexer.bank.banking3.domain;

/**
 * @author TuHong
 * @create 2021-02-25 11:48
 */
public class Account {
    protected double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public boolean deposit(double amt) {
        if(amt <= 0) return false;
        balance += amt;
        return true;
    }

    public boolean withdraw(double amt){
        if(amt > balance) return false;
        balance -= amt;
        return true;
    }
}
