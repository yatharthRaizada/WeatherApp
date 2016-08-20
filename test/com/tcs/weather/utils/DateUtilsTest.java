package com.tcs.weather.utils;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yatharth Raizada
 */
public class DateUtilsTest {

    public DateUtilsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of generate method, of class DateUtils.
     */
    @Test
    public void testGenerate() {
        System.out.println("generate");
        DateUtils instance = new DateUtils();
        Date result = instance.generate();
        System.out.println("Checking if result is null.");
        assertNotNull(result);
        System.out.println("Result is not null.");
        System.out.println("All tests passed in generate method. Exiting now.");
    }

    /**
     * Test of getListRandomDates method, of class DateUtils.
     */
    @Test
    public void testGetListRandomDates() {
        System.out.println("getListRandomDates");
        int numberOfDates = 10;
        DateUtils instance = new DateUtils();
        ArrayList<Date> result = instance.getListRandomDates(numberOfDates);
        System.out.println("Checking if size of list is same as numberOfDates");
        assertEquals(numberOfDates, result.size());
        System.out.println("Size of list is same as numberOfDates");
        System.out.println("Checking if each of the element is not null");
        
        for (int i = 0; i < result.size(); i++) {
            assertNotNull(result.get(i));
        }
        System.out.println("Each of the element is not null");
        
        System.out.println("All tests passed in getListRandomDates method. Exiting now.");

    }

    /**
     * Test of getISO8601Date method, of class DateUtils.
     */
    @Test
    public void testGetISO8601Date() {
        System.out.println("getISO8601Date");
        
        DateUtils instance = new DateUtils();
        String result = instance.getISO8601Date(instance.generate());
        System.out.println("Checking if result is null");
        assertNotNull(result);
        System.out.println("Result is not null");
        System.out.println("All tests passed in getISO8601Date method. Exiting now.");

    }

}
