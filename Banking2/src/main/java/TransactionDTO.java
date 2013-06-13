/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 13/06/2013
 * Time: 15:37
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO {
    private String accountNumber;
    private double amount;
    private String description;
    private long timeStamp;

    public TransactionDTO(String accountNumber, long timeStamp, double amount, String description) {
        this.accountNumber = accountNumber;
        this.timeStamp = timeStamp;
        this.amount = amount;
        this.description = description;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        //double amount;
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
