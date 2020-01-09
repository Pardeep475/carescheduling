package css.mobile.carescheduling.Utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import css.mobile.carescheduling.R;

public class FullScreenDialog extends DialogFragment {
    public static final String TAG = "FullScreenDialog";
    private ProgressBar progressDialog;
    private ImageView gifImage;
    private Handler handler;
    private boolean isFull;
    private FullScreenDialog fullScreenDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        getActivity().getWindow().setFlags(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        /*getActivity().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);*/
//        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light);

        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }
    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle state) {
        super.onCreateView(inflater, parent, state);

        View view = getActivity().getLayoutInflater().inflate(R.layout.full_screen_dialog_layout, parent, false);
        fullScreenDialog = this;
        initView(view);
        return view;
    }

    private void initView(View view) {
//        fullScreenDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog = view.findViewById(R.id.progress_bar);
        gifImage = view.findViewById(R.id.img_gif);
        progressDialog.setMax(100);
        if (getActivity() != null)
            Glide.with(getActivity())
                    .asGif()
                    .load(R.drawable.gif_image)
                    .placeholder(R.drawable.gif_image)
                    .into(gifImage);

        handler = new Handler();
        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        int prog = progressDialog.getProgress();
                        if (prog < 98) {
                            int a = progressDialog.getProgress() + 1;
                            progressDialog.setProgress(a);
                            if (!isFull)
                                handler.postDelayed(this, 90);
                        }
                    }
                }, 0
        );
    }

    public void progressFull() {
        isFull = true;
        progressDialog.setProgress(100);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
