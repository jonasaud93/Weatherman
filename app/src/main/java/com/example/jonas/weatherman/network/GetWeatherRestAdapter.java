package com.example.jonas.weatherman.network;

import android.util.Log;

import com.example.jonas.weatherman.pojo.WeatherData;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GetWeatherRestAdapter {
    private static final String BASE_URL = "http://api.openweathermap.org";
    private static final String LOG_TAG = GetWeatherRestAdapter.class.getSimpleName();

    private GetWeatherApi api;
    private RestAdapter restAdapter;

    public GetWeatherApi getApi() {
        return api;
    }

    public void setApi(GetWeatherApi api) {
        this.api = api;
    }

    public GetWeatherRestAdapter(){
        restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .build();

        api = restAdapter.create(GetWeatherApi.class);
    }
}
