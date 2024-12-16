package com.anwesha.chicagoillinois;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter<DailyViewHolder> {

    private final List<Daily> countryList;
    private final DailyForecastActivity mainAct;

    DailyAdapter(List<Daily> countryList, DailyForecastActivity ma) {
        this.countryList = countryList;
        mainAct = ma;
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
       // Log.d(TAG, "onCreateViewHolder: MAKING NEW");

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.daily_view, parent, false);

        return new DailyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {
        Daily country = countryList.get(position);
        holder.DayandDate.setText(country.getDatetimeEpoch()+"");
        holder.Description.setText(country.getDescription());
        holder.ProbOfPrecipitation.setText(country.getPrecipprob());
        holder.UVindex.setText(country.getUvindex());
        holder.HighLowTemp.setText(country.getTempmax()+""+country.getTempmin());
        holder.MorningTemp.setText(country.getMorningTemp()+"");
        holder.AfternoonTemp.setText(country.getAfternoonTemp()+"");
        holder.NightTemp.setText(country.getNightTemp()+"");
        holder.EveningTemp.setText(country.getEveningTemp()+"");
        holder.WeatherIcon.setImageResource(Integer.parseInt(country.getIcon()));
    }

    public int getItemCount() {
        return countryList.size();
    }
}
