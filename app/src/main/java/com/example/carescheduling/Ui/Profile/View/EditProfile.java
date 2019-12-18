package com.example.carescheduling.Ui.Profile.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.HomeScreen.View.BlankFragment;
import com.example.carescheduling.Ui.HomeScreen.View.DirectionsFragment;
import com.example.carescheduling.Ui.HomeScreen.View.HoursAndExspenses;
import com.example.carescheduling.Ui.HomeScreen.View.MyTimeFragment;
import com.example.carescheduling.Ui.HomeScreen.View.TodaysVisitFragment;
import com.example.carescheduling.Ui.HomeScreen.View.VisitArchiveFragment;
import com.example.carescheduling.databinding.ActivityEditProfileBinding;

public class EditProfile extends AppCompatActivity {
    private ActivityEditProfileBinding editProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile);

        if (getIntent() != null) {
            int pos = getIntent().getIntExtra("pos", 0);
            if (pos != -1) {
                setHomeFragments(pos);
            } else {
                setFragment(EditProfileStart.newInstance());
            }
        } else {
            setFragment(EditProfileStart.newInstance());
        }
    }

    private void setHomeFragments(int pos) {
        switch (pos) {
            case 0: {
                setFragment(BlankFragment.newInstance());
                break;
            }
            case 1: {
                setFragment(DirectionsFragment.newInstance());
                break;
            }
            case 2: {
                setFragment(TodaysVisitFragment.newInstance());
                break;
            }
            case 3: {
                setFragment(VisitArchiveFragment.newInstance(true));
                break;
            }
            case 4: {
                setFragment(MyTimeFragment.newInstance());
                break;
            }
            case 5: {
                setFragment(HoursAndExspenses.newInstance());
                break;
            }
        }
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {

        int fragmentCount = getSupportFragmentManager().getBackStackEntryCount();

        if (fragmentCount > 1)
            getSupportFragmentManager().popBackStack();
        else
            finish();
    }
}
