package com.example.hellgarammobileapp.Fragment.TransportationFragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hellgarammobileapp.R;

import java.util.ArrayList;

public class StationItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static String log = "StationItemAdapter";

    private String[] arsIdItems = {"15148","15154"};

    public static class StationHolder extends RecyclerView.ViewHolder{
        StationItemView stationItemView;

        public StationHolder(StationItemView view){
            super(view);
            stationItemView = view;
        }
    }

    @Override
    public StationItemAdapter.StationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StationItemAdapter.StationHolder(new StationItemView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        StationItemAdapter.StationHolder stationHolder = (StationItemAdapter.StationHolder) holder;
        Log.d(log,arsIdItems[position]);
        stationHolder.stationItemView.busArriveInfoTask.execute(arsIdItems[position]);
    }

    @Override
    public int getItemCount() {
        return arsIdItems.length;
    }
}
