package css.mobile.carescheduling.Ui.Profile.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Profile.View.EditProfile;
import css.mobile.carescheduling.Ui.Profile.bean.ImageDataBean;
import css.mobile.carescheduling.Ui.Profile.presenter.IDeleteClick;
import css.mobile.carescheduling.databinding.ItemProfileImageListBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileImageListAdapter extends RecyclerView.Adapter<ProfileImageListAdapter.MyViewHolder> {
    private ItemProfileImageListBinding itemProfileImageListBinding;
    private ArrayList<ImageDataBean> arrayList;
    private Context context;
    private IDeleteClick iDeleteClick;
    private LayoutInflater inflater;

    public ProfileImageListAdapter(ArrayList<ImageDataBean> arrayList, Context context, IDeleteClick iDeleteClick) {
        this.arrayList = arrayList;
        this.context = context;
        this.iDeleteClick = iDeleteClick;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemProfileImageListBinding = DataBindingUtil.inflate(inflater, R.layout.item_profile_image_list, parent, false);
        return new MyViewHolder(itemProfileImageListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        itemProfileImageListBinding.icon.setImageBitmap(ImageFromBase64(arrayList.get(position).getImageHexString()));
        getScreenWidth(itemProfileImageListBinding.icon);
        itemProfileImageListBinding.rlMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                customDialog(arrayList.get(position));
                iDeleteClick.iDeleteImage(arrayList.get(position));
            }
        });
    }

    public Bitmap ImageFromBase64(String img) {
        byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
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


    private void customDialog(final ImageDataBean deleteImages) {
        final Dialog dialog = new Dialog(context);//,android.R.style.Theme_Translucent_NoTitleBar
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.item_delete_image);
        TextView deleteImage = dialog.findViewById(R.id.txt_delete);
        TextView txt_cancel = dialog.findViewById(R.id.txt_cancel);

        txt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iDeleteClick.iDeleteImage(deleteImages);
                dialog.dismiss();
            }
        });
        Window windo = dialog.getWindow();
        windo.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        windo.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams wlp = windo.getAttributes();
        wlp.gravity = Gravity.CENTER;
        windo.setAttributes(wlp);
        dialog.show();
    }


    private void getScreenWidth(ImageView view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((EditProfile) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        view.getLayoutParams().width = (width / 2);
        view.getLayoutParams().height = width / 2;
    }
}
