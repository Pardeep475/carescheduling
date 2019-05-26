package com.example.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.databinding.ItemClientContactsAdapterBinding;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ClientContactsAdapter extends RecyclerView.Adapter<ClientContactsAdapter.MyViewHolder> {
    private Context context;
    private ItemClientContactsAdapterBinding itemClientContactsAdapterBinding;

    public ClientContactsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemClientContactsAdapterBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_client_contacts_adapter, parent, false);
        return new MyViewHolder(itemClientContactsAdapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull ItemClientContactsAdapterBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
