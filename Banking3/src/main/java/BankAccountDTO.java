/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 19/06/2013
 * Time: 14:05
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private String numberAccount;
    private double balance;

    public BankAccountDTO(String accountNumber) {
        this.numberAccount = accountNumber;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
