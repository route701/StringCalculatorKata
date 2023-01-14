package com.vince;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shoudReturnZeroOnEmptyString()
    {
        assertEquals(0, App.add(""));
    }

    @Test
    public void shouldReturnNumberOnSingleString()
    {
        assertEquals(1, App.add("1"));
    }

    @Test
    public void shouldReturnSumOnTwoStrings()
    {
        assertEquals(3, App.add("1,2"));
    }

    @Test
    public void shouldReturnSumOfAllNumbers()
    {
        assertEquals(6, App.add("1,2,3"));
    }

    @Test
    public void shouldAllowNewLineAsDelimiter()
    {
        assertEquals(6, App.add("1\n2,3"));
    }

    @Test
    public void shouldAllowCustomDelimiter()
    {
        assertEquals(3, App.add("//;\n1;2"));
    }
}
