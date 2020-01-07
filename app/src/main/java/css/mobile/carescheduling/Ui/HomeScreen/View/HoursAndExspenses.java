package css.mobile.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.Dashboard.Adapter.HomeScreenAdapter;
import css.mobile.carescheduling.Ui.Dashboard.presenter.HomeScreenOnClick;
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.HoursAndExspensesViewModel;
import css.mobile.carescheduling.databinding.HoursAndExspensesFragmentBinding;

public class HoursAndExspenses extends BaseFragment implements Common, HomeScreenOnClick {

    private HoursAndExspensesViewModel mViewModel;
    private HoursAndExspensesFragmentBinding hoursAndExspensesFragmentBinding;

    public static HoursAndExspenses newInstance() {
        return new HoursAndExspenses();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        hoursAndExspensesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.hours_and_exspenses_fragment
                , container, false);
        View view = hoursAndExspensesFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(HoursAndExspensesViewModel.class);

        String[] some_array = getResources().getStringArray(R.array.hours_and_exspenses_array);
        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
        hoursAndExspensesFragmentBinding.rcvDirection.setLayoutManager(new LinearLayoutManager(getActivity()));
        hoursAndExspensesFragmentBinding.rcvDirection.setAdapter(homeScreenAdapter);

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Hours and Expenses");
        hoursAndExspensesFragmentBinding.setCommonData(commonBean);
        hoursAndExspensesFragmentBinding.setCommonClick(this);
    }

    @Override
    public void OnClickHomeScreen(int pos) {

    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }
}
