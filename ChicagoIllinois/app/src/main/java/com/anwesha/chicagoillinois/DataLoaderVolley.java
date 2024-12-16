package com.anwesha.chicagoillinois;

import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataLoaderVolley {
    private static final String weatherURL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Chicago?unitGroup=us&lang=en&key=";
    private static final String iconUrl = "https://openweathermap.org/img/w/";
    private static final String yourAPIKey = "";
    //private static final String DATA_URL = ;
    private static RequestQueue queue;
    private static RequestQueue mainqueue;
    private static Daily daily;
    private static Weather weather;
    private static final String city = "Chicago";
    private static final String unit = "us";
    private static long start;
    private static MainActivity mainActivity;
    private static DailyForecastActivity dailyForecastActivity;

    public static void getSourceData(DailyForecastActivity dailyForecastActivity, String city) {
        RequestQueue queue = Volley.newRequestQueue(dailyForecastActivity);
        Uri.Builder buildURL = Uri.parse(weatherURL).buildUpon();
//        String input = editText.getText().toString();
//        if (input.trim().isEmpty())
//            return;
//        String input="us";
//        buildURL.appendQueryParameter("q", input);
//        buildURL.appendQueryParameter("appid", yourAPIKey);
        String urlToUse = buildURL.build().toString();

//        Uri.Builder buildURL = Uri.parse(weatherURL).buildUpon();
//        String urlToUse = buildURL.build().toString();

        Response.Listener<JSONObject> listener =
                response -> handleResults(dailyForecastActivity, response.toString());

        Response.ErrorListener error = error1 -> {
            // Log.d(TAG, "getSourceData: ");
            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(new String(error1.networkResponse.data));
                // Log.d(TAG, "getSourceData: " + jsonObject);
                handleResults(dailyForecastActivity, null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        };

        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET, urlToUse,
                        null, listener, error);
        queue.add(jsonObjectRequest);
    }

    private static void handleResults(DailyForecastActivity mainActivity, String s) {

        if (s == null) {
            mainActivity.downloadFailed();
            return;
        }

       // final ArrayList<JSONObject> dailyList = parseJSON(s);
       // if (dailyList != null)
            mainActivity.updateData(weather);
    }

    private static void parseJSON(String s) {

        String name;
        ArrayList<JSONObject> countryList = new ArrayList<>();
        try {
            JSONObject job = new JSONObject(s);
            String address = job.getString("address");
            String timezone = job.getString("timezone");
            String tzoffset = job.getString("tzoffset");
            JSONArray days = job.getJSONArray("days");
            int daycount = 0;
            for (int i = 0; i < days.length(); i++) {
                daycount++;
                JSONObject jsonObject1 = days.getJSONObject(i);
                countryList.add(jsonObject1);
                JSONArray hours = jsonObject1.getJSONArray("hours");
                int hourcount = 0;
                for (int j = 0; j < hours.length(); j++) {
                    hourcount++;
                }
            }

            JSONObject jsonObjectcurrentCond = job.getJSONObject("currentConditions");
            String currentAddress = job.getString("address");
            String currentDateTimeEpoch = jsonObjectcurrentCond.getString("datetimeEpoch");
            String currentTemp = jsonObjectcurrentCond.getString("temp");
            String currentVisibility = jsonObjectcurrentCond.getString("visibility");
            String currentFeelsLike = jsonObjectcurrentCond.getString("feelslike");
            String currentHumidity = jsonObjectcurrentCond.getString("humidity");
            String currentUvIndex = jsonObjectcurrentCond.getString("uvindex");
            String currentIcon = jsonObjectcurrentCond.getString("icon");
            String currentCloudCover = jsonObjectcurrentCond.getString("cloudcover");
            String currentCondition = jsonObjectcurrentCond.getString("conditions");
            String currentWindSpeed = jsonObjectcurrentCond.getString("windspeed");
            String currentWindDir = jsonObjectcurrentCond.getString("winddir");
            String currentWindGust = jsonObjectcurrentCond.getString("windgust");
            String currentSunriseEpoch = jsonObjectcurrentCond.getString("sunriseEpoch");
            String currentSunsetEpoch = jsonObjectcurrentCond.getString("sunsetEpoch");

            weather = new Weather(address, countryList, currentDateTimeEpoch, currentTemp, currentFeelsLike,
                    currentHumidity, currentWindGust, currentWindSpeed, currentWindDir, currentVisibility,
                    currentCloudCover, currentUvIndex, currentCondition, currentIcon, currentSunriseEpoch, currentSunsetEpoch);

            for (int i = 0; i < countryList.size(); i++) {
                JSONArray jsonArrayHours = countryList.get(i).getJSONArray("hours");

            }

            JSONObject jsonObjectDay1 = (JSONObject) days.get(1);
            String temp = jsonObjectDay1.getString("temp");
            String datetime = jsonObjectDay1.getString("datetime");

            //Log.d(TAG, temp);
            //Log.d(TAG, datetime);

//            weatherObj = new Weather(address, description, temp, datetime);


            //Log.d(TAG , address);
            // Log.d(TAG , description);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}