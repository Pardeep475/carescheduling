package css.mobile.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientDisabilityList;
import css.mobile.carescheduling.Ui.HomeScreen.presenter.MoreInfoClick;
import css.mobile.carescheduling.databinding.ItemsClientInfoDisabilitiesBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ClientDisabilitiesAdapter extends RecyclerView.Adapter<ClientDisabilitiesAdapter.MyViewHolder> implements MoreInfoClick {
    private Context context;
    private ItemsClientInfoDisabilitiesBinding itemsClientInfoDisabilitiesBinding;
    private ArrayList<ClientDisabilityList> dataList;

    public ClientDisabilitiesAdapter(Context context, ArrayList<ClientDisabilityList> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemsClientInfoDisabilitiesBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.items_client_info_disabilities, parent, false);
        return new MyViewHolder(itemsClientInfoDisabilitiesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        itemsClientInfoDisabilitiesBinding.setPos(position);
        itemsClientInfoDisabilitiesBinding.setClientDisabilityBean(dataList.get(position));
        itemsClientInfoDisabilitiesBinding.setMoreInfoClick(this);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void moreInfoClick(int pos) {
        Toast.makeText(context, pos, Toast.LENGTH_SHORT).show();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull ItemsClientInfoDisabilitiesBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
