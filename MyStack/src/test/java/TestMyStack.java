import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 17/06/2013
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
public class TestMyStack extends TestCase {
    MyStack myStack = new MyStack();
    public void testCreateStackHasSizeIsZero()
    {

        assertEquals(0,myStack.size());
    }
    public void testPushStackOneElement()
    {
        myStack.push("a");
        assertEquals(1,myStack.size());

    }
    public void testPushOneElementToStackKElement()
    {
        myStack.push("b");
        myStack.push("c");
        myStack.push("d");
        assertEquals(3,myStack.size());
        myStack.push("e");
        assertEquals(4,myStack.size());
    }
    public void testEmptyStackReturnNull()
    {
        assertEquals(null,myStack.top());
    }
    public void testStackTopReturnElementPush()
    {
        myStack.push("a");
        assertEquals("a",myStack.top());
        myStack.push("b");
        assertEquals("b",myStack.top());
    }
    public void testStackEmptyPopThrowException()
    {
        try{
            myStack.pop();
            fail("Exception expect");

        }catch (Exception e)
        {
            assertEquals("Empty Exception",e.getMessage());
        }

    }
    public void testPopStackKElement()
    {
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        myStack.push("d");
        myStack.pop();
        assertEquals(3,myStack.size());
    }
    public void testPopStackHasOneElement()
    {
        myStack.push("a");
        myStack.pop();
        assertEquals(0,myStack.size());
    }
    public void testPopAndTopStackKElement()
    {

    }
}
