package com.ken.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.ken.test.R;

/**
 * Created by lenovo on 2017/4/21.
 */

public class CastActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhi_main);
        //初始化界面
        initViews();

    }

    private void initViews() {
       ImageView dw_im= (ImageView) findViewById(R.id.zhi_dw);
       ImageView fan_im= (ImageView) findViewById(R.id.zhi_fan);


    }

    public void getMap(){


    }
}
