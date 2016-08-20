
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
public class HumidityUtilsTest {

    public HumidityUtilsTest() {
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
     * Test of getHumidity method, of class HumidityUtils.
     */
    @Test
    public void testGetHumidity() {
        System.out.println("getHumidity");

        //declarations and initializations
        ArrayList<CityBean> listCityBean = new ArrayList<CityBean>();
        ArrayList<Date> listRandomDate = new ArrayList<Date>();
        TempertureUtils objTemperatureUtils = new TempertureUtils();
        PressureUtils objPressureUtils = new PressureUtils();
        HumidityUtils objHumidityUtils = new HumidityUtils();
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
                //get humidity
                objCityWeatherBean.setRelativeHumidityInPercentage(objHumidityUtils.getHumidity(listCityBean.get(i), objCityWeatherBean.getTemperatureInCelsius(), objCityWeatherBean.getLocalTime()));

                listCityWeatherBean.add(objCityWeatherBean);
            }

        } else {
            System.out.println("Error occurred in parsing csv file. Exiting.");
        }

        //test the results
        if (listCityWeatherBean.size() > 0) {
            for (int i = 0; i < listCityWeatherBean.size(); i++) {
                objCityWeatherBean = listCityWeatherBean.get(i);
                System.out.println("City: " + objCityWeatherBean.getObjCityBean().getCityName() + ", Humidty: " + objCityWeatherBean.getRelativeHumidityInPercentage());
                System.out.println("Checking if relative humidity returned is null");
                assertNotNull(objCityWeatherBean.getRelativeHumidityInPercentage());
                System.out.println("Relative humidity returned is not null");
                System.out.println("Checking if relative humidity returned is less than equal to zero");
                assertFalse(objCityWeatherBean.getRelativeHumidityInPercentage() <= 0);
                System.out.println("Relative humidity returned is not less than equal to zero");
                System.out.println("Checking if relative humidity returned is greater than hundred");
                assertFalse(objCityWeatherBean.getRelativeHumidityInPercentage() > 100);
                System.out.println("Relative humidity returned is not greater than hundred");
                System.out.println("All tests passed in getHumidity method. Exiting now.");
            }

        } else {
            System.out.println("Error occurred in parsing csv file. Exiting.");
        }

    }

}
