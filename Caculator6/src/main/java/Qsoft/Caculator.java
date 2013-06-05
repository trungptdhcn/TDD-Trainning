package Qsoft;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 05/06/2013
 * Time: 22:02
 * To change this template use File | Settings | File Templates.
 */
public class Caculator {
    public static int add(String s)
    {
        int sum = 0;
       if(s.length() == 0)
       {
            sum = 0;
       }
        else
       {
           ArrayList<Integer> mNumbers = new ArrayList<Integer>();
           for(String x: s.split(","))
           {
                mNumbers.add(Integer.parseInt(x));

           }
           for(Integer x: mNumbers)
           {
               sum = sum +x;
           }
       }
        return sum;

    }

}
