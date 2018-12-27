package com.example.lenovo.netease_music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by lenovo on 2018/12/7.
 */

public class heraer extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heraer);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt1:
                Toast.makeText(this, "22222222222222222222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b:
                Toast.makeText(this, "3333333333333", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
