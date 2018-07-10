package com.example.ritik.weather2;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
//connect from api and fetch the data
public class NetworkUtil {
    private  final static String WEATHER_BASE_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/191341";
    private  final static String API_KEY = "jjLsxtX1KZnhLf19SuYDOI6AkUFGVlfs";
    private  final static String PARAM_API_KEY = "apikey";//we are telling that we are passing this api

    public static URL buildUrlForWeather() //userdefined ,ready url and return url
    {
        Uri builtUri = Uri.parse(WEATHER_BASE_URL).buildUpon()//to make url uri is used
                .appendQueryParameter(PARAM_API_KEY,API_KEY)//this is query
                .build();//3 statement with this
        URL url=null;
        try
        {
            url=new URL(builtUri.toString());

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Log.i("tag","url="+url);
        return url;

    }
    public static  String getResponseFromHttpUrl(URL url) throws IOException //cathces the url
    {
       // HttpsURLConnection urlConnection = (HttpsURLConnection)url.openConnection();
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();//making connection..it is a interface direct object nhi bna skte
        //yha typecast ho rha h
        try
        {
            InputStream in = urlConnection.getInputStream();//to write data
            Scanner scan = new Scanner(in);//to read
            scan.useDelimiter("\\A");//java scanner object /A stands for start of string
            boolean hasInput = scan.hasNext();//check more data is avail or not
            if(hasInput)
            {
                return scan.next();
            }
            else
            {
                return null;

            }
        }finally {
            urlConnection.disconnect();
        }
    }
}
