package com.example.lenovo.netease_music.frament;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.netease_music.R;
import com.example.lenovo.netease_music.rvadapter;
import com.oragee.banners.BannerView;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/12/12.
 */

public class f1 extends Fragment{
    private BannerView banner;
    private int[] ints;
    private int[] ints1;
    private ArrayList list = new ArrayList<ImageView>();
    private ArrayList list2 = new ArrayList<Drawable>();
    private RecyclerView rv;
    @Nullable
    @Override    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.f1, null);
        banner = inflate.findViewById(R.id.banner);
        rv = inflate.findViewById(R.id.rv);
        ints = new int[]{R.drawable.aa, R.drawable.bb, R.drawable.cc};
        for (int i = 0; i < ints.length; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(ints[i]);
            list.add(imageView);
        }
        banner.setViewList(list);
        banner.startLoop(true);
        ints1 = new int[]{R.drawable.jinri,R.drawable.shilian,R.drawable.guyun,R.drawable.su,R.drawable.hulu,R.drawable.dongman,};
        list2.add(R.drawable.jinri);
        list2.add(R.drawable.shilian);
        list2.add(R.drawable.guyun);
        list2.add(R.drawable.su);
        list2.add(R.drawable.hulu);
        list2.add(R.drawable.dongman);
//        for (int i = 0; i < ints1.length; i++) {
//            ImageView imageView = new ImageView(getContext());
//            imageView.setBackgroundResource(ints1[i]);
//            list2.add(imageView);
//        }
        StaggeredGridLayoutManager staggered=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        rv.setLayoutManager(staggered);
        rv.setAdapter(new rvadapter(getActivity(),list2));
        return inflate;
    }
}
