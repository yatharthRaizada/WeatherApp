package com.tcs.weather.utils;

import com.tcs.weather.beans.CityBean;
import com.tcs.weather.constants.WeatherAppConstants;
import java.util.Date;

/**
 * This class contains method to calculate the humidity of a place
 *
 * @author Yatharth Raizada
 */
public class HumidityUtils {

    /**
     *
     * @param objCityBean (Bean of city for which relative humidity has to be
     * calculated)
     * @param temperatureInCelsius (temperature calculated earlier)
     * @param localTime (time at which relative humidity has to be calculated
     * @return calculated_humidity
     */
    public Double getHumidity(CityBean objCityBean, Double temperatureInCelsius, Date localTime) {
        int month = localTime.getMonth();
        Double elevation = objCityBean.getElevation();
        //get factor for multiplication to deduce dew point based on temperature and the month

        Double factorDewPoint = getfactorDewPoint(month);
        Double dewPoint = temperatureInCelsius * factorDewPoint;

        //factor dewPoint based on elevation
        dewPoint = dewPoint + (WeatherAppConstants.RATE_OF_HUMIDITY_DECREASE_PER_METRE * elevation);

        //calculate and apply coastal dewPoint normalization
        if (objCityBean.isIsCoastal()) {
            //summer
            if (month > 3 && month < 8) {
                dewPoint = dewPoint * WeatherAppConstants.COASTAL_HUMIDITY_NORMALIZATION_FACTOR_SUMMER;
            } //winter
            else if ((month > 9 && month < 12) || month == 0 || month == 1) {
                dewPoint = dewPoint * WeatherAppConstants.COASTAL_HUMIDITY_NORMALIZATION_FACTOR_WINTER;
            }

        }

        double relativeHumidity = dewPoint / temperatureInCelsius * 100;

        if (relativeHumidity > 100.0) {
            return 100.0;
        }
        
        //return result
        return relativeHumidity;
    }

    /**
     * This method is used to return dew_point_multiplication_factor based on the month
     * @param month
     * @return dew_point_multiplication_factor
     */
    private double getfactorDewPoint(int month) {
        switch (month) {
            case 0:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_JAN;
            case 1:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_FEB;
            case 2:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_MAR;
            case 3:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_APR;
            case 4:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_MAY;
            case 5:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_JUN;
            case 6:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_JUL;
            case 7:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_AUG;
            case 8:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_SEP;
            case 9:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_OCT;
            case 10:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_NOV;
            case 11:
                return WeatherAppConstants.HUMIDITY_COEFFICIENT_FACTOR_A_IN_DEC;
            default:
                return -1;

        }
    }

}
