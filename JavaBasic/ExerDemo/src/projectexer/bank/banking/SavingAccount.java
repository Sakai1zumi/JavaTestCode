package projectexer.bank.banking;

/**
 * @author TuHong
 * @create 2021-02-25 14:26
 */
public class SavingAccount extends Account{
    private double interestRate;

    public SavingAccount() {
    }

    public SavingAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
