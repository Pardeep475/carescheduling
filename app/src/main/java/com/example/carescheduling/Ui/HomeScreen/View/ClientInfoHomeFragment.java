package com.example.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Dashboard.Adapter.HomeScreenAdapter;
import com.example.carescheduling.Ui.Dashboard.presenter.HomeScreenOnClick;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoHomeFragmentViewModel;
import com.example.carescheduling.Ui.HomeScreen.presenter.ClientInfoHomeClick;
import com.example.carescheduling.databinding.ClientInfoHomeFragmentBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ClientInfoHomeFragment extends BaseFragment implements HomeScreenOnClick, ClientInfoHomeClick {

    private ClientInfoHomeFragmentBinding clientInfoHomeFragmentBinding;
    private ClientInfoHomeFragmentViewModel clientInfoHomeFragmentViewModel;

    public static ClientInfoHomeFragment newInstance() {
        return new ClientInfoHomeFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        clientInfoHomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_home_fragment, container, false);
        View view = clientInfoHomeFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {

        setUpRecyclerView(view);

        clientInfoHomeFragmentViewModel = ViewModelProviders.of(this).get(ClientInfoHomeFragmentViewModel.class);
        clientInfoHomeFragmentBinding.setClientInfoHomeClick(this);
    }

    private void setUpRecyclerView(View view) {
        if (getActivity() != null) {
            clientInfoHomeFragmentBinding.clientInfoHomeRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
            String[] some_array = getResources().getStringArray(R.array.client_info_home_array);
            HomeScreenAdapter homeScreenAdapter = new HomeScreenAdapter(getActivity(), this, some_array);
            clientInfoHomeFragmentBinding.clientInfoHomeRecyclerview.setAdapter(homeScreenAdapter);
        }
    }

    @Override
    public void OnClickHomeScreen(int pos) {
        switch(pos){
            case 0:{
                setFragment(ClientInfoSummaryFragment.newInstance());
                break;
            }
            case 1:{
                setFragment(ClientInfoPersonalDetails.newInstance());
                break;
            }
            case 2:{
                setFragment(ClientInfoNotesFragment.newInstance());
                break;
            }
            case 3:{
                setFragment(ClientContactsFragment.newInstance());
                break;
            }
            case 4:{
                setFragment(ClientInfoDocuments.newInstance());
                break;
            }
            case 5:{
                setFragment(ClientInfoMedical.newInstance());
                break;
            }
            case 6:{
//                setFragment(ClientInfoMatchingHistoryFragment.newInstance());
                setFragment(ClientDisabilitiesFragment.newInstance());
                break;
            }
            case 7:{
//                setFragment(ClientDisabilitiesFragment.newInstance());
                setFragment(CarePlanFragment.newInstance());
                break;
            }
            case 8:{
//                setFragment(CarePlanFragment.newInstance());
                break;
            }

        }
        Toast.makeText(getActivity(), ""+pos, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPress() {
        if (getActivity()!=null)
            getActivity().onBackPressed();
    }
    private void setFragment(Fragment fragment) {
        if (getActivity()!=null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }
}
