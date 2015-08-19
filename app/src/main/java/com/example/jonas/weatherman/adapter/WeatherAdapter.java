package com.example.jonas.weatherman.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.jonas.weatherman.pojo.WeatherData;

import java.util.List;

/**
 * Created by Jonas on 19/08/2015.
 */
public class WeatherAdapter extends ArrayAdapter<WeatherData> {

    private int resource;

    public WeatherAdapter(Context context, int resource, List<WeatherData> objects) {
        super(context, resource, objects);

        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LinearLayout newView;

        if(convertView == null){
            newView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;

            LayoutInflater li;
            li = (LayoutInflater) getContext().getSystemService(inflater);
            li.inflate(resource, newView, true);
        } else{
            newView = (LinearLayout) convertView;
        }

        WeatherData instance = getItem(position);

        return newView;
    }
}
