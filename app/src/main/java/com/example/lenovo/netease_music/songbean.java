package com.example.lenovo.netease_music;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/12/4.
 */

public class songbean implements Serializable {
    String title;
    String singer;
    String album;
    String time;
    String path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public songbean() {
    }

    public songbean(String title, String singer, String album, String time, String path) {
        this.title = title;
        this.singer = singer;
        this.album = album;
        this.time = time;
        this.path = path;
    }
}
