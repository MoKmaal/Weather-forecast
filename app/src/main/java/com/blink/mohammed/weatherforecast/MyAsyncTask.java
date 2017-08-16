package com.blink.mohammed.weatherforecast;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by mohammed on 16/08/17.
 */

// get news from server
public class MyAsyncTask extends AsyncTask<String, String, String> {
    Context context;
    ArrayList<Data> data;
    ListAdapter listAdapter;

    public MyAsyncTask(Context context) {
        this.context=context;
        data = new ArrayList<>();
    }

    @Override
    protected void onPreExecute() {

    }
    @Override
    protected String  doInBackground(String... params) {
        // TODO Auto-generated method stub
        try {
            String weather;

            URL url = new URL(params[0]);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(5000);

            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                weather = XML2String.convert2String(in);

                publishProgress(weather);
            }catch (Exception e)
            {
                Toast.makeText(context,"No internet connection",Toast.LENGTH_LONG).show();
            }

            finally {
                //end connection
                urlConnection.disconnect();
            }

        }catch (Exception ex){}
        return null;
    }
    protected void onProgressUpdate(String... progress) {

        try {
            JSONObject json= new JSONObject(progress[0]);

            JSONObject query=json.getJSONObject("query");
            JSONObject results=query.getJSONObject("results");
            JSONObject channel=results.getJSONObject("channel");
            JSONObject item=channel.getJSONObject("item");
            JSONArray forecast = item.getJSONArray("forecast");
            for (int i=0;i<=forecast.length();i++) {
                JSONObject weather = forecast.getJSONObject(i);
                int high = weather.getInt("high");
                int low = weather.getInt("low");
                String text = weather.getString("text");
                String date = weather.getString("date");
                data.add(new Data(date,text,high,low));
                listAdapter = new ListAdapter(context,data);
                MainActivity.listView.setAdapter(listAdapter);
            }
            //display response data

        } catch (Exception ex) {
        }


    }

    protected void onPostExecute(String  result2){


    }




}
