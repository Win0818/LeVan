package com.qianft.m.levan.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qianft.m.levan.R;
import com.qianft.m.levan.view.SlideShowView;

/**
 * Created by Administrator on 2016/9/20.
 */
public class HomeFragment extends Fragment{

    private SlideShowView mSlideShowView;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        Context context = new ContextThemeWrapper(getActivity(), R.style.ImageTranslucentTheme);
        LayoutInflater localInflater = inflater.cloneInContext(context);
        View view = localInflater.inflate(R.layout.fragment_home, container, false);

       // TextView tv = (TextView) view.findViewById(R.id.tv_home);
        //tv.setText("qqqqqqq" + getArguments().getString("ARGS"));

        String[] imageUrls = {"http://img0.imgtn.bdimg.com/it/u=4087866388,590061000&fm=21&gp=0.jpg",
                "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1212/25/c0/16875142_1356415699831.jpg",
                "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1212/25/c0/16875142_1356415699827.jpg",
                "http://attimg.dospy.com/img/day_140825/20140825_206ace20a2932eb6748d7L7kk7MrkYmu.jpg",
                "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1212/25/c0/16875142_1356415699833.jpg"};
        mSlideShowView= (com.qianft.m.levan.view.SlideShowView) view.findViewById(R.id.sv_photo);
        mSlideShowView.setView(imageUrls);
        return view;
    }

    /*@Override
    public void onActivityCreated( Bundle savedInstanceState ) {
        super.onActivityCreated(savedInstanceState);
    }*/

    public static HomeFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putSerializable("ARGS", content);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
