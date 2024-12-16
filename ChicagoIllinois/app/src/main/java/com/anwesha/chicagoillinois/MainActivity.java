package com.anwesha.chicagoillinois;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public DailyForecastActivity dailyForecastActivity;
public Weather weather;
public static final ArrayList<Hourly>hourList=new ArrayList<>();
public MainActivity mainActivity;
public String city="Chicago";
public String unit="us";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   DataLoaderVolley.getMainSourceData(this,city);
    }
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.new_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuA) {
            //Toast.makeText(this, "You want to do A", Toast.LENGTH_SHORT).show();
           // textView.setText(R.string.a);
            return true;
        } else if (item.getItemId() == R.id.menuB) {
           // Toast.makeText(this, "You have chosen B", Toast.LENGTH_SHORT).show();
           // textView.setText(R.string.b);
            Intent intent=new Intent(this,DailyForecastActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.menuC) {
          //  Toast.makeText(this, "C is your selection", Toast.LENGTH_SHORT).show();
          //  textView.setText(R.string.c);
            return true;
        }  else {
            return super.onOptionsItemSelected(item);
        }
    }


}