package com.example.lenovo.netease_music;

import android.media.MediaPlayer;

/**
 * Created by lenovo on 2018/12/3.
 */

public class Musicbean {
    private static MediaPlayer mediaPlayer = null;
    public static  synchronized MediaPlayer getInstance(){
        if (mediaPlayer == null){
            mediaPlayer = new MediaPlayer();
            return mediaPlayer;
        }
        return mediaPlayer;
    }
//    private  Musicbean(){}
//    private static final MediaPlayer player = new MediaPlayer();
//    private static MediaPlayer getplayer(){
//        return player;
//    }
}
