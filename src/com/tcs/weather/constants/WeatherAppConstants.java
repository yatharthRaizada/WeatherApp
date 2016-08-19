package com.tcs.weather.constants;

/**
 * This class contains all the constants required for this project
 * @author Yatharth Raizada
 */
public class WeatherAppConstants {

    //output delimiters
    public static final String OUTPUT_DELIMITER = "|";
    public static final String POSITION_DELIMITER = ",";

    //constants for calculating temperature
    public static final double RATE_OF_TEMPERATURE_DECREASE_PER_METRE = -0.0065;
    public static final double TEMPERATURE_COEFFICIENT_IN_JAN = 2.11;
    public static final double TEMPERATURE_COEFFICIENT_IN_FEB = 1.98;
    public static final double TEMPERATURE_COEFFICIENT_IN_MAR = 1.76;
    public static final double TEMPERATURE_COEFFICIENT_IN_APR = 1.53;
    public static final double TEMPERATURE_COEFFICIENT_IN_MAY = 1.11;
    public static final double TEMPERATURE_COEFFICIENT_IN_JUN = 0.99;
    public static final double TEMPERATURE_COEFFICIENT_IN_JUL = 1.27;
    public static final double TEMPERATURE_COEFFICIENT_IN_AUG = 1.63;
    public static final double TEMPERATURE_COEFFICIENT_IN_SEP = 1.40;
    public static final double TEMPERATURE_COEFFICIENT_IN_OCT = 1.72;
    public static final double TEMPERATURE_COEFFICIENT_IN_NOV = 1.89;
    public static final double TEMPERATURE_COEFFICIENT_IN_DEC = 2.11;

    public static final double TEMPERATURE_COEFFICIENT_CONSTANT = 109;
    
    public static final double COASTAL_NORMALIZATION_FACTOR_SUMMER = 0.93;
    public static final double COASTAL_NORMALIZATION_FACTOR_WINTER = 1.08;

    //constants for calculating pressure
    public static final double STANDARD_ATMOSPHERIC_PRESSURE_IN_PA = 101325;
    public static final double SEA_LEVEL_STANDARD_TEMPERATURE_IN_K = 288.15;
    public static final double GRAVITATIONAL_ACCELERATION_IN_MS2 = 9.8;
    public static final double UNIVERSAL_GAS_CONSTANT_IN_JMOLK = 8.31;
    public static final double MOLAR_MASS_DRY_AIR_KGMOL = .0289;

    //constants for calculating humidity
    public static final double HUMIDITY_COEFFICIENT_MULTIPLIER = 2.3;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_JAN = 0.63;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_FEB = 0.72;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_MAR = 0.73;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_APR = 0.76;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_MAY = 0.80;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_JUN = 0.97;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_JUL = 0.95;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_AUG = 0.89;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_SEP = 0.80;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_OCT = 0.61;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_NOV = 0.52;
    public static final double HUMIDITY_COEFFICIENT_FACTOR_A_IN_DEC = 0.61;

    public static final double RATE_OF_HUMIDITY_DECREASE_PER_METRE = -.00065;
    public static final double COASTAL_HUMIDITY_NORMALIZATION_FACTOR_SUMMER = 1.15;
    public static final double COASTAL_HUMIDITY_NORMALIZATION_FACTOR_WINTER = 0.89;
    
    //constants for determining weather conditions
    public static final double CONDITION_HUMIDITY_BASELINE = 83;
    public static final double CONDITION_TEMPERATURE_BASELINE = 5;

}
