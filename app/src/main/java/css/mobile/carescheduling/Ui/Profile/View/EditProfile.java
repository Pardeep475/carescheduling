package css.mobile.carescheduling.Ui.Profile.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.HomeScreen.View.ArrivalAndDepartureFragment;
import css.mobile.carescheduling.Ui.HomeScreen.View.BlankFragment;
import css.mobile.carescheduling.Ui.HomeScreen.View.DirectionsFragment;
import css.mobile.carescheduling.Ui.HomeScreen.View.HoursAndExspenses;
import css.mobile.carescheduling.Ui.HomeScreen.View.MyTimeFragment;
import css.mobile.carescheduling.Ui.HomeScreen.View.TodaysVisitFragment;
import css.mobile.carescheduling.Ui.HomeScreen.View.VisitArchiveFragment;
import css.mobile.carescheduling.databinding.ActivityEditProfileBinding;

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
                addFragment(BlankFragment.newInstance());
                break;
            }
            case 1: {
//                setFragment(DirectionsFragment.newInstance());
//                setFragment(TodaysVisitFragment.newInstance());
                setFragment(VisitArchiveFragment.newInstance(false));
                break;
            }
            case 2: {
//                setFragment(TodaysVisitFragment.newInstance());
                setFragment(VisitArchiveFragment.newInstance(true));
                break;
            }
            case 3: {
//                setFragment(VisitArchiveFragment.newInstance(true));
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
                .add(R.id.fm_edit_container, fragment).addToBackStack(null).commit();
    }

    private void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fm_edit_container, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        int fragmentCount = getSupportFragmentManager().getBackStackEntryCount();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fm_edit_container);
        if (fragment instanceof ArrivalAndDepartureFragment) {
            for (int i = 0; i < fragmentCount - 1; i++) {
                Log.e("FragmentCount", "" + fragmentCount);
                getSupportFragmentManager().popBackStackImmediate();
            }
        } else if (fragmentCount > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }


    public void setOnBackPressed() {

    }

    public interface CustomOnBackPressed {
        void onBackPressedCustom();
    }
}
