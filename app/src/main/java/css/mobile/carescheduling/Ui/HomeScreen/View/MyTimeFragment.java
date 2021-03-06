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
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.MyTimeViewModel;
import css.mobile.carescheduling.databinding.MyTimeFragmentBinding;

public class MyTimeFragment extends BaseFragment implements Common, HomeScreenOnClick {

    private MyTimeViewModel mViewModel;
    private MyTimeFragmentBinding myTimeFragmentBinding;

    public static MyTimeFragment newInstance() {
        return new MyTimeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        myTimeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.my_time_fragment
                , container, false);
        View view = myTimeFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(MyTimeViewModel.class);

        String[] some_array = getResources().getStringArray(R.array.my_time_array);
        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
        myTimeFragmentBinding.rcvDirection.setLayoutManager(new LinearLayoutManager(getActivity()));
        myTimeFragmentBinding.rcvDirection.setAdapter(homeScreenAdapter);

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("My Time");
        myTimeFragmentBinding.setCommonData(commonBean);
        myTimeFragmentBinding.setCommonClick(this);
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
