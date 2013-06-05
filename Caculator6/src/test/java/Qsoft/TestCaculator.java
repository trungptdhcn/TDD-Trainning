package Qsoft;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 05/06/2013
 * Time: 22:01
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
}
