
package com.tcs.weather.utils;

import com.tcs.weather.constants.WeatherAppConstants;
import static java.lang.Math.pow;

/**
 * This class contains method to calculate the pressure of a place
 * @author Yatharth Raizada
 */
public class PressureUtils {

    /**
     * This method is used to calculate the pressure of a place based on the elevation of the city
     * @param elevation
     * @return pressure_in_hpa
     */
    public Double getPressure(double elevation) {
        
        //calculate pressure based on a regression equation
        double factorA = (WeatherAppConstants.RATE_OF_TEMPERATURE_DECREASE_PER_METRE * elevation) / WeatherAppConstants.SEA_LEVEL_STANDARD_TEMPERATURE_IN_K;
        factorA = 1 - factorA;

        double factorB = (WeatherAppConstants.GRAVITATIONAL_ACCELERATION_IN_MS2 * WeatherAppConstants.MOLAR_MASS_DRY_AIR_KGMOL)
                / (WeatherAppConstants.UNIVERSAL_GAS_CONSTANT_IN_JMOLK * WeatherAppConstants.RATE_OF_TEMPERATURE_DECREASE_PER_METRE);
        double factorC = pow(factorA, factorB);

        double pressure = WeatherAppConstants.STANDARD_ATMOSPHERIC_PRESSURE_IN_PA * factorC;

        //return pressure in hPa
        return pressure / 100;

    }

}
