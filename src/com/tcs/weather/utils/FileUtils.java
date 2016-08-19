
package com.tcs.weather.utils;

import com.tcs.weather.beans.CityBean;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *This class has some methods to perform file related operations
 * @author Yatharth Raizada
 */
public class FileUtils {

    /**
     * This method is used to read a csv file in source folder and set it in City bean
     * @return list_of_city_bean
     */
    public ArrayList<CityBean> readCSVFile() {
        ArrayList<CityBean> listCityBean = new ArrayList<CityBean>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        InputStream inputStream = null;
        CityBean objCityBean = null;

        //read csv file and load it's content in city bean list
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream("CityInfo.csv");

            br = new BufferedReader(new InputStreamReader(inputStream));
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i != 0) {
                    objCityBean = new CityBean();
                    // use comma as separator
                    String[] cityInfo = line.split(cvsSplitBy);
                    objCityBean.setCityName(cityInfo[0]);
                    objCityBean.setLatitude(Double.parseDouble(cityInfo[1]));
                    objCityBean.setLongitude(Double.parseDouble(cityInfo[2]));
                    objCityBean.setElevation(Double.parseDouble(cityInfo[3]));
                    objCityBean.setIsCoastal(Boolean.getBoolean(cityInfo[4]));
                    listCityBean.add(objCityBean);

                }
                ++i;

            }

        } catch (FileNotFoundException e) {
            System.out.println("Config CSV file not found. Please keep csv file in src folder");
        } catch (IOException e) {
            System.out.println("Ërror in reading Config CSV file. Please keep csv file in src folder");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error in closing bufferred reader.");
                }
            }
        }
        return listCityBean;

    }

}
