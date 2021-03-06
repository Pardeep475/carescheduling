package css.mobile.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoNotesViewModel;
import css.mobile.carescheduling.Ui.HomeScreen.adapter.ClientNoteAdapter;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientNoteAdapterBean;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.databinding.ClientInfoNotesFragmentBinding;

import java.util.ArrayList;

public class ClientInfoNotesFragment extends BaseFragment implements Common {

    private ClientInfoNotesViewModel mViewModel;
    private ClientInfoNotesFragmentBinding clientInfoNotesFragmentBinding;

    public static ClientInfoNotesFragment newInstance() {
        return new ClientInfoNotesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        clientInfoNotesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_notes_fragment
                , container, false);
        View view = clientInfoNotesFragmentBinding.getRoot();
        setUpView(view);
        return view;

    }

    private void setUpView(View view) {
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(ClientInfoNotesViewModel.class);

        clientInfoNotesFragmentBinding.slDemo.startShimmerAnimation();
        try {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                setUpData(view);
            } else {
//                setNoDataFound();
//                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                getDataFromRoom();
            }

        } catch (Exception e) {
//            setNoDataFound();
            getDataFromRoom();
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Notes");
        clientInfoNotesFragmentBinding.setCommonData(commonBean);
        clientInfoNotesFragmentBinding.setCommonClick(this);
    }

    private void getDataFromRoom() {

        mViewModel.getDataFromLocal(getActivity(), getSessionManager().getBookingId()).observe(this, new Observer<ArrayList<ClientNoteAdapterBean>>() {
            @Override
            public void onChanged(ArrayList<ClientNoteAdapterBean> clientNoteAdapterBeans) {
                if (clientNoteAdapterBeans != null && clientNoteAdapterBeans.size() > 0) {
                    clientInfoNotesFragmentBinding.setClientNoteAdapterBean(clientNoteAdapterBeans.get(0));
//                    clientNoteAdapterBeans.remove(0);
                    clientInfoNotesFragmentBinding.rcvClientNotes.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ClientNoteAdapter clientDisabilitiesAdapter = new ClientNoteAdapter(getActivity(), clientNoteAdapterBeans);
                    clientInfoNotesFragmentBinding.rcvClientNotes.setAdapter(clientDisabilitiesAdapter);

                    setDataOriginal();
                } else {
                    setNoDataFound();
//                    getDataFromRoom();
                }
                clientInfoNotesFragmentBinding.slDemo.stopShimmerAnimation();
            }
        });
    }

    private void setUpData(View view) {
//        http://mobile.rota.services/CssMobileRestfulService.svc/GetClientNotes///
        mViewModel.getClientNotes(getSessionManager().getCustomerId(),
                getSessionManager().getBranchId(),
                getSessionManager().getClientId()).observe(this, new Observer<ArrayList<ClientNoteAdapterBean>>() {
            @Override
            public void onChanged(ArrayList<ClientNoteAdapterBean> clientNoteAdapterBeans) {

                if (clientNoteAdapterBeans != null && clientNoteAdapterBeans.size() > 0) {
                    clientInfoNotesFragmentBinding.setClientNoteAdapterBean(clientNoteAdapterBeans.get(0));
//                    clientNoteAdapterBeans.remove(0);
                    clientInfoNotesFragmentBinding.rcvClientNotes.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ClientNoteAdapter clientDisabilitiesAdapter = new ClientNoteAdapter(getActivity(), clientNoteAdapterBeans);
                    clientInfoNotesFragmentBinding.rcvClientNotes.setAdapter(clientDisabilitiesAdapter);

                    setDataOriginal();
                } else {
//                    setNoDataFound();
                    getDataFromRoom();
                }
                clientInfoNotesFragmentBinding.slDemo.stopShimmerAnimation();
            }
        });
    }

    private void setNoDataFound() {
        clientInfoNotesFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoNotesFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoNotesFragmentBinding.llMainLayout.setVisibility(View.GONE);
        clientInfoNotesFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientInfoNotesFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoNotesFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoNotesFragmentBinding.llMainLayout.setVisibility(View.VISIBLE);
        clientInfoNotesFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
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
