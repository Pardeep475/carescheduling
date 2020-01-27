package css.mobile.carescheduling.Ui.HomeScreen.View;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.ClientBarcodeList;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.ScannerFragmentViewModal;
import css.mobile.carescheduling.Ui.HomeScreen.beans.MatchingClientBarcodeForLoginRetro;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ScanBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ScannerDataBean;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.databinding.FragmentScannerViewBinding;

import com.google.zxing.Result;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerFragment extends BaseFragment implements ZXingScannerView.ResultHandler, Common {
    private FragmentScannerViewBinding fragmentScannerViewBinding;
    private ScannerFragmentViewModal mViewModel;

    private String type;
    private String noteText;

    public static ScannerFragment newInstance(String type, String noteText) {
        ScannerFragment scannerFragment = new ScannerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("TYPE", type);
        bundle.putString("NOTE_TEXT", noteText);
        scannerFragment.setArguments(bundle);
        return scannerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString("TYPE", "Arrival");
            noteText = getArguments().getString("NOTE_TEXT", "");
        }
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
        Log.e("FragmentCount", "Scanner Fragment");
        fragmentScannerViewBinding.svScanner.setResultHandler(this);
        fragmentScannerViewBinding.svScanner.startCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
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
                    matchingClientBarcodeForLoginRetro.setClientBookingId(getSessionManager().getBookingId());
                    if (type.equalsIgnoreCase("Arrival"))
                        matchingClientBarcodeForLoginRetro.setIsDeparture(false);
                    else
                        matchingClientBarcodeForLoginRetro.setIsDeparture(true);
                    mViewModel.getMatchingClientBarcodeForLogin(matchingClientBarcodeForLoginRetro).observe(this, new Observer<ScanBean>() {
                        @Override
                        public void onChanged(ScanBean scanBean) {
                            hideDialog();
                            if (scanBean != null && scanBean.getSuccess() && scanBean.getData() != null) {
                                setData(scanBean, "Barcode");
                            } else {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
//                                        previewCamera();
                                        showAlertDialog();
                                    }
                                }, 1000);
                            }
                        }
                    });
                } catch (Exception e) {
                    hideDialog();
                    loadLocal(barcodeStringId);
//                    showAlertDialog();
                }
            } else {
                loadLocal(barcodeStringId);
            }
        }
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Barcode not found. Scan Again ?");
        builder.setMessage("Press OK to scan again");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                previewCamera();
//                openSettings();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                getActivity().onBackPressed();
            }
        });
        builder.show();

    }

    private void loadLocal(final String barcodeStringId) {
        AppDataBase.getAppDatabase(getActivity())
                .homeDeo()
                .getAllClientBarcodeList(getSessionManager().getBookingId()).observe(this, new Observer<List<ClientBarcodeList>>() {
            @Override
            public void onChanged(List<ClientBarcodeList> clientBarcodeLists) {
                if (clientBarcodeLists != null && clientBarcodeLists.size() > 0) {
                    int count = 0;
                    for (int i = 0; i < clientBarcodeLists.size(); i++) {
                        ClientBarcodeList clientBarcodeList = clientBarcodeLists.get(i);
                        if (clientBarcodeList.getIsDefault()) {
                            if (barcodeStringId.equalsIgnoreCase(clientBarcodeList.getBarcodeInfoString())) {
                                count++;
                                ScanBean scanBean = new ScanBean();
                                ScannerDataBean scannerDataBean = new ScannerDataBean();
                                scannerDataBean.setBarcodeId(clientBarcodeList.getBarcodeId());
                                scanBean.setData(scannerDataBean);
//                                ScannerDataBean.setBranchId(getSessionManager().getBranchId());
//                                ScannerDataBean.setClientPersonId(getSessionManager().getClientId());
//                                ScannerDataBean.setEmployeePersonId(getSessionManager().getPersonId());
//                                ScannerDataBean.setCustomerId(getSessionManager().getCustomerId());
                                setData(scanBean, "Barcode");
//                                setFragment(ArrivalAndDepartureFragment.newInstance(scanBean, "Barcode"));
                            }
                        } else {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    previewCamera();
                                }
                            }, 1000);
                        }
                    }
                    if (count == 0) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                previewCamera();
                            }
                        }, 1000);
                    }
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
    }

    private void setData(ScanBean scanBean, String scanType) {
        if (scanBean != null) {
            if (scanBean.getData() != null) {

                if (type.equalsIgnoreCase("Arrival")) {
                    if (scanBean.getData().getClientVisitId() != null) {
                        setFragment(ManualLogoutFragment.newInstance(scanBean, scanType));
                    } else {
                        setFragment(ArrivalAndDepartureFragment.newInstance(scanBean, scanType, type, scanBean.getData().getClientVisitId(), noteText));
                    }
                } else {
                    if (scanBean.getData().getClientVisitId() != null) {
                        setFragment(ArrivalAndDepartureFragment.newInstance(scanBean, scanType, type, scanBean.getData().getClientVisitId(), noteText));
                    } else {
                        showAToast("Please update arrival first.");
                    }
                }


            } else {
                showAToast("Something went wrong");
            }
        } else {
            showAToast("Something went wrong");
        }
    }

    private void previewCamera() {
        fragmentScannerViewBinding.svScanner.resumeCameraPreview(this);
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.fm_edit_container, fragment).addToBackStack(null).commit();
    }
}