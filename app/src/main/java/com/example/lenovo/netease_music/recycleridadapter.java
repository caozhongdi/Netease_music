package com.example.lenovo.netease_music;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by lenovo on 2018/12/8.
 */

public class recycleridadapter extends RecyclerView.Adapter<recycleridadapter.Viewhord>implements View.OnClickListener{
    private Context context;
    private List<com.example.lenovo.netease_music.music_idbean.ResultBean.SongsBean> list;

    public recycleridadapter(Context context, List<music_idbean.ResultBean.SongsBean> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public recycleridadapter.Viewhord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_music, null);
        Viewhord viewhord = new Viewhord(inflate);
        inflate.setOnClickListener(this);
        return viewhord;
    }

    @Override
    public void onBindViewHolder(@NonNull recycleridadapter.Viewhord holder, int position) {
        for (int i = 0; i < list.size() - 1; i++) {
            String name = list.get(i).getName();
            holder.name.setText(name);
            Toast.makeText(context, ""+name, Toast.LENGTH_SHORT).show();
        }
//        music_idbean.ResultBean.SongsBean songsBean = list.get(position);
//        String name = songsBean.getName();
//        List<music_idbean.ResultBean.SongsBean.ArtistsBean> artists = songsBean.getArtists();
//            int id = artists.get(0).getId();
//            String name1 = artists.get(0).getName();
//            holder.name.setText(name1);
//            holder.albm.setText(id);
//        holder.title.setText(name);
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
        private TextView albm;
        private TextView name;
        private TextView title;

        public Viewhord(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_music_title);
            name = itemView.findViewById(R.id.item_music_singer);
            albm = itemView.findViewById(R.id.item_music_album);
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
