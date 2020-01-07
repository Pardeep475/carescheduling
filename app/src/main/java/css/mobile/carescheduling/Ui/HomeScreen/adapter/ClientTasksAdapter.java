package css.mobile.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.HomeScreen.beans.Tasks;
import css.mobile.carescheduling.Ui.HomeScreen.presenter.IClientTaskItemClick;
import css.mobile.carescheduling.databinding.ItemTasksBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ClientTasksAdapter extends RecyclerView.Adapter<ClientTasksAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Tasks> tasksArrayList;
    private IClientTaskItemClick iClientTaskItemClick;

    public ClientTasksAdapter(Context context, ArrayList<Tasks> tasksArrayList, IClientTaskItemClick iClientTaskItemClick) {
        this.context = context;
        this.tasksArrayList = tasksArrayList;
        this.iClientTaskItemClick = iClientTaskItemClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tasks, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tasks tasks = tasksArrayList.get(position);
        holder.txt_title.setText(tasks.getTaskName());
        holder.txt_visit_day.setText(tasks.getVisitShiftName());
        holder.txt_visit_time.setText(tasks.getVisitTiming());
        holder.txt_visit_inst.setText(tasks.getInstruction());
        if (tasks.isCompleted()) {
            holder.cv_main.setCardBackgroundColor(context.getResources().getColor(R.color.blue));
        } else {
            holder.cv_main.setCardBackgroundColor(context.getResources().getColor(R.color.white));
        }

    }

    @Override
    public int getItemCount() {
        return tasksArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_title, txt_visit_day, txt_visit_time, txt_visit_inst;
        private CardView cv_main;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_visit_day = itemView.findViewById(R.id.txt_visit_day);
            txt_visit_time = itemView.findViewById(R.id.txt_visit_time);
            txt_visit_inst = itemView.findViewById(R.id.txt_visit_inst);
            cv_main = itemView.findViewById(R.id.cv_main);
            cv_main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iClientTaskItemClick.itemTaskClick(getAdapterPosition(), tasksArrayList.get(getAdapterPosition()));
                }
            });
        }

    }

    public void setData(ArrayList<Tasks> tasksArrayList){
        this.tasksArrayList = tasksArrayList;
        notifyDataSetChanged();
    }

}
