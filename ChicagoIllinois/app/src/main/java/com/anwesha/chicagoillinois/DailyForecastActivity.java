package com.anwesha.chicagoillinois;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DailyForecastActivity extends AppCompatActivity {
    private static final ArrayList<Daily> dailyList = new ArrayList<>();  // Main content is here
    private RecyclerView recyclerView; // Layout's recyclerview
    private DailyAdapter mAdapter; // Data to recyclerview adapter
    TextView DayandDate;
    boolean metric;
    String city="Chicago";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        recyclerView = findViewById(R.id.dailyrecyclerview);
        mAdapter = new DailyAdapter(dailyList, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Load the data
        DataLoaderVolley.getSourceData(this,city);
    }

    public void downloadFailed() {
    }

    public void updateData(Weather list) {
        ArrayList<JSONObject>w= list.getDays();
        for(int i=0;i<list.getDays().size();i++) {
            JSONObject ob = w.get(i);
            try{
                String dateTimeEpoch=ob.getString("dateTimeEpoch");
                String max=ob.getString("tempmax");
                String min=ob.getString("tempmin");
                String pp=ob.getString("precipprob");
                String uvind=ob.getString("uvindex");
                String des=ob.getString("description");
                String icon=ob.getString("icon");
                JSONArray hr=ob.getJSONArray("hours");
                String mt=hr.getJSONObject(8).getString("temp");
                String at=hr.getJSONObject(13).getString("temp");
                String et=hr.getJSONObject(17).getString("temp");
                String nt=hr.getJSONObject(23).getString("temp");
                //String dateTimeEpoch=ob.getString("dateTimeEpoch");

   dailyList.add(new Daily(dateTimeEpoch,max,min,pp, uvind,des,mt,at,et,nt,icon));

        } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        mAdapter.notifyDataSetChanged();

    }
}
