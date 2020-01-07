package css.mobile.carescheduling.Ui.Dashboard.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.LoginActivity.View.LoginActivity;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.databinding.FragmentSettingBinding;

public class SettingF extends BaseFragment implements Common {

    private FragmentSettingBinding fragmentSettingBinding;

    // TODO: Rename and change types and number of parameters
    public static SettingF newInstance() {

        return new SettingF();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSettingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting
                , container, false);
        View view = fragmentSettingBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        sessionManager = getSessionManager();

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(false);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(true);
        commonBean.setTitle("Settings");
        commonBean.setRightTextVisible(false);
        fragmentSettingBinding.setCommonData(commonBean);
        fragmentSettingBinding.setCommonClick(this);
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
