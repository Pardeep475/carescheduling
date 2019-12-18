package com.example.carescheduling.Ui.Profile.View;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import android.provider.Settings;
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
import com.example.carescheduling.Ui.Profile.Adapter.ProfileImageListAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.ProfileImageListViewModel;
import com.example.carescheduling.Ui.Profile.bean.DeleteImageRetro;
import com.example.carescheduling.Ui.Profile.bean.GetMyPicturesEditBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.ImageDataBean;
import com.example.carescheduling.Ui.Profile.presenter.IDeleteClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.FragmentProfileImageListBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

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
//                setDataFromLocal();
            }
        } catch (Exception e) {
            profileImageListBinding.rcvImages.hideShimmerAdapter();
            showAToast(e.toString());
        }

    }

    private void setDataFromLocal(){
        profileImageListViewModel.getDataFromLocal(getActivity()).observe(this, new Observer<ArrayList<ImageDataBean>>() {
            @Override
            public void onChanged(ArrayList<ImageDataBean> profileImageRetro) {
                if (profileImageRetro != null) {
                    setDataList(profileImageRetro);
                }else{
                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                    profileImageListBinding.rcvImages.hideShimmerAdapter();
                }
            }
        });
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
                    getSessionManager().getBranchId()).observe(this, new Observer<ArrayList<ImageDataBean>>() {
                @Override
                public void onChanged(ArrayList<ImageDataBean> profileImageRetro) {
                    if (profileImageRetro != null) {
                        setDataList(profileImageRetro);
                    }else{
                        profileImageListBinding.rcvImages.hideShimmerAdapter();
                    }
                }
            });
        } catch (Exception e) {
            profileImageListBinding.rcvImages.hideShimmerAdapter();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    private void setDataList(ArrayList<ImageDataBean> profileImageRetro) {
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
        String p_write_external = Manifest.permission.WRITE_EXTERNAL_STORAGE;
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
    public void iDeleteImage(ImageDataBean deleteImage) {
        customDialog(deleteImage);
    }


    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }


    public void customDialog(final ImageDataBean deleteImage) {
        if (getActivity() != null) {
            dialog = new Dialog(getActivity());//,android.R.style.Theme_Translucent_NoTitleBar
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custom_dialog_profile);
            Button profile_dialog_gallery = (Button) dialog.findViewById(R.id.profile_dialog_gallery);
            Button profile_dialog_camera = (Button) dialog.findViewById(R.id.profile_dialog_camera);
            Button profile_dialog_cancel = (Button) dialog.findViewById(R.id.profile_dialog_cancel);

            profile_dialog_gallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UpdateUserImageRetro(deleteImage);
                    dialog.dismiss();
                }
            });
            profile_dialog_camera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deletePhoto(deleteImage);
                    dialog.dismiss();
                }
            });
            profile_dialog_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            Window windo = dialog.getWindow();
            if (windo != null) {
                windo.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                windo.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                WindowManager.LayoutParams wlp = windo.getAttributes();
                wlp.gravity = Gravity.BOTTOM;
                windo.setAttributes(wlp);
            }
            dialog.show();
        }
    }

    private void deletePhoto(ImageDataBean deleteImage) {
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


    private void UpdateUserImageRetro(ImageDataBean deleteImage) {
        DeleteImageRetro deleteImageRetro = new DeleteImageRetro();
        deleteImageRetro.setDefault(true);
        deleteImageRetro.setPersonId(deleteImage.getPersonId());
        deleteImageRetro.setImageId(deleteImage.getImageId());


        try {

            if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                profileImageListViewModel.UpdateUserImageRetro(deleteImageRetro).observe(this, new Observer<Boolean>() {
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


}
