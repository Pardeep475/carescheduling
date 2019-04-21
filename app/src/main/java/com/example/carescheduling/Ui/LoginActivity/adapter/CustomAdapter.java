package com.example.carescheduling.Ui.LoginActivity.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.LoginActivity.beans.LoginBeanRetro;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class CustomAdapter extends ArrayAdapter<LoginBeanRetro.BranchList> {

    LayoutInflater flater;

    public CustomAdapter(Activity context, int resouceId, int textviewId, ArrayList<LoginBeanRetro.BranchList> list) {

        super(context, resouceId, textviewId, list);
        flater = context.getLayoutInflater();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,@NonNull ViewGroup parent) {

        LoginBeanRetro.BranchList rowItem = getItem(position);

        View rowview = flater.inflate(R.layout.item_spinner_sf, null, true);

        TextView txtTitle = (TextView) rowview.findViewById(R.id.title);
        txtTitle.setText(rowItem.getBranchName());

        ImageView imageView = (ImageView) rowview.findViewById(R.id.icon);
//        imageView.setImageResource(rowItem.getImageId());

        return rowview;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = flater.inflate(R.layout.item_spinner_sf, parent, false);
        }
        LoginBeanRetro.BranchList rowItem = getItem(position);
        TextView txtTitle = convertView.findViewById(R.id.title);
        txtTitle.setText(rowItem.getBranchName());
        ImageView imageView = (ImageView) convertView.findViewById(R.id.icon);
//        imageView.setImageResource(rowItem.getImageId());
        return convertView;
    }
}
