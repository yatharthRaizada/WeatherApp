/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.weather.utils;

import com.tcs.weather.constants.WeatherAppConstants;

/**
 *
 * @author Yatharth Raizada
 */
public class WeatherConditionUtils {

    public String getWeatherCondition(Double temperatureInCelsius, Double relativeHumidityInPercentage) {
        if(temperatureInCelsius<WeatherAppConstants.CONDITION_TEMPERATURE_BASELINE)
        {
            return "Snow";
        }
        else
        {
            if(relativeHumidityInPercentage>WeatherAppConstants.CONDITION_HUMIDITY_BASELINE)
            {
                return "Rain";
            }
            else
            {
                return "Sunny";
            }
        }

    }
    
}
