package com.example.carescheduling.Ui.Profile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Profile.bean.ProfileImageList;
import com.example.carescheduling.databinding.ItemProfileImageListBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileImageListAdapter extends RecyclerView.Adapter<ProfileImageListAdapter.MyViewHolder> {
    private ItemProfileImageListBinding itemProfileImageListBinding;
    private ArrayList<ProfileImageList> arrayList;
    private Context context;
    private LayoutInflater inflater;

    public ProfileImageListAdapter(ArrayList<ProfileImageList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemProfileImageListBinding = DataBindingUtil.inflate(inflater, R.layout.item_profile_image_list, parent, false);
        return new MyViewHolder(itemProfileImageListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        itemProfileImageListBinding.setProfileImageList(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull ItemProfileImageListBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
