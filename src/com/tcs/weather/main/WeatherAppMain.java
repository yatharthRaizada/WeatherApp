package com.tcs.weather.main;

import com.tcs.weather.beans.CityBean;
import com.tcs.weather.beans.CityWeatherBean;
import com.tcs.weather.constants.WeatherAppConstants;
import com.tcs.weather.utils.FileUtils;
import com.tcs.weather.utils.DateUtils;
import com.tcs.weather.utils.HumidityUtils;
import com.tcs.weather.utils.PressureUtils;
import com.tcs.weather.utils.TempertureUtils;
import com.tcs.weather.utils.WeatherConditionUtils;
import java.util.ArrayList;
import java.util.Date;

public class WeatherAppMain {

    /**
     * @param args
     */
    public static void main(String[] args) {

        ArrayList<CityBean> listCityBean = new ArrayList<CityBean>();
        ArrayList<Date> listRandomDate = new ArrayList<Date>();
        TempertureUtils objTemperatureUtils = new TempertureUtils();
        PressureUtils objPressureUtils = new PressureUtils();
        HumidityUtils objHumidityUtils = new HumidityUtils();
        WeatherConditionUtils objWeatherConditionUtils = new WeatherConditionUtils();

        DateUtils objDateUtils = new DateUtils();

        CityWeatherBean objCityWeatherBean = null;
        ArrayList<CityWeatherBean> listCityWeatherBean = new ArrayList<CityWeatherBean>();
        FileUtils objFileUtils = new FileUtils();
        listCityBean = objFileUtils.readCSVFile();
        listRandomDate = objDateUtils.getListRandomDates(listCityBean.size());

        if (listCityBean.size() > 0) {
            for (int i = 0; i < listCityBean.size(); i++) {
                objCityWeatherBean = new CityWeatherBean();
                objCityWeatherBean.setObjCityBean(listCityBean.get(i));
                //get random local time
                objCityWeatherBean.setLocalTime(listRandomDate.get(i));
                //get temperature
                objCityWeatherBean.setTemperatureInCelsius(objTemperatureUtils.getTemperature(listCityBean.get(i), objCityWeatherBean.getLocalTime()));
                //getPressure
                objCityWeatherBean.setPressureInHPA(objPressureUtils.getPressure(listCityBean.get(i).getElevation()));
                //get humidity
                objCityWeatherBean.setRelativeHumidityInPercentage(objHumidityUtils.getHumidity(listCityBean.get(i), objCityWeatherBean.getTemperatureInCelsius(), objCityWeatherBean.getLocalTime()));
                //get condition
                objCityWeatherBean.setWeatherCondition(objWeatherConditionUtils.getWeatherCondition(objCityWeatherBean.getTemperatureInCelsius(), objCityWeatherBean.getRelativeHumidityInPercentage()));

                listCityWeatherBean.add(objCityWeatherBean);
            }

        } else {
            System.out.println("Error occurred in parsing csv file. Exiting.");
        }

        if (listCityWeatherBean.size() > 0) {
            for (int i = 0; i < listCityWeatherBean.size(); i++) {
                objCityWeatherBean = listCityWeatherBean.get(i);
                System.out.print(objCityWeatherBean.getObjCityBean().getCityName() + WeatherAppConstants.OUTPUT_DELIMITER);
                System.out.print(objCityWeatherBean.getObjCityBean().getLatitude() + WeatherAppConstants.POSITION_DELIMITER);
                System.out.print(objCityWeatherBean.getObjCityBean().getLongitude() + WeatherAppConstants.POSITION_DELIMITER);
                System.out.print(objCityWeatherBean.getObjCityBean().getElevation() + WeatherAppConstants.OUTPUT_DELIMITER);
                System.out.print(objDateUtils.getISO8601Date(objCityWeatherBean.getLocalTime()) + WeatherAppConstants.OUTPUT_DELIMITER);
                System.out.print(objCityWeatherBean.getWeatherCondition() + WeatherAppConstants.OUTPUT_DELIMITER);
                System.out.print(String.format("%.2f", objCityWeatherBean.getTemperatureInCelsius()) + WeatherAppConstants.OUTPUT_DELIMITER);
                System.out.print(String.format("%.2f", objCityWeatherBean.getPressureInHPA()) + WeatherAppConstants.OUTPUT_DELIMITER);
                System.out.println(String.format("%.2f", objCityWeatherBean.getRelativeHumidityInPercentage()) + WeatherAppConstants.OUTPUT_DELIMITER);

            }

        } else {
            System.out.println("Error occurred in parsing csv file. Exiting.");
        }

    }

}
