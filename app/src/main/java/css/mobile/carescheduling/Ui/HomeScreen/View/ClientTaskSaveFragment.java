package css.mobile.carescheduling.Ui.HomeScreen.View;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Base.BaseFragment;
import css.mobile.carescheduling.Ui.Common.Common;
import css.mobile.carescheduling.Ui.Common.CommonBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.Tasks;
import css.mobile.carescheduling.Ui.HomeScreen.presenter.IClientTaskSaveNote;
import css.mobile.carescheduling.databinding.ClientTaskSaveNoteBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ClientTaskSaveFragment extends BaseFragment implements Common, IClientTaskSaveNote {

    private ClientTaskSaveNoteBinding clientTaskSaveNoteBinding;
    private int position = 0;
    private ArrayList<Tasks> tasksArrayList = new ArrayList<>();
    private Gson gson = new Gson();

    public static ClientTaskSaveFragment newInstance(int position) {
        ClientTaskSaveFragment clientTaskSaveFragment = new ClientTaskSaveFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("POSITION", position);
        clientTaskSaveFragment.setArguments(bundle);
        return clientTaskSaveFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (getArguments() != null)
                position = getArguments().getInt("POSITION");
        } catch (Exception e) {
            showAToast(e.toString());
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        clientTaskSaveNoteBinding = DataBindingUtil.inflate(inflater, R.layout.client_task_save_note, container, false);
        return clientTaskSaveNoteBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setCommonData();
        setUpData();
        clientTaskSaveNoteBinding.setIclientTaskSaveNote(this);
    }

    private void setCommonData() {
        CommonBean commonBean = new CommonBean();
        commonBean.setLeftImageDrawable(R.drawable.ic_left_back);
        commonBean.setLeftImageVisible(true);
        commonBean.setRightImageDrawable(R.drawable.ic_logout);
        commonBean.setRightImageVisible(false);
        commonBean.setRightTextVisible(false);
        commonBean.setTitle("Client Tasks");
        clientTaskSaveNoteBinding.setCommonData(commonBean);
        clientTaskSaveNoteBinding.setCommonClick(this);
    }

    private void setUpData() {
        tasksArrayList = getItemArrayList();
        if (tasksArrayList.size() > position) {
            Tasks tasks = tasksArrayList.get(position);
            if (tasks == null)
                return;
            if (tasks.getTaskName() != null)
                clientTaskSaveNoteBinding.txtClientTask.setText(tasks.getTaskName());
            if (tasks.getInstruction() != null)
                clientTaskSaveNoteBinding.txtInstructions.setText(tasks.getInstruction());
            clientTaskSaveNoteBinding.simpleSwitch.setChecked(tasks.isCompleted());

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

    @Override
    public void clientTaskCompleted() {

        if (TextUtils.isEmpty(clientTaskSaveNoteBinding.txtNote.getText().toString())) {
            showAToast("Please add note");
            return;
        }

        tasksArrayList = getItemArrayList();
        if (tasksArrayList.size() > position) {
            Tasks tasks = tasksArrayList.get(position);
            if (tasks == null)
                return;

            tasks.setNote(clientTaskSaveNoteBinding.txtNote.getText().toString());
            tasks.setCompleted(clientTaskSaveNoteBinding.simpleSwitch.isChecked());
            tasksArrayList.get(position).setCompleted(clientTaskSaveNoteBinding.simpleSwitch.isChecked());
            tasksArrayList.get(position).setNote(clientTaskSaveNoteBinding.txtNote.getText().toString());
//            tasksArrayList.add(position,tasks);

            getSessionManager().setClientTasks(gson.toJson(tasksArrayList));
            leftClick();
        }

    }

    private ArrayList<Tasks> getItemArrayList() {
        Type type = new TypeToken<ArrayList<Tasks>>() {
        }.getType();
        tasksArrayList = gson.fromJson(getSessionManager().getClientTasks(), type);
        return tasksArrayList;
    }


}
