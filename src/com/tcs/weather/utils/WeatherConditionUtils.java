
package com.tcs.weather.utils;

import com.tcs.weather.constants.WeatherAppConstants;

/**
 *This class contains method to determine the weather condition of a place
 * @author Yatharth Raizada
 */
public class WeatherConditionUtils {

    /**
     * This method is used to determine weather condition of a place based on temperature and humidity
     * @param temperatureInCelsius
     * @param relativeHumidityInPercentage
     * @return string_weather_condition
     */
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
