package com.ma.fragmentproject.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class QuickFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         模拟数据
         */
        TextView textView = new TextView(getContext());
        textView.setText(getClass().getSimpleName());
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(19);
        return textView;
    }
}
