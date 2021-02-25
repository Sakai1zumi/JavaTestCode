package projectexer.bank.banking2;

/**
 * @author TuHong
 * @create 2021-02-25 14:27
 */
public class CheckingAccount extends Account {

    private SavingAccount protectedBy = null;

    public CheckingAccount() {
    }

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance,SavingAccount protectedBy){
        super(balance);
        this.protectedBy = protectedBy;
    }

    @Override
    public boolean withdraw(double amt) {
        if(amt <= balance){
            balance -= amt;
            return true;
        }else if(amt > balance){
            if(protectedBy != null && protectedBy.getBalance() >= amt- balance){
                protectedBy.withdraw(amt - balance);
                balance = 0;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
