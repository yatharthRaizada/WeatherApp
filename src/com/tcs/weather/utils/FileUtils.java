/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.weather.utils;

import com.tcs.weather.beans.CityBean;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Nileshwari
 */
public class FileUtils {

    public ArrayList<CityBean> readCSVFile() {
        ArrayList<CityBean> listCityBean = new ArrayList<CityBean>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        InputStream inputStream = null;
        CityBean objCityBean = null;

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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listCityBean;

    }

}
