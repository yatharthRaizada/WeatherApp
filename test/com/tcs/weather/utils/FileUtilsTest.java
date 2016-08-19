/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.weather.utils;

import com.tcs.weather.beans.CityBean;
import java.util.ArrayList;
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
public class FileUtilsTest {

    public FileUtilsTest() {
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
     * Test of readCSVFile method, of class FileUtils.
     */
    @Test
    public void testReadCSVFile() {
        System.out.println("readCSVFile");
        FileUtils instance = new FileUtils();
        ArrayList<CityBean> expResult = null;
        ArrayList<CityBean> result = instance.readCSVFile();
        assertNotNull(result);
        assertNotEquals(0, result.size());
        for (int i = 0; i < result.size(); i++) {
            assertNotNull(result.get(i).getCityName());
            assertNotNull(result.get(i).getElevation());
            assertNotNull(result.get(i).getLatitude());
            assertNotNull(result.get(i).getLongitude());
            assertNotNull(result.get(i).isIsCoastal());
            assertTrue((result.get(i).isIsCoastal()==false)||(result.get(i).isIsCoastal()==true));

        }

    }

}
