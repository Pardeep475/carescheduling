package com.example.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.HomeScreen.beans.Tasks;
import com.example.carescheduling.databinding.ItemTasksBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ClientTasksAdapter extends RecyclerView.Adapter<ClientTasksAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Tasks> tasksArrayList;
    private ItemTasksBinding itemTasksBinding;

    public ClientTasksAdapter(Context context, ArrayList<Tasks> tasksArrayList) {
        this.context = context;
        this.tasksArrayList = tasksArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemTasksBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_tasks, parent, false);
        return new MyViewHolder(itemTasksBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        itemTasksBinding.setTasks(tasksArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return tasksArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull ItemTasksBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
