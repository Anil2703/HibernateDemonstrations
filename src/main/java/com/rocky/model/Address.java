package com.rocky.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetName;
    private String landMark;
    private String cityName;
    private String state;
    private String pinCode;


    public Address() {
    }

    public Address(String streetName, String landMark, String cityName, String state, String pinCode) {
        this.streetName = streetName;
        this.landMark = landMark;
        this.cityName = cityName;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
