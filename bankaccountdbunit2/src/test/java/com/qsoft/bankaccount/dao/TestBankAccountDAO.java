package com.qsoft.bankaccount.dao;

import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
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

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 21/07/2013
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class TestBankAccountDAO {
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
    public void testGetAccount()
    {
        BankAccountEntity bankaccount = bankAccountDAO.find("0123456789");
        Assert.assertEquals(100.0,bankaccount.getBalance());
        Assert.assertEquals((Object) 1,bankaccount.getId());
    }
    @Test
    public void testSaveAccount()
    {
        BankAccountEntity bankAccountEntity = new BankAccountEntity("111111");
        bankAccountDAO.save(bankAccountEntity);
        BankAccountEntity entitytest = bankAccountDAO.find("111111");
        Assert.assertEquals(entitytest.getBalance(),bankAccountEntity.getBalance());
    }

}
