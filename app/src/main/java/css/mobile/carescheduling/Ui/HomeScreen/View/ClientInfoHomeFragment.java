package css.mobile.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.Dashboard.Adapter.HomeScreenAdapter;
import css.mobile.carescheduling.Ui.Dashboard.presenter.HomeScreenOnClick;
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoHomeFragmentViewModel;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import css.mobile.carescheduling.databinding.ClientInfoHomeFragmentBinding;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ClientInfoHomeFragment extends BaseFragment implements Common, HomeScreenOnClick {

    private ClientInfoHomeFragmentBinding clientInfoHomeFragmentBinding;
    private ClientInfoHomeFragmentViewModel clientInfoHomeFragmentViewModel;
private ClientBookingScreenModel clientBookingModel;

    public static ClientInfoHomeFragment newInstance(ClientBookingScreenModel clientBookingModel) {
        ClientInfoHomeFragment clientInfoHomeFragment = new ClientInfoHomeFragment();
        Bundle bundle= new Bundle();
        bundle.putSerializable("DATA",(Serializable) clientBookingModel);
        clientInfoHomeFragment.setArguments(bundle);
        return clientInfoHomeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            clientBookingModel = (ClientBookingScreenModel) getArguments().getSerializable("DATA");
        }
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
        setCommonData();
        setUpRecyclerView(view);

        clientInfoHomeFragmentViewModel = ViewModelProviders.of(this).get(ClientInfoHomeFragmentViewModel.class);

    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Client Info");
        clientInfoHomeFragmentBinding.setCommonData(commonBean);
        clientInfoHomeFragmentBinding.setCommonClick(this);
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
        switch (pos) {
            case 0: {
                setFragment(ClientInfoSummaryFragment.newInstance(clientBookingModel));
                break;
            }
            case 1: {
                setFragment(ClientInfoPersonalDetails.newInstance());
                break;
            }
            case 2: {
                setFragment(ClientInfoNotesFragment.newInstance());
                break;
            }
            case 3: {
                setFragment(ClientContactsFragment.newInstance());
                break;
            }
            case 4: {
                setFragment(ClientInfoDocuments.newInstance());
                break;
            }
            case 5: {
                setFragment(ClientInfoMedical.newInstance());
                break;
            }
            case 6: {
//                setFragment(ClientInfoMatchingHistoryFragment.newInstance());
                setFragment(ClientDisabilitiesFragment.newInstance());
                break;
            }
            case 7: {
//                setFragment(ClientDisabilitiesFragment.newInstance());
                setFragment(CarePlanFragment.newInstance());
                break;
            }
            case 8: {
//                setFragment(CarePlanFragment.newInstance());
                break;
            }

        }
    }


    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.fm_edit_container, fragment).addToBackStack(null).commit();
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
