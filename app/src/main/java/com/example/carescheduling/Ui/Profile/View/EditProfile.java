package com.example.carescheduling.Ui.Profile.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.HomeScreen.View.BlankFragment;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.Utils.Utils;
import com.example.carescheduling.databinding.ActivityEditProfileBinding;

public class EditProfile extends AppCompatActivity {
    private ActivityEditProfileBinding editProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile);
        if (getIntent() != null) {
            ProfileBean profileResultBean = (ProfileBean) getIntent().getSerializableExtra(Constants.PROFILE_DATA);
            if (profileResultBean != null) {
                setFragment(EditProfileStart.newInstance(profileResultBean));
            } else {
                setFragment(BlankFragment.newInstance());
            }
        }
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fm_edit_container, fragment).commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {

        int fragmentCount = getSupportFragmentManager().getBackStackEntryCount();

        if (fragmentCount > 0)
            getSupportFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }
}
