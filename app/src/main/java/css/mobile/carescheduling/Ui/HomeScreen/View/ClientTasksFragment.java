package css.mobile.carescheduling.Ui.HomeScreen.View;

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

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.HomeScreen.ViewModel.ClientTasksViewModel;
import css.mobile.carescheduling.Ui.HomeScreen.adapter.ClientTasksAdapter;
import css.mobile.carescheduling.Ui.HomeScreen.beans.Tasks;
import css.mobile.carescheduling.Ui.HomeScreen.presenter.IClientTaskItemClick;
import css.mobile.carescheduling.Utils.ConnectivityReceiver;
import css.mobile.carescheduling.databinding.ClientTasksFragmentBinding;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ClientTasksFragment extends BaseFragment implements Common, IClientTaskItemClick {

    private ClientTasksViewModel mViewModel;
    private ArrayList<Tasks> tasksArrayList = new ArrayList<>();
    private Gson gson = new Gson();
    private ClientTasksFragmentBinding clientTasksFragmentBinding;
    private ClientTasksAdapter clientInfoDocumentsAdapter;
    private String type = "Not Clickable";

    public static ClientTasksFragment newInstance(String type) {
        ClientTasksFragment clientTasksFragment = new ClientTasksFragment();
        Bundle bundle = new Bundle();
        bundle.putString("TYPE", type);
        clientTasksFragment.setArguments(bundle);
        return clientTasksFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (getArguments() != null)
                type = getArguments().getString("TYPE");
        } catch (Exception e) {
            showAToast(e.toString());
        }
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

        if (getSessionManager().getClientTasks() != null || !getSessionManager().getClientTasks().equalsIgnoreCase("null")) {
            tasksArrayList = getItemArrayList();
            setReylerViewData();
        } else {
            setNoDataFound();
        }
    }


    private ArrayList<Tasks> getItemArrayList() {
        Type type = new TypeToken<ArrayList<Tasks>>() {
        }.getType();
        tasksArrayList = gson.fromJson(getSessionManager().getClientTasks(), type);
        return tasksArrayList;
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
        if (type.equalsIgnoreCase("Not Clickable"))
            return;
        setFragment(ClientTaskSaveFragment.newInstance(pos));
    }

    private void setFragment(Fragment fragment) {
        if (getActivity() != null)
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fm_edit_container, fragment).addToBackStack(null).commitAllowingStateLoss();
    }
}
