package com.vince;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static int add(String numbers)
    {
        if ("".equals(numbers)) return 0;

        String[] nums = splitString(numbers);
        int sum = 0;
        ArrayList<String> negatives = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            if (toInt(nums[i]) < 0) {
                negatives.add(nums[i]);
            } else {
                sum += toInt(nums[i]);
            }
        }

        if (negatives.size() > 0) 
            throw new RuntimeException("Negatives not allowed: " + String.join(",", negatives));

        return sum;
    }

    private static int toInt(String num)
    {
        return Integer.parseInt(num);
    }

    private static String[] splitString(String num)
    {
        if (num.startsWith("//")) {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(num);
            m.matches();
            String customDelim = m.group(1), customNum = m.group(2);
            return customNum.split(Pattern.quote(customDelim));
        }

        return num.split(",|\n");
    }
}
