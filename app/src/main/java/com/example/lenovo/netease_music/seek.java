package com.example.lenovo.netease_music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.util.List;
// https://music.163.com/song/media/outer/url?id=11127.mp3  169.254.36.244
// http://169.254.36.244/song/url?id=33894312   http://192.168.191.1:3000/song/url?id=400162138

public class seek extends AppCompatActivity {
    private int id;
    private EditText et;
    private RecyclerView recyclerView;
    private List<music_idbean.ResultBean.SongsBean> songs;
    private MediaPlayer playle;
    private String url;
    private int i = 0;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        playle = Musicbean.getInstance();
        et = (EditText) findViewById(R.id.et);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        txt = (TextView) findViewById(R.id.ttt);
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sos:
                Editable text = et.getText();
                String s = text.toString();
                Log.d("flag","edtext="+s);
                String path = "http://localhost:3000/song/url11127"+s;
                xUituHttp("http://192.168.191.1:3000/search?keywords="+s);
                xUituHttp2("http://192.168.191.1:3000/song/url?id="+id);//3555142  http://192.168.191.1:3000/lyric?id=22732885
                okhttp("http://192.168.191.1:3000/lyric?id="+id);
                //创建Retrofit的实列 http://192.168.191.1:3000/song/url?id=11127 http://localhost:3000/search?keywords=%E6%B5%B7%E9%98%94%E5%A4%A9%E7%A9%BA http://localhost:3000/comment/music?id=186016&limit=1
                //https://192.168.191.1:3000/song/media/outer/url?id=11127.mp3 https://music.163.com/song/media/outer/url?id=id.mp3
//                Retrofit retrofit= new Retrofit.Builder()
//                        .baseUrl("http://192.168.191.1:3000/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                JavaBeanServes javaBeanServes = retrofit.create(JavaBeanServes.class);//这里采用的是Java的动态代理模式
//                Call<music_idbean> resuit = javaBeanServes.getResuit();
//                resuit.enqueue(new retrofit2.Callback<music_idbean>() {
//                    @Override
//                    public void onResponse(Call<music_idbean> call, Response<music_idbean> response) {
//                        Toast.makeText(seek.this, response.toString()+"11111111", Toast.LENGTH_SHORT).show();
//                        List<music_idbean.ResultBean.SongsBean> songs = response.body().getResult().getSongs();
//                        int id = songs.get(0).getId();
//                        Toast.makeText(seek.this, id+" ", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<music_idbean> call, Throwable t) {
//                        Toast.makeText(seek.this, "2222222222", Toast.LENGTH_SHORT).show();
//                    }
//                });


                break;
//            recyclerView.setLayoutManager(new LinearLayoutManager(getApplication(),LinearLayoutManager.VERTICAL,false));
//            recyclerView.setAdapter(new recycleridadapter(this,songs));
        }
    }

    private void okhttp(String path) {
        RequestParams requestParams = new RequestParams(path);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                lyricbean lyricbean = gson.fromJson(result, lyricbean.class);
                String lyric = lyricbean.getLrc().getLyric();
                txt.setText(lyric);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void xUituHttp(String path) {
        Log.d("flag","xh111111="+path);
        RequestParams requestParams = new RequestParams(path);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                music_idbean music_idbean = gson.fromJson(result, music_idbean.class);
                id = music_idbean.getResult().getSongs().get(1).getId();
                //id= music_idbean.getResult().getSongs().get(0).getArtists().get(0).getId();
                boolean flag = false;

                if (i == 2){
                    List<com.example.lenovo.netease_music.music_idbean.ResultBean.SongsBean> songs = music_idbean.getResult().getSongs();
//                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplication(),LinearLayoutManager.VERTICAL,false));
//                    recyclerView.setAdapter(new recycleridadapter(getApplication(),songs));
                }
                    i++;
                Log.d("flag","id="+id);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
    }
    private void xUituHttp2(String path) {
        Log.d("flag","xh222222="+path);
        RequestParams requestParams = new RequestParams(path);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                mpbean mpbean = gson.fromJson(result, mpbean.class);
                url = mpbean.getData().get(0).getUrl();
                Log.d("flag","url="+url);
                Toast.makeText(seek.this, "uri   "+url, Toast.LENGTH_SHORT).show();
                try {
                    playle.reset();
                    if (playle != null && playle.isPlaying()) {
                        playle.pause();
                        playle.stop();
                    }
                    playle.setDataSource(url);
                    if (playle != null && !playle.isPlaying()) {
                        playle.prepare();
                        playle.start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
