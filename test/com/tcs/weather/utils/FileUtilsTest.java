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
 * @author Yatharth Raizada
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
        ArrayList<CityBean> result = instance.readCSVFile();
        System.out.println("Checking if list returned is null");
        assertNotNull(result);
        System.out.println("List returned is not null");
        System.out.println("Checking if size of list returned is zero");
        assertNotEquals(0, result.size());
        System.out.println("size of list returned is not zero. Checking each element now.");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Checking if city name is null");
            assertNotNull(result.get(i).getCityName());
            System.out.println("City name is not null");
            System.out.println("Checking if city elevation is null");
            assertNotNull(result.get(i).getElevation());
            System.out.println("City elevation is not null");
            System.out.println("Checking if city latitude is null");
            assertNotNull(result.get(i).getLatitude());
            System.out.println("City latitude is not null");
            System.out.println("Checking if city longitude is null");
            assertNotNull(result.get(i).getLongitude());
            System.out.println("City longitude is not null");
            System.out.println("Checking if city coastal is null or not boolean");
            assertNotNull(result.get(i).isIsCoastal());
            assertTrue((result.get(i).isIsCoastal() == false) || (result.get(i).isIsCoastal() == true));
            System.out.println("City coastal is correct");
            System.out.println("All tests passed in readCSVFile method. Exiting now.");

        }

    }

}
