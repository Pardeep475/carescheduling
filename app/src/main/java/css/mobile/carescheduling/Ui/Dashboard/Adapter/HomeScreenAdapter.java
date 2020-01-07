package css.mobile.carescheduling.Ui.Dashboard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import css.mobile.carescheduling.R;
import css.mobile.carescheduling.Ui.Dashboard.presenter.HomeScreenOnClick;
import css.mobile.carescheduling.databinding.ItemHomeRcvBinding;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class HomeScreenAdapter extends RecyclerView.Adapter<HomeScreenAdapter.MyViewHolder> {
    private ItemHomeRcvBinding homeRcvBinding;
    private Context context;
    private HomeScreenOnClick homeScreenOnClick;
    private String[] strings;
    private LayoutInflater layoutInflater;

    public HomeScreenAdapter(Context context, HomeScreenOnClick homeScreenOnClick, String[] strings) {
        this.context = context;
        this.homeScreenOnClick = homeScreenOnClick;
        this.strings = strings;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        homeRcvBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_home_rcv, parent, false);
        return new MyViewHolder(homeRcvBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        homeRcvBinding.setHomeScreenOnClick(homeScreenOnClick);
        homeRcvBinding.setItem(strings[position]);
        homeRcvBinding.setPos(position);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull ItemHomeRcvBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
