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
        
        return Integer.parseInt(numbers);
    }
}
