package css.mobile.carescheduling.Ui.Profile.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import css.mobile.carescheduling.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class CustomAdapter extends ArrayAdapter<String> {

    LayoutInflater flater;

    public CustomAdapter(Activity context, int resouceId, int textviewId, ArrayList<String> list) {

        super(context, resouceId, textviewId, list);
        flater = context.getLayoutInflater();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,@NonNull ViewGroup parent) {

        String rowItem = getItem(position);

        View rowview = flater.inflate(R.layout.item_spinner_sf, null, true);

        TextView txtTitle = (TextView) rowview.findViewById(R.id.title);
        txtTitle.setText(rowItem);

        ImageView imageView = (ImageView) rowview.findViewById(R.id.icon);
//        imageView.setImageResource(rowItem.getImageId());

        return rowview;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = flater.inflate(R.layout.item_spinner_sf, parent, false);
        }
       String rwItem = getItem(position);
        TextView txtTitle = convertView.findViewById(R.id.title);
        txtTitle.setText(rwItem);
        return convertView;
    }
}
