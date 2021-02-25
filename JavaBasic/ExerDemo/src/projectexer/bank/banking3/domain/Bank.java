package projectexer.bank.banking3.domain;

/**
 * @author TuHong
 * @create 2021-02-25 14:13
 */
public class Bank {
    private Customer[] customers;
    private int numOfCusts = 0;

    private Bank() {
        customers = new Customer[10];
    }

    private static Bank bank = new Bank();//bank为私有的静态属性

    public static Bank getBank(){
        return bank;
    }

    public void addCustomer(String f, String l){
        Customer customer = new Customer(f,l);
        customers[numOfCusts++] = customer;
    }

    public int getNumOfCusts(){
        return numOfCusts;
    }

    public Customer getCustomer(int index){
        return (index >= numOfCusts || index < 0) ?  null : customers[index] ;
    }
}
