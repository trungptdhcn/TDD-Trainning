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
           sum = Caculator.getSumNumber(s);
       }
        return sum;

    }
    public static int getSumNumber(String s)
    {
        int sum = 0;
        ArrayList<Integer> mNumber = new ArrayList<Integer>();
        for(String x: s.split("[, - \n]"))
        {
            mNumber.add(Integer.parseInt(x));
        }
        for(Integer x : mNumber)
        {
            if(x<0) throw new RuntimeException("negatives not allowed "+ x);
            else if(x >=1000) x = 0;
            sum = sum + x;
        }
        return sum;
    }

}
