package com.tcs.weather.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author yatharth raizada This class has some methods to perform functions
 * related to date and time
 */
public class DateUtils {

    /**
     * This method is used to generate any random date and time for the last
     * year
     *
     * @return date (random date)
     */
    public Date generate() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1); // today minus one year
        Date dMin = cal.getTime();
        cal.add(Calendar.YEAR, 1); // today 
        Date dMax = cal.getTime();
        long MILLIS_PER_DAY = 1000 * 60 * 60 * 24;
        GregorianCalendar s = new GregorianCalendar();
        s.setTimeInMillis(dMin.getTime());
        GregorianCalendar e = new GregorianCalendar();
        e.setTimeInMillis(dMax.getTime());

        // Get difference in milliseconds
        long endL = e.getTimeInMillis() + e.getTimeZone().getOffset(e.getTimeInMillis());
        long startL = s.getTimeInMillis() + s.getTimeZone().getOffset(s.getTimeInMillis());
        long dayDiff = (endL - startL) / MILLIS_PER_DAY;

        Calendar calRandom = Calendar.getInstance();
        calRandom.setTime(dMin);
        calRandom.add(Calendar.DATE, new Random().nextInt((int) dayDiff));
        return calRandom.getTime();
    }
    
    /**
     * This method is used to generate n number of random dates using the above method
     * n is the number of cities found in config file
     * @param numberOfDates
     * @return list_of_random_dates
     */

    public ArrayList<Date> getListRandomDates(int numberOfDates) {
        ArrayList<Date> listRandomDates = new ArrayList<Date>();
        DateUtils rnd = new DateUtils();
        // Date d=rnd.generate();
        for (int i = 1; i <= numberOfDates; i++) {
            listRandomDates.add(rnd.generate());
            //listRandomDates.add(d);
        }
        return listRandomDates;
    }
    
    /**
     * This method is used to format date object in ISO 8601 format
     * @param inputDate
     * @return string_date_in_iso_8601_format
     */

    public String getISO8601Date(Date inputDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return df.format(inputDate);
    }
}
