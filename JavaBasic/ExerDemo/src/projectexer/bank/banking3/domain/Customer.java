package projectexer.bank.banking3.domain;

/**
 * @author TuHong
 * @create 2021-02-25 12:00
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account[] accounts;
    private final int MAX_ACCOUNTS = 5;
    private int numOfAccounts = 0;

    public Customer() {
        accounts = new Account[MAX_ACCOUNTS];
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

    public Account getAccount(int index) {
        return (index >= numOfAccounts || index < 0)? null : accounts[index];
    }

    public void addAccount(Account account) {
        if(account != null) accounts[numOfAccounts++] = account;
    }

    public int getNumOfAccounts(){
        return numOfAccounts;
    }
}
