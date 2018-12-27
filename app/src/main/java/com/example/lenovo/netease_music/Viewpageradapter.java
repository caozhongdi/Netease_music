package com.example.lenovo.netease_music;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/12/12.
 */

public class Viewpageradapter extends FragmentPagerAdapter {
    private ArrayList<String> list;
    private ArrayList<Fragment> framents;

    public Viewpageradapter(FragmentManager fm, ArrayList<String> list, ArrayList<Fragment> framents) {
        super(fm);
        this.list = list;
        this.framents = framents;
    }

    @Override
    public Fragment getItem(int position) {
        return framents.get(position);
    }

    @Override
    public int getCount() {
        return framents.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}