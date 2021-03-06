package css.mobile.carescheduling.CustomViews;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import css.mobile.carescheduling.R;

import androidx.databinding.BindingAdapter;

public class DataBindingAdapters {

    @BindingAdapter("setImage")
    public static void setImageUri(ImageView view, String imageUri) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.user_placeholder);
        requestOptions.error(R.drawable.user_placeholder);
        Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(imageUri).into(view);
    }
    @BindingAdapter("setImage")
    public static void setImageBitmap(ImageView view, Bitmap imageUri) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.user_placeholder);
        requestOptions.error(R.drawable.user_placeholder);
        Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(imageUri).into(view);
    }
}
