package com.example.carescheduling.Ui.HomeScreen.View;

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

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Dashboard.Adapter.HomeScreenAdapter;
import com.example.carescheduling.Ui.Dashboard.presenter.HomeScreenOnClick;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.HoursAndExspensesViewModel;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.MyTimeViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.MyTimeClick;
import com.example.carescheduling.databinding.MyTimeFragmentBinding;

public class MyTimeFragment extends Fragment implements HomeScreenOnClick, MyTimeClick {

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
        mViewModel = ViewModelProviders.of(this).get(MyTimeViewModel.class);

        String[] some_array = getResources().getStringArray(R.array.my_time_array);
        HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
        myTimeFragmentBinding.rcvDirection.setLayoutManager(new LinearLayoutManager(getActivity()));
        myTimeFragmentBinding.rcvDirection.setAdapter(homeScreenAdapter);
        myTimeFragmentBinding.setMyTimeClick(this);
    }


    @Override
    public void OnClickHomeScreen(int pos) {

    }

    @Override
    public void onBackPress() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }
}