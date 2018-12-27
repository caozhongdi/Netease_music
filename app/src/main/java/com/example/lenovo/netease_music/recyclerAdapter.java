package com.example.lenovo.netease_music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/12/4.
 */

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.Viewhord> implements View.OnClickListener{
    private Context context;
    private ArrayList<songbean> list;

    public recyclerAdapter(Context context, ArrayList<songbean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public recyclerAdapter.Viewhord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_music, null);
        Viewhord viewhord = new Viewhord(inflate);
        inflate.setOnClickListener(this);
        return viewhord;
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.Viewhord holder, int position) {
        songbean songbean = list.get(position);
        holder.titleTv.setText(songbean.getTitle());
        holder.timeTv.setText(songbean.getTime());
        holder.albumTv.setText(songbean.getAlbum());
        holder.singerTv.setText(songbean.getSinger());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        if (mItemClickListener!=null){
            mItemClickListener.onItemClick((Integer) view.getTag());
        }
    }

    public class Viewhord extends RecyclerView.ViewHolder {
        TextView titleTv,singerTv,albumTv,timeTv;
        public Viewhord(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.item_music_title);
            singerTv = (TextView) itemView.findViewById(R.id.item_music_singer);
            albumTv = (TextView) itemView.findViewById(R.id.item_music_album);
            timeTv = (TextView) itemView.findViewById(R.id.item_music_time);
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    private recyclerAdapter.OnItemClickListener mItemClickListener;

    public void setItemClickListener(recyclerAdapter.OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
