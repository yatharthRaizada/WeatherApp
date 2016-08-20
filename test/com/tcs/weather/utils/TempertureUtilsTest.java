/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.weather.utils;

import com.tcs.weather.beans.CityBean;
import com.tcs.weather.beans.CityWeatherBean;
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
public class TempertureUtilsTest {

    public TempertureUtilsTest() {
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
     * Test of getTemperature method, of class TempertureUtils.
     */
    @Test
    public void testGetTemperature() {
        System.out.println("getTemperature");

        //declarations and initializations
        ArrayList<CityBean> listCityBean = new ArrayList<CityBean>();
        ArrayList<Date> listRandomDate = new ArrayList<Date>();

        TempertureUtils objTemperatureUtils = new TempertureUtils();

        DateUtils objDateUtils = new DateUtils();
        CityWeatherBean objCityWeatherBean = null;
        ArrayList<CityWeatherBean> listCityWeatherBean = new ArrayList<CityWeatherBean>();
        FileUtils objFileUtils = new FileUtils();

        //call method to load city information into the list of bean of City class
        listCityBean = objFileUtils.readCSVFile();

        //call method to get random dates for each city
        listRandomDate = objDateUtils.getListRandomDates(listCityBean.size());

        //call methods to calculate all the information for a city and load it into Weathe Class bean
        if (listCityBean.size() > 0) {
            for (int i = 0; i < listCityBean.size(); i++) {
                objCityWeatherBean = new CityWeatherBean();
                objCityWeatherBean.setObjCityBean(listCityBean.get(i));
                //get random local time
                objCityWeatherBean.setLocalTime(listRandomDate.get(i));
                //get temperature
                objCityWeatherBean.setTemperatureInCelsius(objTemperatureUtils.getTemperature(listCityBean.get(i), objCityWeatherBean.getLocalTime()));

                listCityWeatherBean.add(objCityWeatherBean);
            }

        } else {
            System.out.println("Error occurred in parsing csv file. Exiting.");
        }

        //test the results
        if (listCityWeatherBean.size() > 0) {
            for (int i = 0; i < listCityWeatherBean.size(); i++) {
                objCityWeatherBean = listCityWeatherBean.get(i);
                System.out.println("City: " + objCityWeatherBean.getObjCityBean().getCityName() + ", Temperature: " + objCityWeatherBean.getTemperatureInCelsius());
                System.out.println("Checking if temperature returned is null");
                assertNotNull(objCityWeatherBean.getTemperatureInCelsius());
                System.out.println("Temperature returned is not null");
                System.out.println("Checking if temperature returned is unrealistic");
                assertFalse(objCityWeatherBean.getTemperatureInCelsius()<= -20);
                assertFalse(objCityWeatherBean.getTemperatureInCelsius()> 60);
                System.out.println("Temperature returned is realistic");
                System.out.println("All tests passed in getTemperature method. Exiting now.");
            }

        } else {
            System.out.println("Error occurred in parsing csv file. Exiting.");
        }

    }

}
