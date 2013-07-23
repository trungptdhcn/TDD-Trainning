import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: trungpt
 * Date: 7/23/13
 * Time: 1:37 PM
 */
public class TestSingleLinkedList extends TestCase
{

    @Test
    public void testInitializationLinkListEmpty()
    {
        SingleLinkedList linkList= new SingleLinkedList();
        assertEquals(null,linkList.getLinkList());
    }
    @Test
    public void testInitializationLinkListFromArrayObject()
    {
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(2);
        integerList.add(3);
        SingleLinkedList linkedList = new SingleLinkedList(integerList);
    }
    @Test
    public void testGetSizeLinkList()
    {
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(2);
        integerList.add(3);
        SingleLinkedList linkedList = new SingleLinkedList(integerList);
        assertEquals(2,linkedList.size());
    }
    @Test
    public void testInsertAfter()
    {
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(2);
        integerList.add(3);
        SingleLinkedList linkedList = new SingleLinkedList(integerList);
        linkedList.insertAfter(2,5);
        assertEquals((Object) 5,linkedList.getLinkList().get(2));
    }
    @Test
    public void testDelete()
    {
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(2);
        integerList.add(3);
        SingleLinkedList linkedList = new SingleLinkedList(integerList);
        assertEquals((Object) 3,linkedList.delete(1));
        assertEquals(1,linkedList.size());

    }
    @Test
    public void testGetFirst()
    {
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(2);
        integerList.add(3);
        SingleLinkedList linkedList = new SingleLinkedList(integerList);
        assertEquals(2,linkedList.first());
    }
    @Test
    public void testGetLast()
    {
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(2);
        integerList.add(3);
        SingleLinkedList linkedList = new SingleLinkedList(integerList);
        assertEquals(3,linkedList.last());
    }
}
