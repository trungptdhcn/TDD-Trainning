package com.qsoft.bankaccountdao;

import com.qsoft.bankaccountdao.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccountdao.persistence.model.BankAccountEntity;
import junit.framework.Assert;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import static junit.framework.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 04/07/2013
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class TestBankAccountDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BankAccountDAO bankAccountDAO;

    @Autowired
    private DataSource dataSourceTest;

    private IDatabaseTester databaseTester;
    @Before
    public void setup() throws Exception
    {
        IDataSet dataSet = readDataSet();  // read data from xml file
        cleanlyInsert(dataSet);  // empty the db and insert data
    }
    private IDataSet readDataSet() throws Exception
    {
        return new FlatXmlDataSetBuilder().build(System.class.getResource("/dataset.xml"));
    }
    private void cleanlyInsert(IDataSet dataSet) throws Exception
    {
        databaseTester = new DataSourceDatabaseTester(dataSourceTest);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }
    @After
    public void tearDown() throws Exception
    {
        databaseTester.onTearDown();
    }
    @Test
    public void testGetAccount()throws Exception
    {
        BankAccountEntity bankAccountEntity = bankAccountDAO.find("0123456789");
        Assert.assertEquals("0123456789", bankAccountEntity.getAccountNumber());
        Assert.assertEquals(100.0, bankAccountEntity.getBalance());
    }
    @Test
    public void testGetAccountNull()
    {
        BankAccountEntity bankAccountEntity = bankAccountDAO.find("02145645");
        Assert.assertEquals(bankAccountEntity,null);
    }
    @Test
    public void testSaveAccountNotEmptyinDatabases() throws Exception
    {
        BankAccountEntity bankAccountsave = new BankAccountEntity("09020546");
        bankAccountDAO.save(bankAccountsave);

        BankAccountEntity testBankAccount = bankAccountDAO.find("09020546");
        Assert.assertEquals(testBankAccount,bankAccountsave);
    }
    @Test
    public void testSaveAccountExistsDatabases() throws Exception
    {
        BankAccountEntity bankAccountEntity = bankAccountDAO.find("0123456789");
        bankAccountEntity.setBalance(1000);
        bankAccountDAO.save(bankAccountEntity);
        BankAccountEntity bankAccountEntity1test = bankAccountDAO.find("0123456789");

        Assert.assertEquals(1000.0,bankAccountEntity1test.getBalance());

    }
    @Test
    public void testSaveAccountWithNegativeBalance() throws Exception
    {
        BankAccountEntity bankAccountEntity = bankAccountDAO.find("0123456789");
        bankAccountEntity.setBalance(-100);
        try{
        bankAccountDAO.save(bankAccountEntity);
        fail();
        }catch(Exception e)
        {
            Assert.assertEquals("a",e.getMessage());
        }
    }
}
