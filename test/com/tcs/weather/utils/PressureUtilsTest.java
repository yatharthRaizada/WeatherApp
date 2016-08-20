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
 * @author Yatharth Raizada
 */
public class PressureUtilsTest {

    public PressureUtilsTest() {
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
     * Test of getPressure method, of class PressureUtils.
     */
    @Test
    public void testGetPressure() {
        System.out.println("getPressure");
        //declarations and initializations
        ArrayList<CityBean> listCityBean = new ArrayList<CityBean>();
        ArrayList<Date> listRandomDate = new ArrayList<Date>();

        PressureUtils objPressureUtils = new PressureUtils();

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
                //getPressure
                objCityWeatherBean.setPressureInHPA(objPressureUtils.getPressure(listCityBean.get(i).getElevation()));

                listCityWeatherBean.add(objCityWeatherBean);
            }

        } else {
            System.out.println("Error occurred in parsing csv file. Exiting.");
        }

        //test the results
        if (listCityWeatherBean.size() > 0) {
            for (int i = 0; i < listCityWeatherBean.size(); i++) {
                objCityWeatherBean = listCityWeatherBean.get(i);
                System.out.println("City: " + objCityWeatherBean.getObjCityBean().getCityName() + ", Pressure: " + objCityWeatherBean.getPressureInHPA());
                System.out.println("Checking if pressure returned is null");
                assertNotNull(objCityWeatherBean.getPressureInHPA());
                System.out.println("Pressure returned is not null");
                System.out.println("Checking if pressure returned is less than equal to zero");
                assertFalse(objCityWeatherBean.getPressureInHPA() <= 0);
                System.out.println("Pressure returned is not less than equal to zero");
                System.out.println("All tests passed in getPressure method. Exiting now.");
            }

        } else {
            System.out.println("Error occurred in parsing csv file. Exiting.");
        }

    }

}
