/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/06/2013
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO {
    private String accountNumber;
    private double amount;
    private long timeStamp;
    private String description;
    public TransactionDTO(String accountNumber,double amount,long timeStamp,String description)
    {
        this.accountNumber = accountNumber;
        this.description = description;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getDescription() {
        return description;
    }
}
