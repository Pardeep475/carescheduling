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

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.ClientInfoDocumentsViewModel;
import css.mobile.carescheduling.Ui.HomeScreen.adapter.ClientInfoDocumentsAdapter;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientNoteAdapterBean;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.databinding.ClientInfoDocumentsFragmentBinding;

import java.util.ArrayList;

public class ClientInfoDocuments extends BaseFragment implements Common {

    private ClientInfoDocumentsViewModel mViewModel;
    private ClientInfoDocumentsFragmentBinding clientInfoDocumentsFragmentBinding;

    public static ClientInfoDocuments newInstance() {
        return new ClientInfoDocuments();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        clientInfoDocumentsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_info_documents_fragment, container, false);
        View view = clientInfoDocumentsFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(ClientInfoDocumentsViewModel.class);

        clientInfoDocumentsFragmentBinding.slDemo.startShimmerAnimation();
        try {
            if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                setUpRecyclerView(view);
            } else {
                getDataFromRoom();
//                setNoDataFound();
//                Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            getDataFromRoom();
//            setNoDataFound();
//            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }
    private void getDataFromRoom() {
        mViewModel.getDataFromLocal(getActivity(), getSessionManager().getBookingId()).observe(this, new Observer<ArrayList<ClientNoteAdapterBean>>() {
            @Override
            public void onChanged(ArrayList<ClientNoteAdapterBean> clientNoteAdapterBeans) {
                if (clientNoteAdapterBeans != null && clientNoteAdapterBeans.size() > 0) {
                    clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ClientInfoDocumentsAdapter clientInfoDocumentsAdapter = new ClientInfoDocumentsAdapter(getActivity(), clientNoteAdapterBeans);
                    clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setAdapter(clientInfoDocumentsAdapter);
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
        commonBean.setTitle("Documents");
        clientInfoDocumentsFragmentBinding.setCommonData(commonBean);
        clientInfoDocumentsFragmentBinding.setCommonClick(this);
    }

    private void setUpRecyclerView(View view) {

//        //

        mViewModel.getClientDocument(getSessionManager().getCustomerId(),
                getSessionManager().getBranchId(),
                getSessionManager().getClientId()).observe(this, new Observer<ArrayList<ClientNoteAdapterBean>>() {
            @Override
            public void onChanged(ArrayList<ClientNoteAdapterBean> clientNoteAdapterBeans) {
                if (clientNoteAdapterBeans != null && clientNoteAdapterBeans.size() > 0) {
                    clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setLayoutManager(new LinearLayoutManager(getActivity()));
                    ClientInfoDocumentsAdapter clientInfoDocumentsAdapter = new ClientInfoDocumentsAdapter(getActivity(), clientNoteAdapterBeans);
                    clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setAdapter(clientInfoDocumentsAdapter);
                    setDataOriginal();
                } else {
                    getDataFromRoom();
//                    setNoDataFound();
                }
            }
        });

    }


    private void setNoDataFound() {
        clientInfoDocumentsFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoDocumentsFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setVisibility(View.GONE);
        clientInfoDocumentsFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientInfoDocumentsFragmentBinding.slDemo.stopShimmerAnimation();
        clientInfoDocumentsFragmentBinding.slDemo.setVisibility(View.GONE);
        clientInfoDocumentsFragmentBinding.rcvClientInfoDocuments.setVisibility(View.VISIBLE);
        clientInfoDocumentsFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
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
