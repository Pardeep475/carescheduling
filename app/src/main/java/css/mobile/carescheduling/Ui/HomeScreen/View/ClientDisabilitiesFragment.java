package css.mobile.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientDisabilityList;
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.ClientDisabilitiesViewModel;
import css.mobile.carescheduling.Ui.HomeScreen.adapter.ClientDisabilitiesAdapter;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.databinding.ClientInfoDisabilitiesFragmentBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ClientDisabilitiesFragment extends BaseFragment implements Common {
    private ClientInfoDisabilitiesFragmentBinding clientInfoDisabilitiesFragmentBinding;
    private ClientDisabilitiesViewModel clientDisabilitiesViewModel;

    public static ClientDisabilitiesFragment newInstance() {
        return new ClientDisabilitiesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        clientInfoDisabilitiesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_disabilities_fragment, container, false);
        View view = clientInfoDisabilitiesFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();

        clientDisabilitiesViewModel = ViewModelProviders.of(this).get(ClientDisabilitiesViewModel.class);

        clientInfoDisabilitiesFragmentBinding.slDemo.startShimmerAnimation();
        try {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                setUpRecyclerView(view);
            } else {
//                setNoDataFound();
                getDataFromRoom();
//                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            getDataFromRoom();
//            setNoDataFound();
//            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }


    private void getDataFromRoom() {
        clientDisabilitiesViewModel.getDataFromLocal(getActivity(), getSessionManager().getBookingId()).observe(this, new Observer<ArrayList<ClientDisabilityList>>() {
            @Override
            public void onChanged(ArrayList<ClientDisabilityList> data) {
                if (data != null && data.size() > 0) {
                    clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ClientDisabilitiesAdapter clientDisabilitiesAdapter = new ClientDisabilitiesAdapter(getActivity(), data);
                    clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setAdapter(clientDisabilitiesAdapter);
                    setDataOriginal();
                } else {
                    setNoDataFound();
                }
            }
        });
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Disabilities");
        clientInfoDisabilitiesFragmentBinding.setCommonData(commonBean);
        clientInfoDisabilitiesFragmentBinding.setCommonClick(this);
    }

    private void setUpRecyclerView(View view) {
        clientDisabilitiesViewModel.getDisabilities(getSessionManager().getCustomerId(),
                getSessionManager().getBranchId(),
                getSessionManager().getClientId()).observe(this
                , new Observer<ArrayList<ClientDisabilityList>>() {
                    @Override
                    public void onChanged(ArrayList<ClientDisabilityList> data) {
                        if (data != null && data.size() > 0) {
                            clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                            ClientDisabilitiesAdapter clientDisabilitiesAdapter = new ClientDisabilitiesAdapter(getActivity(), data);
                            clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setAdapter(clientDisabilitiesAdapter);
                            setDataOriginal();
                        } else {
                            getDataFromRoom();
                        }
                    }
                });

    }

    private void setNoDataFound() {
        clientInfoDisabilitiesFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoDisabilitiesFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setVisibility(View.GONE);
        clientInfoDisabilitiesFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientInfoDisabilitiesFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoDisabilitiesFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoDisabilitiesFragmentBinding.disabilitiesRecyclerview.setVisibility(View.VISIBLE);
        clientInfoDisabilitiesFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
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