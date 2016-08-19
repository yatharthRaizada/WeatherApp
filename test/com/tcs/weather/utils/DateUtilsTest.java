/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Nileshwari
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
        assertNotNull(result);
    }

    /**
     * Test of getListRandomDates method, of class DateUtils.
     */
    @Test
    public void testGetListRandomDates() {
        System.out.println("getListRandomDates");
        int numberOfDates = 10;
        DateUtils instance = new DateUtils();
        ArrayList<Date> expResult = null;
        ArrayList<Date> result = instance.getListRandomDates(numberOfDates);
        assertEquals(numberOfDates, result.size());
        for (int i = 0; i < result.size(); i++) {
            assertNotNull(result.get(i));
        }

    }

    /**
     * Test of getISO8601Date method, of class DateUtils.
     */
    @Test
    public void testGetISO8601Date() {
        System.out.println("getISO8601Date");
        Date inputDate = null;
        DateUtils instance = new DateUtils();
        //String expResult = "";
        String result = instance.getISO8601Date(instance.generate());
        assertNotNull(result);

    }

}
