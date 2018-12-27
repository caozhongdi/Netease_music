package com.example.lenovo.netease_music;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.netease_music.frament.f1;
import com.example.lenovo.netease_music.frament.f2;
import com.example.lenovo.netease_music.frament.f3;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ViewPager vp;
    private ArrayList<Fragment> framentlist = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    private TabLayout tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tb = (TabLayout) findViewById(R.id.tb);
        vp = (ViewPager) findViewById(R.id.vp);

        list.add("我的");
        list.add("音乐馆");
        list.add("发现");

        framentlist.add(new f1());
        framentlist.add(new f2());
        framentlist.add(new f3());

        for (int i = 0; i <= list.size()-1; i++) {
            tb.addTab(tb.newTab().setText(list.get(i)));
        }
        tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                vp.setCurrentItem(position,true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Viewpageradapter viewpagerAdapter = new Viewpageradapter(getSupportFragmentManager(), list, framentlist);
        vp.setAdapter(viewpagerAdapter);
    }
}
