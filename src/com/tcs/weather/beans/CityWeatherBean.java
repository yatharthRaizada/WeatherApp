package com.tcs.weather.beans;

import java.util.Date;

/**
 * This class is City Weather Bean class
 *
 * @author Yatharth Raizada
 */
public class CityWeatherBean {

    private CityBean objCityBean;
    private Date localTime;

    private String weatherCondition;

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    private Double temperatureInCelsius;
    private Double pressureInHPA;
    private Double relativeHumidityInPercentage;

    public CityBean getObjCityBean() {
        return objCityBean;
    }

    public void setObjCityBean(CityBean objCityBean) {
        this.objCityBean = objCityBean;
    }

    public Date getLocalTime() {
        return localTime;
    }

    public void setLocalTime(Date localTime) {
        this.localTime = localTime;
    }

    public Double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(Double temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public Double getPressureInHPA() {
        return pressureInHPA;
    }

    public void setPressureInHPA(Double pressureInHPA) {
        this.pressureInHPA = pressureInHPA;
    }

    public Double getRelativeHumidityInPercentage() {
        return relativeHumidityInPercentage;
    }

    public void setRelativeHumidityInPercentage(Double relativeHumidityInPercentage) {
        this.relativeHumidityInPercentage = relativeHumidityInPercentage;
    }

}
