package css.mobile.carescheduling.Ui.HomeScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientMedicalBeanAdapter;
import css.mobile.carescheduling.databinding.ItemClientInfoMedicationBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ClientInfoMedicationAdapter extends RecyclerView.Adapter<ClientInfoMedicationAdapter.MyViewHolder> {
    private Context context;
    private ItemClientInfoMedicationBinding itemClientInfoMedicationBinding;
    private ArrayList<ClientMedicalBeanAdapter> clientMedicalBeanAdapters;

    public ClientInfoMedicationAdapter(Context context, ArrayList<ClientMedicalBeanAdapter> clientMedicalBeanAdapters) {
        this.context = context;
        this.clientMedicalBeanAdapters = clientMedicalBeanAdapters;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemClientInfoMedicationBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_client_info_medication, parent, false);
        return new MyViewHolder(itemClientInfoMedicationBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        itemClientInfoMedicationBinding.setClientMedicalBeanAdapter(clientMedicalBeanAdapters.get(position));
    }

    @Override
    public int getItemCount() {
        return clientMedicalBeanAdapters.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull ItemClientInfoMedicationBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
