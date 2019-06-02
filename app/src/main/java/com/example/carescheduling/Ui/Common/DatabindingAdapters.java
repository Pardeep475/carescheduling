package com.example.carescheduling.Ui.Common;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class DatabindingAdapters {
    @BindingAdapter("android:src")
    public static void setImageUri(ImageView view, String imageUri) {
        if (imageUri == null) {
            view.setImageURI(null);
        } else {
            view.setImageURI(Uri.parse(imageUri));
        }
    }

    @BindingAdapter("android:src")
    public static void setImageUri(ImageView view, Uri imageUri) {
        view.setImageURI(imageUri);
    }

    @BindingAdapter("app:srcCompat")
    public static void setImageDrawable(ImageView view, Drawable drawable) {
        view.setImageDrawable(drawable);
    }

    @BindingAdapter("app:srcCompat")
    public static void setImageResource(ImageView imageView, int resource){
        imageView.setImageResource(resource);
    }
}
