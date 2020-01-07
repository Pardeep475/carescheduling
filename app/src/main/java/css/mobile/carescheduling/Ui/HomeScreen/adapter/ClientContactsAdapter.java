package css.mobile.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientContactsBean;
import css.mobile.carescheduling.Ui.HomeScreen.presenter.MoreInfoClick;
import css.mobile.carescheduling.databinding.ItemClientContactsAdapterBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ClientContactsAdapter extends RecyclerView.Adapter<ClientContactsAdapter.MyViewHolder> implements MoreInfoClick {
    private Context context;
    private ItemClientContactsAdapterBinding itemClientContactsAdapterBinding;
    private ArrayList<ClientContactsBean> dataList;

    public ClientContactsAdapter(Context context,ArrayList<ClientContactsBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemClientContactsAdapterBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_client_contacts_adapter, parent, false);
        return new MyViewHolder(itemClientContactsAdapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        itemClientContactsAdapterBinding.setMoreInfoClick(this);
        itemClientContactsAdapterBinding.setClientContactsBean(dataList.get(position));
        itemClientContactsAdapterBinding.setMoreInfoClick(this);
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
        public MyViewHolder(@NonNull ItemClientContactsAdapterBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
