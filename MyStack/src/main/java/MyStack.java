import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 17/06/2013
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
public class MyStack {
    private ArrayList<String> myStack;
    public MyStack()
    {
        this.myStack = new ArrayList<String>();
    }
    public int size() {
        return this.myStack.size();
    }

    public void push(String a) {
        myStack.add(a);

    }

    public String top() {
        if(myStack.isEmpty())
        {
            return null;
        }
        return myStack.get(myStack.size()-1);
    }

    public void pop() {
        if(myStack.isEmpty())throw new RuntimeException("Empty Exception");
        myStack.remove(myStack.size()-1);

    }
}
