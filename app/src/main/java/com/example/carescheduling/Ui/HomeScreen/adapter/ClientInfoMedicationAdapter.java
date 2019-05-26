package com.example.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.databinding.ItemClientInfoMedicationBinding;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ClientInfoMedicationAdapter extends RecyclerView.Adapter<ClientInfoMedicationAdapter.MyViewHolder> {
    private Context context;
    private ItemClientInfoMedicationBinding itemClientInfoMedicationBinding;

    public ClientInfoMedicationAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemClientInfoMedicationBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_client_info_medication, parent, false);
        return new MyViewHolder(itemClientInfoMedicationBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull ItemClientInfoMedicationBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
