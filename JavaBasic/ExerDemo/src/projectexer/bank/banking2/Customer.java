package projectexer.bank.banking2;

/**
 * @author TuHong
 * @create 2021-02-25 12:00
 */
public class Customer {
    private String firstName;
    private String lastName;
    private SavingAccount savingAccount = null;
    private CheckingAccount checkingAccount = null;


    public Customer() {
    }

    public Customer(String f, String l) {
        this();
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public SavingAccount getSaving(){
        return savingAccount;
    }

    public CheckingAccount getChecking(){
        return checkingAccount;
    }

    public void setSaving(SavingAccount savingAccount){
        this.savingAccount = savingAccount;
    }

    public void setChecking(CheckingAccount checkingAccount){
        this.checkingAccount = checkingAccount;
    }
}
