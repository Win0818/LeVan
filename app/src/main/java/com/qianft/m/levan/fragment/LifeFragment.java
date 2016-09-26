package com.qianft.m.levan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qianft.m.levan.R;

/**
 * Created by wuyong on 2016/9/20.
 */
public class LifeFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_life, container, false);
        TextView tv = (TextView) view.findViewById(R.id.tv_life);
        tv.setText(getArguments().getString("ARGS"));
        return view;
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }*/

    public static LifeFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putSerializable("ARGS", content);
        LifeFragment fragment = new LifeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
