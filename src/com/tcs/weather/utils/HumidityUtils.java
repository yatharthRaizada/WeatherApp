/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.weather.utils;

import com.tcs.weather.beans.CityBean;
import com.tcs.weather.constants.WeatherAppConstants;
import static java.lang.Math.exp;
import java.util.Date;

/**
 *
 * @author Yatharth Raizada
 */
public class HumidityUtils {

    public Double getHumidity(CityBean objCityBean, Double temperatureInCelsius, Date localTime) {
        int month = localTime.getMonth();
        Double factorDewPoint = getfactorDewPoint(month);
        Double dewPoint = temperatureInCelsius * factorDewPoint;
        Double elevation = objCityBean.getElevation();

        //calculate dewPoint based on elevation
        dewPoint = dewPoint + (WeatherAppConstants.RATE_OF_HUMIDITY_DECREASE_PER_METRE * elevation);

        //calculate and apply coastal dewPoint normalization
        if (objCityBean.isIsCoastal()) {
            if (month > 3 && month < 8) {
                dewPoint = dewPoint * WeatherAppConstants.COASTAL_HUMIDITY_NORMALIZATION_FACTOR_SUMMER;
            } else if ((month > 9 && month < 12) || month == 0 || month == 1) {
                dewPoint = dewPoint * WeatherAppConstants.COASTAL_HUMIDITY_NORMALIZATION_FACTOR_WINTER;
            }

        }

        double relativeHumidity = dewPoint / temperatureInCelsius * 100;

        if (relativeHumidity > 100.0) {
            return 100.0;
        }
        return relativeHumidity;
    }

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
