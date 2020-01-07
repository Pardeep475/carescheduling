package css.mobile.carescheduling.Ui.Dashboard.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.Dashboard.ViewModel.ProfileResultViewModel;
import css.mobile.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import css.mobile.carescheduling.Ui.Dashboard.presenter.EditProfileClickHandler;
import css.mobile.carescheduling.Ui.LoginActivity.View.LoginActivity;
import css.mobile.carescheduling.Ui.Profile.View.EditProfile;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.data.Local.SessionManager;
import css.mobile.carescheduling.databinding.FragmentProfileResultBinding;

public class ProfileResult extends BaseFragment implements Common, EditProfileClickHandler {

    private FragmentProfileResultBinding fragmentProfileResultBinding;
    private ProfileResultViewModel profileResultViewModel;
    private View view;
    private SessionManager sessionManager;

    public static ProfileResult newInstance() {
        return new ProfileResult();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentProfileResultBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_result, container, false);
        view = fragmentProfileResultBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        sessionManager = getSessionManager();
        profileResultViewModel = ViewModelProviders.of(this).get(ProfileResultViewModel.class);
        fragmentProfileResultBinding.slDemo.startShimmerAnimation();
        try {
            fetchPersonDetails();
        } catch (Exception e) {
            setNoDataFound();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        fragmentProfileResultBinding.setEditClickHandler(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(false);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(true);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Profile");
        fragmentProfileResultBinding.setCommonData(commonBean);
        fragmentProfileResultBinding.setCommonClick(this);
    }

    private void fetchPersonDetails() {
        if (getActivity() != null) {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                try {
                    profileResultViewModel.getClientData(sessionManager.getPersonId(), sessionManager.getCustomerId(), sessionManager.getBranchId())
                            .observe(this, new Observer<ProfileResultBean>() {
                                @Override
                                public void onChanged(ProfileResultBean profileResultBean) {
                                    if (profileResultBean != null) {
                                        fragmentProfileResultBinding.setProfileEditBean(profileResultBean);
                                        setDataOriginal();
                                    } else {
                                        setNoDataFound();
                                    }
                                }
                            });

                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
                    hideDialog();
                }
            } else {
                profileResultViewModel.getDataFromLocal(getActivity()).observe(this, new Observer<ProfileResultBean>() {
                    @Override
                    public void onChanged(ProfileResultBean profileResultBean) {
                        if (profileResultBean != null) {
                            fragmentProfileResultBinding.setProfileEditBean(profileResultBean);
                            setDataOriginal();
                        } else {
                            Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                            setNoDataFound();
                        }
                    }
                });

            }
        }
    }



    private void setNoDataFound() {
        fragmentProfileResultBinding.slDemo.stopShimmerAnimation();
        fragmentProfileResultBinding.slDemo.setVisibility(View.GONE);
        fragmentProfileResultBinding.svProfileResult.setVisibility(View.GONE);
        fragmentProfileResultBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        fragmentProfileResultBinding.slDemo.stopShimmerAnimation();
        fragmentProfileResultBinding.slDemo.setVisibility(View.GONE);
        fragmentProfileResultBinding.svProfileResult.setVisibility(View.VISIBLE);
        fragmentProfileResultBinding.rlNoDataFound.setVisibility(View.GONE);
    }

    @Override
    public void EditBtnClick() {
        Intent intent = new Intent(getActivity(), EditProfile.class);
        intent.putExtra("pos", -1);
        startActivity(intent);
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
