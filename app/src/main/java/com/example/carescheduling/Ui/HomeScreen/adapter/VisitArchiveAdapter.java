package com.example.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.HomeScreen.beans.VisitArchiveAdapterBean;
import com.example.carescheduling.databinding.ItemVisitArchiveBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class VisitArchiveAdapter extends RecyclerView.Adapter<VisitArchiveAdapter.MyViewHolder> {
    private ItemVisitArchiveBinding itemVisitArchiveBinding;
    private Context context;
    private ArrayList<VisitArchiveAdapterBean> dataList;

    public VisitArchiveAdapter(Context context, ArrayList<VisitArchiveAdapterBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemVisitArchiveBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_visit_archive, parent, false);
        return new MyViewHolder(itemVisitArchiveBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        itemVisitArchiveBinding.setVisitArchiveAdapterBean(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull ItemVisitArchiveBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
