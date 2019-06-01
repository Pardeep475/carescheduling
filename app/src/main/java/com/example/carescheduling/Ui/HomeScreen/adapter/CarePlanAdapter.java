package com.example.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.databinding.HomeCarePlanSubitemsBinding;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CarePlanAdapter extends RecyclerView.Adapter<CarePlanAdapter.MyViewHolder> {
    private Context context;
    private HomeCarePlanSubitemsBinding homeCarePlanSubitemsBinding;

    public CarePlanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        homeCarePlanSubitemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.home_care_plan_subitems, parent, false);
        return new MyViewHolder(homeCarePlanSubitemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull HomeCarePlanSubitemsBinding itemView) {
            super(itemView.getRoot());
        }
    }
}