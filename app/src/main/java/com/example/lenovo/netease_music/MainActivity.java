package com.example.lenovo.netease_music;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.oragee.banners.BannerView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    private ArrayList list = new ArrayList<ImageView>();
    private RecyclerView recyclerView;
    private ArrayList<songbean> mDatas = new ArrayList<>();
    private MediaPlayer Player;
    private int id;
    private int currentPosition;//当前音乐播放的进度
    private boolean isSeekBarChanging;//互斥变量，防止进度条与定时器冲突。
    private boolean flage = true;
    private SeekBar seekBar;
    private Timer timer;
    private ImageView img;
    private boolean a = true;
    private TextView t1;
    private TextView title;
    private TextView singer;
    private Toolbar toobar;
    private BannerView banner;
    private int[] ints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        toobar = (Toolbar) findViewById(R.id.toobar);
        banner = (BannerView) findViewById(R.id.banner);
        ints = new int[]{R.drawable.aa, R.drawable.bb, R.drawable.cc};
        for (int i = 0; i < ints.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ints[i]);
            list.add(imageView);
        }
        banner.setViewList(list);
        banner.startLoop(true);
        setSupportActionBar(toobar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Player = Musicbean.getInstance();
        loadData();
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        img = (ImageView) findViewById(R.id.img);
        t1 = (TextView) findViewById(R.id.t1);
        title = (TextView) findViewById(R.id.item_music_title);
        singer = (TextView) findViewById(R.id.item_music_singer);
        seekBar = (SeekBar) findViewById(R.id.playSeekBar);
        seekBar.setOnSeekBarChangeListener(new MySeekBar());
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerAdapter recyclerAdapter = new recyclerAdapter(this, mDatas);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setItemClickListener(new recyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                id = position;
                title.setText(mDatas.get(position).getTitle());
                singer.setText(mDatas.get(position).getSinger());
                    final String path = mDatas.get(position).getPath();
                    try {
                        Player.reset();
                        if (Player != null && Player.isPlaying()) {
                            Player.pause();
                            Player.stop();
                        }
                        Player.setDataSource(path);
                        if (Player != null && !Player.isPlaying()) {
                            Player.prepare();
                            seekbar(Player);
                            //Player.start();

                            //Player.setLooping(true);//循环播放
                            //列表循环播放
                            Player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    if (flage==true){
                                        try {
                                            flage =false;
                                            if (id == mDatas.size()-1&&t1.getText().equals("列表循环")){
                                                id=0;
                                            }else if (t1.getText().equals("列表循环")){
                                                id+=1;
                                            }else {
                                                Player.setLooping(true);
                                            }
                                            title.setText(mDatas.get(id).getTitle());
                                            singer.setText(mDatas.get(id).getSinger());
                                            Toast.makeText(MainActivity.this, id+"", Toast.LENGTH_SHORT).show();
                                            String path1 = mDatas.get(id).getPath();
                                            mediaPlayer.reset();
                                            mediaPlayer.setDataSource(path1);
                                            mediaPlayer.prepareAsync();
                                            seekbar(mediaPlayer);
                                            //Player.start();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            });
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        });

    }
    private void seekbar(final MediaPlayer Player){
        Player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                mediaPlayer.seekTo(currentPosition);
                seekBar.setMax(Player.getDuration());
                flage=true;
            }
        });
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(Player.getCurrentPosition());
            }
        },0,50);
    }
    private void loadData() {
//        加载本地sd卡当中的音乐
//        1.获取ContentResolver
        ContentResolver resolver = getContentResolver();
//        2.定义URI对象
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//        3.开始查询数据
        Cursor cursor = resolver.query(uri, null, null, null, null);
//        4.遍历Cursor
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
            String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
            long l = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
            String time = dateFormat.format(new Date(l));
            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));//路径
            songbean bean = new songbean(title, singer, album, time, path);
            mDatas.add(bean);
        }
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img:
                if (a == false){
                    img.setImageResource(R.drawable.e);
                    Player.start();
                    a = true;
                }else if (a == true){
                    Player.pause();
                    img.setImageResource(R.drawable.b);
                    a = false;
                }
                break;
            case R.id.t1:
                if (t1.getText().equals("列表循环")){
                    t1.setText("单曲循环");
                }else if (t1.getText().equals("单曲循环")){
                    t1.setText("列表循环");
                }
            case R.id.bt1:
                Intent intent = new Intent(this, seek.class);
                startActivity(intent);
                break;
            case R.id.rl:
                Intent intent1 = new Intent(this, Lyric.class);
                startActivity(intent1);
                break;
        }  
    }

    public class MySeekBar implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            isSeekBarChanging = true;

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            isSeekBarChanging = false;
            Player.seekTo(seekBar.getProgress());
        }
    }
    }
