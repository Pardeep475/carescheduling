package css.mobile.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientNoteAdapterBean;
import css.mobile.carescheduling.Ui.HomeScreen.presenter.MoreInfoClick;
import css.mobile.carescheduling.databinding.ItemClientInfoDocumentBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ClientNoteAdapter extends RecyclerView.Adapter<ClientNoteAdapter.MyViewHolder> implements MoreInfoClick {
    private Context context;
    private ItemClientInfoDocumentBinding itemClientInfoDocumentBinding;
    private ArrayList<ClientNoteAdapterBean> dataList;

    public ClientNoteAdapter(Context context,ArrayList<ClientNoteAdapterBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemClientInfoDocumentBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_client_info_document, parent, false);
        return new MyViewHolder(itemClientInfoDocumentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        itemClientInfoDocumentBinding.setPos(position);
        itemClientInfoDocumentBinding.setClientNoteAdapterBean(dataList.get(position));
        itemClientInfoDocumentBinding.setMoreInfoClick(this);
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
        public MyViewHolder(@NonNull ItemClientInfoDocumentBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
