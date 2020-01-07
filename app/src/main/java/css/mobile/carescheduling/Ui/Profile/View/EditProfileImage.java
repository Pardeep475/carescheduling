package css.mobile.carescheduling.Ui.Profile.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.loader.content.CursorLoader;

import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.Profile.ViewModel.EditProfileImageViewModal;
import css.mobile.carescheduling.Ui.Profile.bean.AddImageBeanRetro;
import css.mobile.carescheduling.Ui.Profile.presenter.IImageClick;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.Utils.Constants;
import css.mobile.carescheduling.databinding.FragmentEditProfileImageBinding;

import java.io.ByteArrayOutputStream;


public class EditProfileImage extends BaseFragment implements Common, IImageClick {
    private FragmentEditProfileImageBinding editProfileImageBinding;
    private EditProfileImageViewModal editProfileImageViewModal;
    private Bitmap bitmap = null;
    private String path = null;
    private boolean buildVer;
    private String imgUrl;

    public static EditProfileImage newInstance(String imageUrlBitmap) {
        EditProfileImage editProfileImage = new EditProfileImage();
        Bundle bundle = new Bundle();
        bundle.putString("Image", imageUrlBitmap);
        editProfileImage.setArguments(bundle);
        return editProfileImage;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imgUrl = getArguments().getString("Image");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        editProfileImageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile_image, container, false);
        View view = editProfileImageBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        buildVer = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        editProfileImageViewModal = ViewModelProviders.of(this).get(EditProfileImageViewModal.class);
        if (imgUrl != null) {
            editProfileImageBinding.setImageUrl(editProfileImageViewModal.ImageFromBase64(imgUrl));
            editProfileImageBinding.imgLogoProfile.setImageBitmap(editProfileImageViewModal.ImageFromBase64(imgUrl));
        }

        editProfileImageBinding.setIImageClick(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_tick);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(true);
        commonBean.setTitle("Change Image");
        editProfileImageBinding.setCommonData(commonBean);
        editProfileImageBinding.setCommonClick(this);
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


    @Override
    public void editImage() {

    }

    @Override
    public void cameraClick() {
        cameraIntent();
    }

    @Override
    public void openGalleryClick() {
        galleryIntent();
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
        if (data != null) {
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
        editProfileImageBinding.setImageUrl(bitmap);
        editProfileImageBinding.imgLogoProfile.setImageBitmap(bitmap);
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


    private void setDataRemote() {
        if (getActivity() != null && ConnectivityReceiver.isNetworkAvailable(getActivity())) {
            if (bitmap != null) {
                showDialog();
                editProfileImageViewModal.AddUserImage(AddNewImage()).observe(this, new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean s) {
                        hideDialog();
                        if (s != null) {
                            if (s) {
                                if (getActivity() != null) {
                                    getActivity().onBackPressed();
                                }
                            }
                        }

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

    private AddImageBeanRetro AddNewImage() {
        AddImageBeanRetro addImageBeanRetro = new AddImageBeanRetro();
        addImageBeanRetro.setCustomerId(getSessionManager().getCustomerId());
        addImageBeanRetro.setImageHexString(editProfileImageViewModal.ConvertBase64(bitmap));
        addImageBeanRetro.setPersonId(getSessionManager().getPersonId());
        addImageBeanRetro.setDefault(editProfileImageBinding.rbIsDefault.isChecked());
        return addImageBeanRetro;
    }


}
