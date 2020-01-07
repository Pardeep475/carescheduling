package css.mobile.carescheduling.Ui.Dashboard.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.Dashboard.Adapter.HomeScreenAdapter;
import css.mobile.carescheduling.Ui.Dashboard.ViewModel.HomeFViewModel;

import css.mobile.carescheduling.Ui.Dashboard.presenter.HomeScreenOnClick;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCarePlan;
import css.mobile.carescheduling.Ui.LoginActivity.View.LoginActivity;
import css.mobile.carescheduling.Ui.Profile.View.EditProfile;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.data.Local.DatabaseTable.ProfileInfo;
import css.mobile.carescheduling.data.Local.DatabaseTable.ProfileMainData;
import css.mobile.carescheduling.data.Local.DatabaseTable.UserInfo;
import css.mobile.carescheduling.databinding.FragmentHomeBinding;

public class HomeF extends BaseFragment implements Common, HomeScreenOnClick {
    private FragmentHomeBinding fragmentHomeBinding;
    private HomeFViewModel homeFViewModel;

    // TODO: Rename and change types and number of parameters
    public static HomeF newInstance() {
        return new HomeF();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home
                , container, false);
        View view = fragmentHomeBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        homeFViewModel = ViewModelProviders.of(this).get(HomeFViewModel.class);
        /*try {
            GetClientPlan();
        } catch (Exception e) {
            hideDialog();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }*/
        sessionManager = getSessionManager();
        String[] some_array = getResources().getStringArray(R.array.home_array);
        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
        fragmentHomeBinding.rcvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentHomeBinding.rcvHome.setAdapter(homeScreenAdapter);
        getProfileLocalData();
    }


    private void getProfileLocalData() {
        AppDataBase.getAppDatabase(getActivity()).profileDao().getAllProfileMainData().observe(this, new Observer<ProfileMainData>() {
            @Override
            public void onChanged(ProfileMainData profileMainData) {
                if (profileMainData != null)
                    Log.e("getting_profile_data", profileMainData.getEmail());
            }
        });
        AppDataBase.getAppDatabase(getActivity()).profileDao().getAllProfileInfo().observe(this, new Observer<ProfileInfo>() {
            @Override
            public void onChanged(ProfileInfo profileInfo) {
                if (profileInfo != null)
                    Log.e("getting_profile_data", profileInfo.getFirstName());
            }
        });
//        AppDataBase.getAppDatabase(getActivity()).profileDao().getAllAddressAllData().observe(this, new Observer<AddressAllData>() {
//            @Override
//            public void onChanged(AddressAllData addressAllData) {
//                if (addressAllData != null)
//                    Log.e("getting_profile_data", addressAllData.getPersonAddressList().size() + " ");
//            }
//        });
        AppDataBase.getAppDatabase(getActivity()).profileDao().getAllUserInfo().observe(this, new Observer<UserInfo>() {
            @Override
            public void onChanged(UserInfo userInfo) {
                if (userInfo != null)
                    Log.e("getting_profile_data", userInfo.getPasswordQuestion());
            }
        });
    }


    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(false);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(true);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Home");
        fragmentHomeBinding.setCommonData(commonBean);
        fragmentHomeBinding.setCommonClick(this);
    }

    @Override
    public void OnClickHomeScreen(int pos) {

        Intent intent = new Intent(getActivity(), EditProfile.class);
        intent.putExtra("pos", pos);
        startActivity(intent);
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }


    @Override
    public void leftClick() {

    }

    @Override
    public void rightClick() {
        if (getActivity() != null) {
            sessionManager.cleanAllData();
            AppDataBase.getAppDatabase(getActivity()).clearAllTables();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK  );
            startActivity(intent);
            getActivity().finish();
        }
    }
}
