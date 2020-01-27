package css.mobile.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.TodaysVisitViewModel;
import css.mobile.carescheduling.databinding.TodaysVisitFragmentBinding;

public class TodaysVisitFragment extends BaseFragment implements Common, HomeScreenOnClick {

    private TodaysVisitViewModel mViewModel;
    private TodaysVisitFragmentBinding todaysVisitFragmentBinding;

    public static TodaysVisitFragment newInstance() {
        return new TodaysVisitFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        todaysVisitFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.todays_visit_fragment
                , container, false);
        View view = todaysVisitFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }


    private void setUpView(View view) {
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(TodaysVisitViewModel.class);

        String[] some_array = getResources().getStringArray(R.array.todays_visit_array);
        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
        todaysVisitFragmentBinding.rcvDirection.setLayoutManager(new LinearLayoutManager(getActivity()));
        todaysVisitFragmentBinding.rcvDirection.setAdapter(homeScreenAdapter);

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Today's Visit");
        todaysVisitFragmentBinding.setCommonData(commonBean);
        todaysVisitFragmentBinding.setCommonClick(this);
    }

    @Override
    public void OnClickHomeScreen(int pos) {
        if (pos == 0) {
            setFragment(BlankFragment.newInstance());
        } else if (pos == 2) {
            setFragment(VisitArchiveFragment.newInstance(false));
        }
    }


    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commit();
        }
    }
}
