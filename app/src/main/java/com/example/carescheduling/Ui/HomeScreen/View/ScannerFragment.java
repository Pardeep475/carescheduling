package com.example.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.databinding.FragmentScannerViewBinding;
import com.google.zxing.Result;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerFragment extends Fragment implements ZXingScannerView.ResultHandler, Common {
    private FragmentScannerViewBinding fragmentScannerViewBinding;


    public static ScannerFragment newInstance(){
        return new ScannerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentScannerViewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_scanner_view,container,false);
        setCommonData();
        return fragmentScannerViewBinding.getRoot();
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Barcode Scanner");
        fragmentScannerViewBinding.setCommonData(commonBean);
        fragmentScannerViewBinding.setCommonClick(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        fragmentScannerViewBinding.svScanner.setResultHandler(this);
        fragmentScannerViewBinding.svScanner.startCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        Toast.makeText(getActivity(), "Contents = " + rawResult.getText() +
                ", Format = " + rawResult.getBarcodeFormat().name(), Toast.LENGTH_SHORT).show();
        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mScannerView.resumeCameraPreview(getActivity());
//            }
//        }, 2000);
    }

    @Override
    public void onPause() {
        super.onPause();
        fragmentScannerViewBinding.svScanner.stopCamera();
    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }
}