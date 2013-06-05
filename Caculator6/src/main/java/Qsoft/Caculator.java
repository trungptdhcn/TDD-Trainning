package Qsoft;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
           if(!Caculator.isHasDelimiter(s)){
               sum = Caculator.getSumNumber(s);
           }else {
               String Delimiter = Caculator.getDelimiter(s);
               String mNumbers = s.substring(s.lastIndexOf("\n")+1,s.length());
               mNumbers = mNumbers.replace(Delimiter,",");
               sum = Caculator.getSumNumber(mNumbers);
           }

       }
        return sum;

    }
    public static int getSumNumber(String s)
    {
        int sum = 0;
        String a = "";
        ArrayList<Integer> mNumber = new ArrayList<Integer>();
        for(String x: s.split("[, - \n]"))
        {
            mNumber.add(Integer.parseInt(x));
        }
        for(Integer x : mNumber)
        {
           if(x < 0)
           {
               throw new RuntimeException("negatives not allowed"+ Caculator.ischeckNegative(mNumber));
           }
           else if(x >=1000) x = 0;
           sum = sum + x;
        }
        return sum;
    }
    public static boolean isHasDelimiter(String s)
    {
        Pattern pattern = Pattern.compile("(//)(.*)(\n)(.*)");
        if(pattern.matcher(s).find())
            return true;
        return false;
    }
    public static String getDelimiter(String s)
    {
        Pattern pattern = Pattern.compile("(//)(.*)(\n)");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find())
        {
            String Delimiter = matcher.group(0);
            Delimiter = Delimiter.substring(Delimiter.indexOf("//")+2,Delimiter.lastIndexOf("\n"));
            return Delimiter;
        }
        return "";
    }
    public static String ischeckNegative(ArrayList<Integer> numbers)
    {
        String a="";
        for(Integer x: numbers)
        {
            if(x<0)
            {
                a = a+" "+x;
            }
        }
        return a;
    }

}
