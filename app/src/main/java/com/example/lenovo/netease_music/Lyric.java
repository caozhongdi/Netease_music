package com.example.lenovo.netease_music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.xutils.http.RequestParams;

public class Lyric extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric);
        okhttp();
    }

    private void okhttp() {
        RequestParams requestParams = new RequestParams();
    }
}
