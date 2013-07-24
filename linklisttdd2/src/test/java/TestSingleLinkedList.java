import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: trungpt
 * Date: 7/24/13
 * Time: 1:32 PM
 */
public class TestSingleLinkedList extends TestCase
{
    private List<Object> list;
    private SingleLinkedList singleLinkedList ;
    @Before
    public void setUp()
    {

        list = new ArrayList<Object>();
        list.add(new Integer(3));
        list.add(new Integer(4));
        singleLinkedList = new SingleLinkedList(list);
    }
    @Test
    public void testInitializationSingleLinkedListIsEmpty()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        assertNotNull(singleLinkedList);
    }
    @Test
    public void testInitializationSingleLinkedListFromArrayObject()
    {
        assertNotNull(singleLinkedList);
    }
    @Test
    public void testSizeSingleLinkedList()
    {
        assertEquals(2,singleLinkedList.size());
    }
    @Test
    public void testInsertAfter()
    {
        assertEquals(5, (Object) singleLinkedList.add(1,new Integer(5)));
        assertEquals(3,singleLinkedList.size());

    }
    @Test
    public void testDelete()
    {
        assertEquals(4,singleLinkedList.delete(1));
        assertEquals(1,singleLinkedList.size());
    }
    @Test
    public void testFirst()
    {
        assertEquals(3,singleLinkedList.first());
    }
    @Test
    public void testLast()
    {
        assertEquals(4,singleLinkedList.last());
    }
    @Test
    public void testBefore()
    {
        assertEquals(3,singleLinkedList.before(1));
    }
    @Test
    public void testAfter()
    {
        assertEquals(4,singleLinkedList.after(0));
    }
}
