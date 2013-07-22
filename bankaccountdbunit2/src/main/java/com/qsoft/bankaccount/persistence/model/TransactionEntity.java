package com.qsoft.bankaccount.persistence.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/07/2013
 * Time: 22:43
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "transaction")
@SequenceGenerator(name = "transaction_id_sq", sequenceName = "transaction_id_sq", initialValue = 1, allocationSize = 1)
public class TransactionEntity
{
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transaction_id_sq")
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "timestamp")
    private Long timeStamp;
    @Column(name = "numberaccount")
    private String accountNumber;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private Double amount;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Long getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }
}
