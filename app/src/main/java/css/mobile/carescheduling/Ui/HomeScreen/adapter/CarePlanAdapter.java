package css.mobile.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ScheduleClients;
import css.mobile.carescheduling.Ui.HomeScreen.presenter.CarePlanAdapterClick;
import css.mobile.carescheduling.databinding.HomeCarePlanSubitemsBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CarePlanAdapter extends RecyclerView.Adapter<CarePlanAdapter.MyViewHolder> {
    private Context context;
    private HomeCarePlanSubitemsBinding homeCarePlanSubitemsBinding;
    private ArrayList<ScheduleClients> data;
    private CarePlanAdapterClick carePlanAdapterClick;

    public CarePlanAdapter(Context context, CarePlanAdapterClick carePlanAdapterClick) {
        this.context = context;
        this.carePlanAdapterClick = carePlanAdapterClick;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        homeCarePlanSubitemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.home_care_plan_subitems, parent, false);
        return new MyViewHolder(homeCarePlanSubitemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ScheduleClients dataList1 = data.get(position);

//        setLayoutDynamic(homeCarePlanSubitemsBinding.llClientPlan, dataList1);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull HomeCarePlanSubitemsBinding itemView) {
            super(itemView.getRoot());
        }
    }


}