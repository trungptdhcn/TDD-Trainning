package Qsoft;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 06/06/2013
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
public class TestCaculator extends TestCase {
    public void testStringEmpty()
    {
        assertEquals(0,Caculator.add(""));
    }
    public void testStringHasOneNumber()
    {
        assertEquals(1,Caculator.add("1"));
        assertEquals(22,Caculator.add("22"));
    }
    public void testStringHasTwoNumber()
    {
        assertEquals(3,Caculator.add("1,2"));
    }
    public void testStringUnknownNumber()
    {
        assertEquals(4,Caculator.add("1,2,1"));
    }
    public void testStringHasNewLinebetweenNumbers()
    {
        assertEquals(6,Caculator.add("1\n2,3"));
    }
    public void testStringHasDifferenceDelimiter()
    {
        assertEquals(6,Caculator.add("//8\n18283"));
    }
    public void testStringNegative()
    {
        try
        {
            Caculator.add("1,2,-1,-4");
            fail("Exception expect");
        }catch (Exception e)
        {
            assertEquals("negatives not allowed -1 -4",e.getMessage());
            //OK
        }
    }
    public void testStringHasBigNumbers()
    {
        assertEquals(2,Caculator.add("2,1000"));
        //OK
    }
    public void testStringHasUnknownDelimiterLenght()
    {
        assertEquals(3,Caculator.add("//[**2*]\n1**2*2**2*3000"));
        //OK
    }
    public void testStringHasDelimiterSigleDifference()
    {
        assertEquals(6,Caculator.add("//[*][%]\n1*2%3"));
        //OK
    }
    public void testStringHasMultipleDelimiterLongerOne()
    {
        assertEquals(10,Caculator.add("//[**%][()&]\n1**%2()&4()&3"));
        //OK
    }
}
