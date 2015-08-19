package com.example.jonas.weatherman.network;

import com.example.jonas.weatherman.pojo.WeatherData;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Jonas on 19/08/2015.
 */
public interface GetWeatherApi {
    @GET("/data/2.5/weather")
    void getWeatherFromApi(@Query("q") String cityName, Callback<WeatherData> callback);
}
