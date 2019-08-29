package com.example.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ScannerFragmentViewModal;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.MatchingClientBarcodeForLoginRetro;
import com.example.carescheduling.Ui.HomeScreen.beans.ScanBean;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.FragmentScannerViewBinding;
import com.google.zxing.Result;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerFragment extends BaseFragment implements ZXingScannerView.ResultHandler, Common {
    private FragmentScannerViewBinding fragmentScannerViewBinding;
    private ScannerFragmentViewModal mViewModel;

    public static ScannerFragment newInstance() {
        return new ScannerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentScannerViewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_scanner_view, container, false);
        mViewModel = ViewModelProviders.of(this).get(ScannerFragmentViewModal.class);
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
        gettingBarcodeString(rawResult.getText());
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

    private void gettingBarcodeString(String barcodeStringId) {
        if (getActivity() != null) {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                try {
                    showDialog();
                    MatchingClientBarcodeForLoginRetro matchingClientBarcodeForLoginRetro = new MatchingClientBarcodeForLoginRetro();
                    matchingClientBarcodeForLoginRetro.setBarcodeInfoString(barcodeStringId);
                    matchingClientBarcodeForLoginRetro.setBranchId(getSessionManager().getBranchId());
                    matchingClientBarcodeForLoginRetro.setClientPersonId(getSessionManager().getClientId());
                    matchingClientBarcodeForLoginRetro.setEmployeePersonId(getSessionManager().getPersonId());
                    matchingClientBarcodeForLoginRetro.setCustomerId(getSessionManager().getCustomerId());
                    mViewModel.getMatchingClientBarcodeForLogin(matchingClientBarcodeForLoginRetro).observe(this, new Observer<ScanBean>() {
                        @Override
                        public void onChanged(ScanBean scanBean) {
                            hideDialog();
                            if (scanBean != null && scanBean.getSuccess() && scanBean.getData() != null) {
                                setFragment(ArrivalAndDepartureFragment.newInstance(scanBean, "Barcode"));
                            } else {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        previewCamera();
                                    }
                                }, 1000);
                            }
                        }
                    });
                } catch (Exception e) {
                    hideDialog();
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void previewCamera() {
        fragmentScannerViewBinding.svScanner.resumeCameraPreview(this);
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }
}