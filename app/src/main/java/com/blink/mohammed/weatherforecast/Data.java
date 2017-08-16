package com.blink.mohammed.weatherforecast;

/**
 * Created by mohammed on 16/08/17.
 */

public class Data {
    private String day;
    private String state;
    private int high;
    private int low;

    public Data(String day,String state,int high,int low) {
        this.day = day;
        this.state = state;
        this.high = high;
        this.low  = low;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    public String getDay() {
        return day;
    }

    public String getState() {
        return state;
    }
}
