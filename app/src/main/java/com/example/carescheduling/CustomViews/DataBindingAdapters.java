package com.example.carescheduling.CustomViews;

import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.carescheduling.R;

import androidx.databinding.BindingAdapter;

public class DataBindingAdapters {

    @BindingAdapter("setImage")
    public static void setImageUri(ImageView view, String imageUri) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.user_placeholder);
        requestOptions.error(R.drawable.user_placeholder);
        Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(imageUri).into(view);
    }

}
