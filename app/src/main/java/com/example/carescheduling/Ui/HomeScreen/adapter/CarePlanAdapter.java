package com.example.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCarePlan;
import com.example.carescheduling.Ui.HomeScreen.presenter.CarePlanAdapterClick;
import com.example.carescheduling.databinding.HomeCarePlanSubitemsBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CarePlanAdapter extends RecyclerView.Adapter<CarePlanAdapter.MyViewHolder> {
    private Context context;
    private HomeCarePlanSubitemsBinding homeCarePlanSubitemsBinding;
    private ArrayList<ClientCarePlan.Datum> data;
    private CarePlanAdapterClick carePlanAdapterClick;
    public CarePlanAdapter(Context context, CarePlanAdapterClick carePlanAdapterClick, ArrayList<ClientCarePlan.Datum> data) {
        this.context = context;
        this.carePlanAdapterClick = carePlanAdapterClick;
        this.data = data;
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
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull HomeCarePlanSubitemsBinding itemView) {
            super(itemView.getRoot());
        }
    }
}