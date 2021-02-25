package projectexer.bank.banking;

/**
 * @author TuHong
 * @create 2021-02-25 14:13
 */
public class Bank {
    private Customer[] customers;
    private int numOfCusts = 0;

    public Bank() {
        customers = new Customer[10];
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
