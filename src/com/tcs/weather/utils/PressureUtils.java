/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.weather.utils;

import com.tcs.weather.constants.WeatherAppConstants;
import static java.lang.Math.pow;

/**
 *
 * @author Yatharth Raizada
 */
public class PressureUtils {

    public Double getPressure(double elevation) {
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
