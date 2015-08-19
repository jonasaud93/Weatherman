package com.example.jonas.weatherman.pojo;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp_min")
    private double minTemp;

    @SerializedName("temp_max")
    private double maxTemp;

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }
}
