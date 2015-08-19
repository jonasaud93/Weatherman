package com.example.jonas.weatherman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jonas.weatherman.network.GetWeatherRestAdapter;
import com.example.jonas.weatherman.pojo.WeatherData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button btnOk;
    private Button btnCancel;
    private EditText txtCity;
    private ListView lstWeatherData;
    private List<String> weatherDataList;
    private ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        txtCity = (EditText) findViewById(R.id.txtCity);
        lstWeatherData = (ListView) findViewById(R.id.lstWeatherItems);

        weatherDataList = new ArrayList<>();
        aa = new ArrayAdapter<>(this, R.layout.weather_item, R.id.lblItem, weatherDataList);
        lstWeatherData.setAdapter(aa);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetWeatherRestAdapter restAdapter = new GetWeatherRestAdapter();
                restAdapter.getApi().getWeatherFromApi(txtCity.getText().toString(), new Callback<WeatherData>() {
                    @Override
                    public void success(WeatherData weatherData, Response response) {
                        WeatherData data;
                        BufferedReader reader = null;
                        StringBuilder sb = new StringBuilder();
                        try {

                            reader = new BufferedReader(new InputStreamReader(response.getBody().in()));

                            String line;

                            try {
                                while ((line = reader.readLine()) != null) {
                                    sb.append(line);
                                }
                                Gson gson = new Gson();
                                data = gson.fromJson(sb.toString(), WeatherData.class);

                                weatherDataList.add(data.toString());
                                lstWeatherData.setAdapter(aa);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.e(TAG, "error while fetching data, " + error);
                    }
                });
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherDataList = new ArrayList<String>();
                lstWeatherData.setAdapter(aa);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
