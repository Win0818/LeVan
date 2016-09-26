package com.qianft.m.levan.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.qianft.m.levan.R;
import com.qianft.m.levan.fragment.DiscoverFragment;
import com.qianft.m.levan.fragment.HomeFragment;
import com.qianft.m.levan.fragment.LifeFragment;
import com.qianft.m.levan.fragment.MoreFragment;
import com.qianft.m.levan.fragment.MyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int MAX_FRAGMENT_COUNT = 5;
    private ArrayList<Fragment> fragments;
    private FragmentManager mFragmentManager;
    private Fragment[] mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        BadgeItem numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColor(Color.RED)
                .setText("5")
                .setHideOnSelect(true);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "首页").setActiveColorResource(R.color.red))
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "生活").setActiveColorResource(R.color.red))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "发现").setActiveColorResource(R.color.red))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "我的").setActiveColorResource(R.color.red))
                .addItem(new BottomNavigationItem(R.mipmap.ic_videogame_asset_white_24dp, "更多").setActiveColorResource(R.color.red))
                .setFirstSelectedPosition(0)
                .initialise();
        mFragmentManager =  getSupportFragmentManager();
        mFragments = new Fragment[MAX_FRAGMENT_COUNT];
       // fragments = getFragments();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    private  void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mFragments[0] = HomeFragment.newInstance("首页");
        transaction.add(R.id.lay_frame,mFragments[0]);
        transaction.commit();
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("首页"));
        fragments.add(LifeFragment.newInstance("生活"));
        fragments.add(DiscoverFragment.newInstance("发现"));
        fragments.add(MyFragment.newInstance("我的"));
        fragments.add(MoreFragment.newInstance("更多"));
        return fragments;
    }

    @Override
    public void onTabSelected(int position) {
        Log.i("Wing", "onTabSelected position:  "  + position);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (position) {
            case 0:
                if (mFragments[0] == null) {
                    mFragments[0] = HomeFragment.newInstance("首页");
                    transaction.add(R.id.lay_frame, mFragments[0]);
                } else {
                    transaction.show(mFragments[0]);
                }
                break;
            case 1:
                if (mFragments[1] == null) {
                    mFragments[1] = LifeFragment.newInstance("生活");
                    transaction.add(R.id.lay_frame, mFragments[1]);
                } else {
                    transaction.show(mFragments[1]);
                }
                break;
            case 2:
                if (mFragments[2] == null) {
                    mFragments[2] = DiscoverFragment.newInstance("发现");
                    transaction.add(R.id.lay_frame, mFragments[2]);
                } else {
                    transaction.show(mFragments[2]);
                }
                break;
            case 3:
                if (mFragments[3] == null) {
                    mFragments[3] = MyFragment.newInstance("我的");
                    transaction.add(R.id.lay_frame, mFragments[3]);
                } else {
                    transaction.show(mFragments[3]);
                }
                break;
            case 4:
                if (mFragments[4] == null) {
                    mFragments[4] = MoreFragment.newInstance("更多");
                    transaction.add(R.id.lay_frame, mFragments[4]);
                } else {
                    transaction.show(mFragments[4]);
                }
                break;

        }
        transaction.commitAllowingStateLoss();
        /*if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    transaction.replace(R.id.lay_frame, fragment);
                } else {
                    transaction.add(R.id.lay_frame, fragment);
                }
                transaction.commitAllowingStateLoss();
            }
        }*/
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mFragments != null) {
            for (int i = 0; i < mFragments.length; i++) {
                if (mFragments[i] != null) {
                    transaction.hide(mFragments[i]);
                }
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
        Log.i("Wing", "onTabUnselected position:  "  + position);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        /*if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                Fragment fragment = fragments.get(position);
                transaction.hide(fragment);
               // transaction.remove(fragment);
                transaction.commitAllowingStateLoss();
            }
        }*/
    }

    @Override
    public void onTabReselected(int position) {

    }
}
