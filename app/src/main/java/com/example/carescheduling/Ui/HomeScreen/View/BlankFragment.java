package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Dashboard.beans.ClientBookingListModel;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.BlankViewModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.Tasks;
import com.example.carescheduling.Ui.HomeScreen.presenter.MyNextVisitClick;
import com.example.carescheduling.Ui.Profile.View.EditProfileImage;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.BlankFragmentBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends BaseFragment implements Common, MyNextVisitClick {

    private BlankViewModel mViewModel;
    private BlankFragmentBinding blankFragmentBinding;
    private ClientBookingScreenModel clientBookingModel;

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        blankFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.blank_fragment, container, false);
        View view = blankFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(BlankViewModel.class);
        blankFragmentBinding.slDemo.startShimmerAnimation();
        try {
            getClientBookingList();
        } catch (Exception e) {
            hideDialog();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }
        blankFragmentBinding.setMyNextVisitClick(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Client Profile");
        blankFragmentBinding.setCommonData(commonBean);
        blankFragmentBinding.setCommonClick(this);
    }

    @Override
    public void moreClientInfoClick() {
        setFragment(ClientInfoHomeFragment.newInstance(clientBookingModel));
    }

    @Override
    public void ClientTask() {
        setFragment(ClientTasksFragment.newInstance());
    }

    @Override
    public void BarcodeClick() {
        if (checkWriteExternalPermission())
            setFragment(ScannerFragment.newInstance());
    }

    @Override
    public void NfcClick() {

    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }

    private void getClientBookingList() {
        if (getActivity() != null) {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                try {
//                    showDialog();  // 5633D002-F453-402E-AD63-AAECA11452B5    15C7E260-5818-41AB-A3E7-F6C90F648A1D
                    mViewModel.getClientBookingList(getSessionManager().getPersonId(),
                            getSessionManager().getBranchId(),
                            getSessionManager().getCustomerId()).observe(this, new Observer<ClientBookingScreenModel>() {
                        @Override
                        public void onChanged(ClientBookingScreenModel clientBookingListModel) {
//                            hideDialog();
                            if (clientBookingListModel != null) {
                                clientBookingModel = clientBookingListModel;
                                blankFragmentBinding.setClientBookingScreenModel(clientBookingListModel);
                                setDataOriginal();
                            } else {
                                setNoDataFound();
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


    private void setNoDataFound() {
        blankFragmentBinding.slDemo.stopShimmerAnimation();
        blankFragmentBinding.slDemo.setVisibility(View.GONE);
        blankFragmentBinding.sBlank.setVisibility(View.GONE);
        blankFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        blankFragmentBinding.slDemo.stopShimmerAnimation();
        blankFragmentBinding.slDemo.setVisibility(View.GONE);
        blankFragmentBinding.sBlank.setVisibility(View.VISIBLE);
        blankFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }


    private boolean checkWriteExternalPermission() {
        String p_read_ex = Manifest.permission.READ_EXTERNAL_STORAGE;
        String p_write_external = android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
        String p_record_audio = Manifest.permission.CAMERA;
        int res1 = getContext().checkCallingOrSelfPermission(p_read_ex);
        int res2 = getContext().checkCallingOrSelfPermission(p_write_external);
        int res3 = getContext().checkCallingOrSelfPermission(p_record_audio);
        return (res1 == PackageManager.PERMISSION_GRANTED && res2 == PackageManager.PERMISSION_GRANTED && res3 == PackageManager.PERMISSION_GRANTED);
    }

    private void requestStoragePermission() {
        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA
                )
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            setFragment(ScannerFragment.newInstance());
                        } else
                            requestStoragePermission();

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {

                    }
                })
                .onSameThread()
                .check();
    }

    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Need Permissions");
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }


}
