package com.example.ritik.weather2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
//control flow of data
//control view
public class WeatherAdaptor extends ArrayAdapter<Temperature> {//temperature object to make and add in aaray list

    public WeatherAdaptor(Context context, ArrayList<Temperature> weather) {
        super(context, 0, weather);
    }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            Temperature weather = getItem(position);//jo b item nikalna h getitem se call krlo
            if(convertView == null)
            {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list2,parent,false);//reference
            }
            TextView tvDate = convertView.findViewById(R.id.avDate);
            TextView tvMin = convertView.findViewById(R.id.tvLowTemp);
            TextView tvTemp = convertView.findViewById(R.id.tvHighTemp);
            TextView tvLink = convertView.findViewById(R.id.tvHttpLink);
            tvDate.setText(weather.getDate());
            tvMin.setText(weather.getMinTemp());
            tvTemp.setText(weather.getMaxTemp());
            tvLink.setText(weather.getLink());
            return convertView;
        }
    }

