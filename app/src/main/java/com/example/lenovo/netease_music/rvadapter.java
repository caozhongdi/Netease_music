package com.example.lenovo.netease_music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/12/12.
 */

public class rvadapter extends RecyclerView.Adapter<rvadapter.Viewhord>{
    private Context context;
    private ArrayList<DrawerLayout> list;
    private ArrayList<String> slist = new ArrayList<>();

    public rvadapter(Context context, ArrayList<DrawerLayout> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public rvadapter.Viewhord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        Viewhord viewhord = new Viewhord(inflate);
        slist.add("你的独家品味推荐");
        slist.add("失恋解药");
        slist.add("古韵");
        slist.add("苏到没朋友！最撩男神音集锦");
        slist.add("了解一下？40首伤感唯美古风");
        slist.add("B站古风来袭，傲视天下");
        return viewhord;
    }

    @Override
    public void onBindViewHolder(@NonNull rvadapter.Viewhord holder, int position) {
         Glide.with(context).load(list.get(position)).into(holder.img);
        holder.txt.setText(slist.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewhord extends RecyclerView.ViewHolder {
        private TextView txt;
        private ImageView img;

        public Viewhord(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_img);
            txt = itemView.findViewById(R.id.item_txt);
        }
    }

}
