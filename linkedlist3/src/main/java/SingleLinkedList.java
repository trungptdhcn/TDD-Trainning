import java.util.List;

/**
 * User: trungpt
 * Date: 7/29/13
 * Time: 1:46 PM
 */
public class SingleLinkedList
{
    private List<Object> list;
    public SingleLinkedList()
    {

    }
    public SingleLinkedList(List<Object> list)
    {
        this.list = list;
    }

    public int size()
    {
        return this.list.size();
    }

    public Object insertAfter(int n, Object o)
    {
        this.list.add(n,o);
        return this.list.get(n);
    }

    public Object delete(int n)
    {
        return this.list.remove(n);
    }

    public Object first()
    {
        return this.list.get(0);
    }

    public Object last()
    {
        return this.list.get(this.list.size()-1);
    }

    public Object before(int n)
    {
        return this.list.get(n-1);
    }
}
