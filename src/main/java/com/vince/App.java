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
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += toInt(nums[i]);    
            }
            return sum;
        }

        return toInt(numbers);
    }

    private static int toInt(String num)
    {
        return Integer.parseInt(num);
    }
}
