package css.mobile.carescheduling.Utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.HomeScreen.View.ScannerFragment;
import css.mobile.carescheduling.Ui.Profile.View.EditProfile;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class CustomDialogClass extends Dialog implements
        android.view.View.OnClickListener {

    private Activity c;
    private Dialog d;
    private String type;
    private String clientName;

    public CustomDialogClass(Activity a, String type, String clientName) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.type = type;
        this.clientName = clientName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.barcode_dialog);
        Window window = this.getWindow();
        if (window != null)
            window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView txtBarcode = findViewById(R.id.txt_barcode);
        TextView txtNfc = findViewById(R.id.txt_nfc);
        TextView title = findViewById(R.id.textView);
        if (type.equalsIgnoreCase("Arrival")) {
            txtNfc.setVisibility(View.GONE);
            title.setText(R.string.please_choose_arrival_type);
            txtBarcode.setText(R.string.barcode);
            txtNfc.setText(R.string.read_nfc);
        } else {
            title.setText("Success\n\n" +
                    "You succesfully registerred manually you visit departure time at" + clientName + ". Do you wish to go back to barcode scanning?\n"
            );
            txtNfc.setVisibility(View.VISIBLE);
            txtBarcode.setText(R.string.no);
            txtNfc.setText(R.string.yes);
        }
        txtBarcode.setOnClickListener(this);
        txtNfc.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_nfc:
                if (clientName != null) {
                    c.onBackPressed();
                    dismiss();
                } else {
                    Toast.makeText(c, "Not implemented yet", Toast.LENGTH_SHORT).show();
                    dismiss();
                }


                break;
            case R.id.txt_barcode:
                if (clientName == null) {
                    if (checkWriteExternalPermission())
                        setFragment(ScannerFragment.newInstance("Arrival", ""));
                    else
                        requestStoragePermission();

                    dismiss();
                } else {
                    dismiss();
                    c.onBackPressed();
                }
                break;
            default:
                break;
        }
    }

    private void setFragment(Fragment fragment) {
        if (c != null)
            ((EditProfile) c).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
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
        Dexter.withActivity(c)
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
                            setFragment(ScannerFragment.newInstance("Arrival", ""));
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
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
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
        Uri uri = Uri.fromParts("package", ((EditProfile) c).getPackageName(), null);
        intent.setData(uri);
        ((EditProfile) c).startActivityForResult(intent, 101);
    }

}
