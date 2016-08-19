package com.tcs.weather.beans;

public class CityBean {

    private String CityName;
    private double latitude;
    private double longitude;
    private double elevation;
    private boolean isCoastal;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public boolean isIsCoastal() {
        return isCoastal;
    }

    public void setIsCoastal(boolean isCoastal) {
        this.isCoastal = isCoastal;
    }

}
