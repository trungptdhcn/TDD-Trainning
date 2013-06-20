import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 20/06/2013
 * Time: 08:51
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO {
    private String acountNumber;
    private long timeStamp;
    private double amount;
    private String description;


    public TransactionDTO(String accountNumber, long timeStamp, double amount, String description) {
        //To change body of created methods use File | Settings | File Templates.
        this.acountNumber = accountNumber;
        this.timeStamp = timeStamp;
        this.amount = amount;
        this.description = description;
    }

    public String getAcountNumber() {
        return acountNumber;
    }

    public void setAcountNumber(String acountNumber) {
        this.acountNumber = acountNumber;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
