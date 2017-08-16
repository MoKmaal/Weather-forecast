package com.blink.mohammed.weatherforecast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mohammed on 16/08/17.
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    TextView tvDay;
    TextView tvState;
    TextView tvHigh;
    TextView tvLow;

    ArrayList<Data> dataAdapter;

    public ListAdapter(Context context, ArrayList<Data> dataAdapter) {
        this.context=context;
        this.dataAdapter=dataAdapter;
    }

    @Override
    public int getCount() {
        return dataAdapter.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list,null);

        tvDay =(TextView) v.findViewById(R.id.day);
        tvState = (TextView) v.findViewById(R.id.condition);
        tvHigh = (TextView) v.findViewById(R.id.high);
        tvLow = (TextView) v.findViewById(R.id.low);

        Data data = dataAdapter.get(position);

        tvDay.setText(data.getDay());
        tvState.setText(data.getState());
        tvHigh.setText(""+data.getHigh());
        tvLow.setText(""+data.getLow());

        return v;
    }
}
