package com.example.carescheduling.Ui.HomeScreen.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseFragment;
import com.example.carescheduling.Ui.Common.Common;
import com.example.carescheduling.Ui.Common.CommonBean;
import com.example.carescheduling.Ui.HomeScreen.ViewModel.ClientTasksViewModel;
import com.example.carescheduling.Ui.HomeScreen.adapter.ClientTasksAdapter;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.Tasks;
import com.example.carescheduling.Ui.HomeScreen.presenter.IClientTaskItemClick;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.databinding.ClientTasksFragmentBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ClientTasksFragment extends BaseFragment implements Common, IClientTaskItemClick {

    private ClientTasksViewModel mViewModel;
    private ArrayList<Tasks> tasksArrayList = new ArrayList<>();
    private ClientTasksFragmentBinding clientTasksFragmentBinding;
    private Gson gson = new Gson();
    private ClientTasksAdapter clientInfoDocumentsAdapter;

    public static ClientTasksFragment newInstance() {
        return new ClientTasksFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        clientTasksFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.client_tasks_fragment, container, false);
        View view = clientTasksFragmentBinding.getRoot();
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        tasksArrayList = new ArrayList<>();
        setCommonData();
        mViewModel = ViewModelProviders.of(this).get(ClientTasksViewModel.class);
        clientTasksFragmentBinding.rcvClientTask.setVisibility(View.VISIBLE);
        clientTasksFragmentBinding.rcvClientTask.showShimmerAdapter();

        if (getSessionManager().getClientTasks() == null ||
                getSessionManager().getClientTasks().equalsIgnoreCase("null")) {
            try {
                if (ConnectivityReceiver.isNetworkAvailable(getActivity())) {
                    getClientTasks();
                } else {
                    getDataFromRoom();
//                    setNoDataFound();
//                    Toast.makeText(getActivity(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                getDataFromRoom();
//                setNoDataFound();
//                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
            }
        } else {
            tasksArrayList = getItemArrayList();
            setReylerViewData();
        }


    }


    private void getDataFromRoom() {
        mViewModel.getDataFromLocal(getActivity(), getSessionManager().getBookingId()).observe(this, new Observer<ArrayList<Tasks>>() {
            @Override
            public void onChanged(ArrayList<Tasks> clientsTasks) {
                if (clientsTasks != null) {
                    getSessionManager().setClientTasks(gson.toJson(clientsTasks));
                    tasksArrayList = clientsTasks;
                    setReylerViewData();
                } else {
                    setNoDataFound();
                }
            }
        });
    }

    private ArrayList<Tasks> getItemArrayList() {
        Type type = new TypeToken<ArrayList<Tasks>>() {
        }.getType();
        tasksArrayList = gson.fromJson(getSessionManager().getClientTasks(), type);
        return tasksArrayList;
    }

    private void getClientTasks() {

        mViewModel.getClientTasks(getSessionManager().getCustomerId(),
                getSessionManager().getBranchId(),
                getSessionManager().getClientId()).observe(this, new Observer<ArrayList<Tasks>>() {
            @Override
            public void onChanged(ArrayList<Tasks> clientsTasks) {
                if (clientsTasks != null) {
                    getSessionManager().setClientTasks(gson.toJson(clientsTasks));
                    tasksArrayList = clientsTasks;
                    setReylerViewData();
                } else {
                    getDataFromRoom();
//                    setNoDataFound();
                }
            }
        });
    }

    private void setReylerViewData() {
        clientTasksFragmentBinding.rcvClientTask.setLayoutManager(new LinearLayoutManager(getActivity()));
        clientInfoDocumentsAdapter = new ClientTasksAdapter(getActivity(), tasksArrayList, this);
        clientTasksFragmentBinding.rcvClientTask.setAdapter(clientInfoDocumentsAdapter);
        setDataOriginal();
    }

    private void setNoDataFound() {
        clientTasksFragmentBinding.rcvClientTask.hideShimmerAdapter();
        clientTasksFragmentBinding.rcvClientTask.setVisibility(View.GONE);
        clientTasksFragmentBinding.rlNoDataFound.setVisibility(View.VISIBLE);
    }

    private void setDataOriginal() {
        clientTasksFragmentBinding.rcvClientTask.hideShimmerAdapter();
        clientTasksFragmentBinding.rcvClientTask.setVisibility(View.VISIBLE);
        clientTasksFragmentBinding.rlNoDataFound.setVisibility(View.GONE);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Client Tasks");
        clientTasksFragmentBinding.setCommonData(commonBean);
        clientTasksFragmentBinding.setCommonClick(this);
    }

    @Override
    public void leftClick() {
        if (getActivity() != null)
            getActivity().onBackPressed();
    }

    @Override
    public void rightClick() {

    }

    @Override
    public void itemTaskClick(int pos, Tasks tasks) {
        if (tasks.isCompleted()) {
            tasks.setCompleted(false);
            getItemArrayList().get(pos).setCompleted(false);
        } else {
            tasks.setCompleted(true);
            getItemArrayList().get(pos).setCompleted(true);
        }
        clientInfoDocumentsAdapter.notifyItemChanged(pos, tasks);

//        clientInfoDocumentsAdapter.setData(tasksArrayList);
        getSessionManager().setClientTasks(gson.toJson(tasksArrayList));

    }
}
