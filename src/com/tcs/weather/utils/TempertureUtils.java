/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.weather.utils;

import com.tcs.weather.beans.CityBean;
import com.tcs.weather.constants.WeatherAppConstants;
import java.util.Date;

/**
 *
 * @author Nileshwari
 */
public class TempertureUtils {

    public Double getTemperature(CityBean objCityBean, Date localTime) {

        Double latitude = objCityBean.getLatitude();
        Double elevation = objCityBean.getElevation();
        int month = localTime.getMonth();

        //calculate temperature based on latitude
        double coefficient = getCoefficient(month);
        double temperature = WeatherAppConstants.TEMPERATURE_COEFFICIENT_CONSTANT - (coefficient * latitude);
        temperature = getCelsiusFromFahreheit(temperature);

        //calculate temperature based on elevation
        temperature = temperature + (WeatherAppConstants.RATE_OF_TEMPERATURE_DECREASE_PER_METRE * elevation);

        //calculate and apply coastal temperature normalization
        if (objCityBean.isIsCoastal()) {
            if (month > 3 && month < 8) {
                temperature = temperature * WeatherAppConstants.COASTAL_NORMALIZATION_FACTOR_SUMMER;
            } else if ((month > 9 && month < 12) || month == 0 || month == 1) {
                temperature = temperature * WeatherAppConstants.COASTAL_NORMALIZATION_FACTOR_WINTER;
            }

        }

        return temperature;
    }

    private double getCoefficient(int month) {
        switch (month) {
            case 0:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_JAN;
            case 1:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_FEB;
            case 2:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_MAR;
            case 3:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_APR;
            case 4:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_MAY;
            case 5:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_JUN;
            case 6:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_JUL;
            case 7:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_AUG;
            case 8:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_SEP;
            case 9:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_OCT;
            case 10:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_NOV;
            case 11:
                return WeatherAppConstants.TEMPERATURE_COEFFICIENT_IN_DEC;
            default:
                return -1;
        }

    }

    private double getCelsiusFromFahreheit(double tempLatitudeF) {
        return ((tempLatitudeF - 32) * 5) / 9;
    }
}
