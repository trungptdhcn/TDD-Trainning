import java.util.List;

/**
 * User: trungpt
 * Date: 7/24/13
 * Time: 1:31 PM
 */
public class SingleLinkedList
{
    private List<Object> list;
    public SingleLinkedList()
    {
        this.list = null;
    }

    public SingleLinkedList(List<Object> list)
    {
        this.list = list;
    }

    public int size()
    {
        return this.list.size();
    }

    public Integer add(int i, Integer integer)
    {
        this.list.add(i,integer);
        return (Integer) this.list.get(i);

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

    public Object after(int n)
    {
        return this.list.get(n+1);
    }
}
