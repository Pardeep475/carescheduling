package com.example.carescheduling.Ui.Profile.View;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.loader.content.CursorLoader;
import androidx.recyclerview.widget.GridLayoutManager;

import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.Common.SpacesItemDecoration;
import com.example.carescheduling.Ui.Dashboard.beans.PersonImage;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Dashboard.view.Dashboard;
import com.example.carescheduling.Ui.Profile.Adapter.ProfileImageListAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.ProfileImageListViewModel;
import com.example.carescheduling.Ui.Profile.bean.AddImageBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.DataList;
import com.example.carescheduling.Ui.Profile.bean.DeleteImageRetro;
import com.example.carescheduling.Ui.Profile.bean.GetMyPicturesEditBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.Image;
import com.example.carescheduling.Ui.Profile.bean.ProfileImageRetro;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
import com.example.carescheduling.Ui.Profile.presenter.IDeleteClick;
import com.example.carescheduling.Ui.Profile.presenter.ProfileImageListClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.databinding.FragmentProfileImageListBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ProfileImageList extends BaseFragment implements Common, IDeleteClick {
    private FragmentProfileImageListBinding profileImageListBinding;
    private ProfileImageListViewModel profileImageListViewModel;
    private String imageTypeUrl;

    public static ProfileImageList newInstance() {
        return new ProfileImageList();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        profileImageListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_image_list, container, false);
        View view = profileImageListBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        profileImageListViewModel = ViewModelProviders.of(this).get(ProfileImageListViewModel.class);
        profileImageListBinding.rcvImages.showShimmerAdapter();
        profileImageListBinding.rcvImages.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        try {
            if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                FetchProfileListImages();
            } else {
                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            profileImageListBinding.rcvImages.hideShimmerAdapter();
            
            showAToast(e.toString());
        }

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_edit);
        commonBean.setRightImageVisible(true);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Profile Pics");
        profileImageListBinding.setCommonData(commonBean);
        profileImageListBinding.setCommonClick(this);
    }

    private void FetchProfileListImages() {
        try {
           
            profileImageListViewModel.getProfileImages(getSessionManager().getPersonId()
                    , getSessionManager().getCustomerId(),
                    getSessionManager().getBranchId()).observe(this, new Observer<ArrayList<GetMyPicturesEditBeanRetro.DataList>>() {
                @Override
                public void onChanged(ArrayList<GetMyPicturesEditBeanRetro.DataList> profileImageRetro) {
                    if (profileImageRetro != null) {
                        
                        setDataList(profileImageRetro);
                    }
                }
            });
        } catch (Exception e) {
            
            profileImageListBinding.rcvImages.hideShimmerAdapter();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }

    private void setDataList(ArrayList<GetMyPicturesEditBeanRetro.DataList> profileImageRetro) {
        profileImageListBinding.rcvImages.hideShimmerAdapter();
        if (profileImageRetro.size() > 0) {
            imageTypeUrl = profileImageRetro.get(0).getImageHexString();
            profileImageListBinding.rcvImages.addItemDecoration(new SpacesItemDecoration(10));
            ProfileImageListAdapter profileImageListAdapter = new ProfileImageListAdapter(profileImageRetro, getContext(), this);
            profileImageListBinding.rcvImages.setAdapter(profileImageListAdapter);
        }
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
                            setFragment(EditProfileImage.newInstance(imageTypeUrl));
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


    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {
        if (checkWriteExternalPermission())
            setFragment(EditProfileImage.newInstance(imageTypeUrl));
        else
            requestStoragePermission();

    }

    @Override
    public void iDeleteImage(GetMyPicturesEditBeanRetro.DataList deleteImage) {
        DeleteImageRetro deleteImageRetro = new DeleteImageRetro();
        deleteImageRetro.setDefault(deleteImage.getIsDefault());
        deleteImageRetro.setPersonId(deleteImage.getPersonId());
        deleteImageRetro.setImageId(deleteImage.getImageId());


        try {
            
            if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                profileImageListViewModel.DeleteImage(deleteImageRetro).observe(this, new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {
                        
                        if (aBoolean != null) {
                            if (aBoolean) {
                                // on back press
                                if (getActivity() != null)
                                    profileImageListBinding.rcvImages.showShimmerAdapter();
                                FetchProfileListImages();
                            }
                        }
                    }
                });
            } else {
                
                profileImageListBinding.rcvImages.hideShimmerAdapter();
                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            profileImageListBinding.rcvImages.hideShimmerAdapter();
            
            showAToast(e.toString());
        }

    }


    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }


}
