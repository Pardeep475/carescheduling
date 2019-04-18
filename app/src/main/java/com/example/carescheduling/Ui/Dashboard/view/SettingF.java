package com.example.carescheduling.Ui.Dashboard.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carescheduling.R;
import com.example.carescheduling.databinding.FragmentSettingBinding;

public class SettingF extends Fragment {

  private FragmentSettingBinding fragmentSettingBinding;
    // TODO: Rename and change types and number of parameters
    public static SettingF newInstance() {

        return new SettingF();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSettingBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_setting
                ,container,false);
        View view = fragmentSettingBinding.getRoot();
        return view;
    }
}
