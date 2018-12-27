package com.example.lenovo.netease_music;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2018/12/8.
 */

public interface JavaBeanServes {
    @GET("search?keywords=海阔天空")
    Call<music_idbean> getResuit();
}

