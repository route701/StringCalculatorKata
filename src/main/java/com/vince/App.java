package com.vince;

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

        if (numbers.contains(",")) {
            String[] nums = numbers.split(",");
            return toInt(nums[0]) + toInt(nums[1]);
        }

        return toInt(numbers);
    }

    private static int toInt(String num)
    {
        return Integer.parseInt(num);
    }
}
