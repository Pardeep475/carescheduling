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
import com.example.carescheduling.Ui.Dashboard.beans.PersonImage;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Profile.Adapter.ProfileImageListAdapter;
import com.example.carescheduling.Ui.Profile.ViewModel.ProfileImageListViewModel;
import com.example.carescheduling.Ui.Profile.bean.DataList;
import com.example.carescheduling.Ui.Profile.bean.Image;
import com.example.carescheduling.Ui.Profile.bean.ProfileImageRetro;
import com.example.carescheduling.Ui.Profile.presenter.EditEmailClick;
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


public class ProfileImageList extends BaseFragment implements Common, ProfileImageListClick {
    private FragmentProfileImageListBinding profileImageListBinding;
    private String path = null;
    private boolean buildVer;
    private ProfileImageListViewModel profileImageListViewModel;
    private ProfileImageRetro profileResultBean;
    private ProfileBean profileBean;
    private Bitmap bitmap = null;

    public static ProfileImageList newInstance(ProfileBean profileResultBean) {
        ProfileImageList profileImageList = new ProfileImageList();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.PROFILE_DATA, (Serializable) profileResultBean);
        profileImageList.setArguments(bundle);
        return profileImageList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            profileBean = (ProfileBean) getArguments().getSerializable(Constants.PROFILE_DATA);
        }
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
        buildVer = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        profileImageListViewModel = ViewModelProviders.of(this).get(ProfileImageListViewModel.class);

        profileImageListBinding.rcvImages.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            FetchProfileListImages();
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }


        profileImageListBinding.setProfileImageList(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(true);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Profile Pics");
        profileImageListBinding.setCommonData(commonBean);
        profileImageListBinding.setCommonClick(this);
    }

    private void FetchProfileListImages() {
        ///Small
//        "D364C4C1-7A84-4313-94A8-12035EE631D3"
//                , "5F98AF4F-25DC-4AC8-B867-C5072C101011"
//                , "5F98AF4F-25DC-4AC8-B867-C5072C100000"

//        getSessionManager().getPersonId()
//                , getSessionManager().getCustomerId()
//                , getSessionManager().getBranchId()

        try {
            showDialog();
            profileImageListViewModel.getProfileImages(getSessionManager().getPersonId()
                    , getSessionManager().getCustomerId(),
                    getSessionManager().getBranchId()).observe(this, new Observer<ProfileImageRetro>() {
                @Override
                public void onChanged(ProfileImageRetro profileImageRetro) {
                    profileResultBean = profileImageRetro;
                    hideDialog();
                    profileImageListViewModel.getImagePath(profileImageRetro).observe(ProfileImageList.this, new Observer<ArrayList<com.example.carescheduling.Ui.Profile.bean.ProfileImageList>>() {
                        @Override
                        public void onChanged(ArrayList<com.example.carescheduling.Ui.Profile.bean.ProfileImageList> profileImageLists) {
                            if (profileImageLists.size() > 0) {
                                profileImageListBinding.setImageUrl(profileImageLists.get(0).getImageBitMap());
                            }
                            if (profileImageLists.size() > 1) {
                                profileImageLists.remove(0);
                                ProfileImageListAdapter profileImageListAdapter = new ProfileImageListAdapter(profileImageLists, getActivity());
                                profileImageListBinding.rcvImages.setAdapter(profileImageListAdapter);
                            }
                        }
                    });
                }
            });
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public void ProfileClick() {
        if (checkWriteExternalPermission())
            customDialog();
        else
            requestStoragePermission();
    }

    private void customDialog() {
        final Dialog dialog = new Dialog(getActivity());//,android.R.style.Theme_Translucent_NoTitleBar
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_profile);
        Button profile_dialog_gallery = dialog.findViewById(R.id.profile_dialog_gallery);
        Button profile_dialog_camera = dialog.findViewById(R.id.profile_dialog_camera);
        Button profile_dialog_cancel = dialog.findViewById(R.id.profile_dialog_cancel);

        profile_dialog_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryIntent();
                dialog.dismiss();
            }
        });
        profile_dialog_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraIntent();
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
        windo.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        windo.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams wlp = windo.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        windo.setAttributes(wlp);
        dialog.show();
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, Constants.REQUEST_CAMERA);
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select File"), Constants.SELECT_FILE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("Result", requestCode + "       " + resultCode);
        if (data != null ) {
            if (requestCode == Constants.REQUEST_CAMERA) {
                if (data.getExtras() == null)
                return;
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                Uri uri = getImageUri(getContext(), bitmap);
                path = getRealPathFromURI(getContext(), uri);

//                Glide.with(getActivity()).load(data.getExtras().get("data")).into(cvi_profile);
            } else if (requestCode == Constants.SELECT_FILE) {
                if (data.getData() == null)
                    return;

                if (buildVer) {
                    path = getpath19(getContext(), data.getData());
                } else {
                    path = getRealPathFromURI_API11to18(getContext(), data.getData());
                }
//                Glide.with(getActivity()).load(data.getData()).into(cvi_profile);
            }
            getImagePath(path);
        }
    }

    private void getImagePath(String path) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bitmap = BitmapFactory.decodeFile(path, bmOptions);
        bitmap = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
        profileImageListBinding.setImageUrl(bitmap);
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    @SuppressLint("NewApi")
    public String getpath19(Context context, Uri uri) {
        String filePath = "";

        String wholeID = DocumentsContract.getDocumentId(uri);

        // Split at colon, use second item in the array
        String id = wholeID.split(":")[1];

        String[] column = {MediaStore.Images.Media.DATA};

        // where id is equal to
        String sel = MediaStore.Images.Media._ID + "=?";

        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                column, sel, new String[]{id}, null);

        int columnIndex = cursor.getColumnIndex(column[0]);

        if (cursor.moveToFirst()) {
            filePath = cursor.getString(columnIndex);
        }
        cursor.close();
        return filePath;
    }

    @SuppressLint("NewApi")
    public static String getRealPathFromURI_API11to18(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        String result = null;

        CursorLoader cursorLoader = new CursorLoader(
                context,
                contentUri, proj, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();

        if (cursor != null) {
            int column_index =
                    cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            result = cursor.getString(column_index);
        }
        return result;
    }

    public String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
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
                            customDialog();
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


    private void setDataRemote() {
        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            if (bitmap != null) {
                showDialog();
                profileImageListViewModel.getEditProfilePost(AddNewImage()).observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        hideDialog();
                        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                hideDialog();
                Toast.makeText(getActivity(), "Please select image", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    private ProfileBean.Data AddNewImage() {

        if (profileBean != null && profileBean.getData() != null && profileBean.getData().getPersonImage() != null) {
            PersonImage personImage = new PersonImage();
            personImage.setCustomerId(getSessionManager().getCustomerId());
            personImage.setImageAddedDate("/Date(1559193723680+0530)/");
            personImage.setImageAltText("");
            personImage.setImageFile("");
            personImage.setImageFileName("download.jpg");
            personImage.setImageFileTypeName("image/jpeg");
            personImage.setImageFileUrl("");
            personImage.setImageHexString(profileImageListViewModel.ConvertBase64(bitmap));
            personImage.setImageId(null);
            personImage.setImageLongAltText("");
            personImage.setImageSizeName("Small");
            personImage.setImageUpdatedDate("/Date(1559193723680+0530)/");
            personImage.setOrientation("360");
            personImage.setImageSizes("");
            personImage.setDefault(true);
            personImage.setMaxColourDepth(0);
            personImage.setYPixel(200);
            personImage.setXPixel(200);
            profileBean.getData().getPersonImage().add(personImage);

        }

//        if (profileResultBean.getDataList() != null) {
//            Image image = new Image();
//            image.setImageHexString(profileImageListViewModel.ConvertBase64(bitmap));
//            DataList dataList = new DataList();
//            dataList.setImage(image);
//            profileResultBean.getDataList().add(dataList);
//        }

        return profileBean.getData();
    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {
        try {
            setDataRemote();
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
