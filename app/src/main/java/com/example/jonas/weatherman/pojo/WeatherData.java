package com.example.jonas.weatherman.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jonas on 19/08/2015.
 */
public class WeatherData {

    @SerializedName("name")
    private String name;

    @SerializedName("main")
    private Main main;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String toString(){
        return name + ", min " + main.getMinTemp() + ", max " + main.getMaxTemp();
    }
}
