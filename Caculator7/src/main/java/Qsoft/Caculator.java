package Qsoft;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Trung
 * Date: 06/06/2013
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
public class Caculator {
    public static int add(String s)
    {
        int sum = 0;
        if(s.length() == 0)
        {
             sum = 0;
        }else{
            sum = Caculator.getSumNumber(s);

        }
        return sum;
    }
    public static int getSumNumber(String s)
    {
        ArrayList<Integer> mNumber = new ArrayList<Integer>();
        int sum = 0;
        for(String x : s.split(","))
        {
            mNumber.add(Integer.parseInt(x));
        }
        for(Integer x: mNumber)
        {
            sum = sum +x ;
        }
        return sum;
    }
}
