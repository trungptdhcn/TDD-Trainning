import java.util.List;

/**
 * User: trungpt
 * Date: 7/23/13
 * Time: 1:35 PM
 */
public class SingleLinkedList
{
    private List<Integer> linkList;

    public SingleLinkedList()
    {
        linkList = null;
    }
    public SingleLinkedList(List<Integer> linkList)
    {
        this.linkList = linkList;
    }

    public List<Integer> getLinkList()
    {
        return linkList;
    }

    public void setLinkList(List<Integer> linkList)
    {
        this.linkList = linkList;
    }

    public int size()
    {
        return this.linkList.size();
    }

    public void insertAfter(int n, Integer integer)
    {
        this.linkList.add(n,integer);
    }

    public Integer delete(int n)
    {

        return this.linkList.remove(n);
    }

    public int first()
    {
        return this.linkList.get(0);
    }

    public int last()
    {
        return this.linkList.get(linkList.size()-1);
    }
}
