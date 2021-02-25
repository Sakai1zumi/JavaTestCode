package projectexer.bank.banking3.domain;

/**
 * @author TuHong
 * @create 2021-02-25 14:27
 */
public class CheckingAccount extends Account {

    private double overdraftProtection;

    public CheckingAccount() {
    }

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance,double overdraftProtection){
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    @Override
    public boolean withdraw(double amt) {
        if(amt <= balance){
            balance -= amt;
            return true;
        }else if(amt > balance && amt <= balance + overdraftProtection){
            overdraftProtection += balance - amt;
            balance = 0;
            return true;
        }else{
            return false;
        }
    }
}
