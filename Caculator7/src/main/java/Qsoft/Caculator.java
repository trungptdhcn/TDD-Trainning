package Qsoft;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            if(!Caculator.isHasDelimiter(s))
            {
                sum = Caculator.getSumNumber(s);
            }else
            {
                String Delimiter = Caculator.getDelimiter(s);
                String mNumber = s.substring(s.lastIndexOf("\n")+1,s.length());
                if(!Caculator.isDelimiterHasBrakets(Delimiter))
                {
                    mNumber = mNumber.replace(Delimiter,",");
                    sum = Caculator.getSumNumber(mNumber);
                }else
                {
                    Delimiter = Delimiter.substring(Delimiter.indexOf("[")+1,Delimiter.lastIndexOf("]"));
                    ArrayList<String> mMultipleDelimiter = new ArrayList<String>();
                    mMultipleDelimiter = Caculator.getMultipleDelimiter(Delimiter);
                    for(String x: mMultipleDelimiter)
                    {
                        mNumber = mNumber.replaceAll(Pattern.quote(x),",");
                    }
                    mNumber = mNumber.replace(Delimiter,",");
                    sum = Caculator.getSumNumber(mNumber);
                }

            }
        }
        return sum;
    }
    public static int getSumNumber(String s)
    {
        ArrayList<Integer> mNumber = new ArrayList<Integer>();
        int sum = 0;
        for(String x : s.split("[, - \n]"))
        {
            mNumber.add(Integer.parseInt(x));
        }
        for(Integer x: mNumber)
        {
            if(x < 0)
            {
                throw new RuntimeException("negatives not allowed"+ Caculator.ischeckNegative(mNumber));
            }
            else if(x >=1000) x = 0;
            sum = sum +x ;
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
    public static boolean isDelimiterHasBrakets(String Delimiter)
    {
        Pattern pattern = Pattern.compile("(\\[)(.*)(\\])");
        if(pattern.matcher(Delimiter).find())
            return true;
        return false;
    }
    public static ArrayList<String> getMultipleDelimiter(String Delimiter)
    {
        ArrayList<String> mDelimiters = new ArrayList<String>();
        for(String x: Delimiter.split("(\\])(\\[)"))
        {
            mDelimiters.add(x);
        }
        return mDelimiters;
    }
}
