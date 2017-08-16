package com.blink.mohammed.weatherforecast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
    EditText etCity;
     static ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        etCity=(EditText) findViewById(R.id.etCity);


    }


    public void buGet(View view) {

        String url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather." +
                "forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo." +
                "places(1)%20where%20text%3D%22"+ etCity.getText().toString() +
                "%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

        new MyAsyncTask(getApplicationContext()).execute(url);

    }





}
