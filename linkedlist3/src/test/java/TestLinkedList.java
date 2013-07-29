import junit.framework.TestCase;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * User: trungpt
 * Date: 7/29/13
 * Time: 1:46 PM
 */
public class TestLinkedList extends TestCase
{
    private  List<Object> list;
    @Before
    public void setUp()
    {
        list = new ArrayList<Object>();
        list.add(new Integer(1));
        list.add(new Integer(2));
    }
    public void testSingleLinkedListEmpty()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        assertNotNull(singleLinkedList);
    }
    public void testSingleLinkedListFromArrayObject()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList(list);
        assertNotNull(singleLinkedList);
    }
    public void testGetSize()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList(list);
        assertEquals(2,singleLinkedList.size());
    }
    public void testInsertAfter()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList(list);
        assertEquals(3,singleLinkedList.insertAfter(1,3));
        assertEquals(3,singleLinkedList.size());
    }
    public void testDelete()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList(list);
        assertEquals(2,singleLinkedList.delete(1));
        assertEquals(1,singleLinkedList.size());
    }
    public void testFirst()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList(list);
        assertEquals(1,singleLinkedList.first());
    }
    public void testLast()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList(list);
        assertEquals(2,singleLinkedList.last());
    }
    public void testBefore()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList(list);
        assertEquals(1,singleLinkedList.before(1));
    }
}
