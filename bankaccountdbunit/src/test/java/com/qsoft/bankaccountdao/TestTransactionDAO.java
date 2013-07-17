package com.qsoft.bankaccountdao;

import com.qsoft.bankaccountdao.persistence.dao.TransactionDAO;
import com.qsoft.bankaccountdao.persistence.model.TransactionEntity;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 07/07/2013
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class TestTransactionDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TransactionDAO transactionDAO;
    @Autowired
    private DataSource dataSourceTest;
    private IDatabaseTester databaseTester;

    @Before
    public void setUp() throws Exception
    {
        IDataSet dataSet = readDataset();
        cleanlyInsert(dataSet);

    }

    private IDataSet readDataset() throws Exception
    {
        return new FlatXmlDataSetBuilder().build(System.class.getResource("/dataset.xml"));
    }

    private void cleanlyInsert(IDataSet iDataSet) throws Exception
    {
        databaseTester = new DataSourceDatabaseTester(dataSourceTest);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(iDataSet);
        databaseTester.onSetup();
    }

    @After
    public void tearDown() throws Exception
    {
        databaseTester.onTearDown();
    }

    @Test
    public void testFindTransactionInDatabase()
    {
        List<TransactionEntity> transactionEntityList = new ArrayList<TransactionEntity>();
        TransactionEntity transactionEntity = new TransactionEntity(1000L, "0123456789", "deposit", 100);
        transactionEntityList.add(transactionEntity);
        List<TransactionEntity> testTransactionEntitylist = transactionDAO.find("0123456789");
        Assert.assertEquals(testTransactionEntitylist.size(), transactionEntityList.size());
        Assert.assertEquals(testTransactionEntitylist.get(0).getAmount(), transactionEntityList.get(0).getAmount());
    }

    @Test
    public void testSaveTransaction()
    {
        TransactionEntity transactionEntity = new TransactionEntity(1000L, "0123456789", "deposit", 100);
        transactionDAO.save(transactionEntity);
        TransactionEntity transactionEntity1 = transactionDAO.find(transactionEntity);
    }

    @Test
    public void testGetTransactionOnTime()
    {
        List<TransactionEntity> transactionEntityList = new ArrayList<TransactionEntity>();
        transactionEntityList = transactionDAO.findOneTime("0123456789",1000L,1200L);
        Assert.assertEquals(2,transactionEntityList.size());
    }

}
