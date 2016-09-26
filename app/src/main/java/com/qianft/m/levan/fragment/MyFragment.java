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
 * Created by Administrator on 2016/9/20.
 */
public class MyFragment  extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView tv = (TextView) getActivity().findViewById(R.id.tv_my);
        tv.setText(getArguments().getString("ARGS"));
    }

    public static MyFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putSerializable("ARGS", content);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
