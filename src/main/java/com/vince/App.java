package com.vince;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Calculator!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "String Calculator!" );
        System.out.println(App.add("//[|||][%%%]\n1|||2%%%3"));   //output: 6
    }

    public static int add(String numbers)
    {
        if ("".equals(numbers)) return 0;

        String[] nums = splitString(numbers);
        int sum = 0;
        ArrayList<String> negatives = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            int curNum = toInt(nums[i]);
            if (curNum < 0) {
                negatives.add(nums[i]);
            } else if (curNum < 1001) {
                sum += curNum;
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
            Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(num);
            m.matches();
            String customDelim = m.group(1), customNum = m.group(2);

            if (customDelim.indexOf("[") == 0 && customDelim.endsWith("]")) {
                Matcher m2 = Pattern.compile("\\[(.*?)\\]").matcher(customDelim);
                while (m2.find()) {
                    for (int i = 0; i <= m2.groupCount(); i++) {
                        String curDelim = m2.group(i);
                        customNum = customNum.replaceAll(Pattern.quote(curDelim), ",");
                    }
                }

                return defaultSpliter(customNum);
            }
            
            return customNum.split(Pattern.quote(customDelim));
        }

        return defaultSpliter(num);
    }

    private static String[] defaultSpliter(String num)
    {
        return num.split(",|\n");
    }
}
