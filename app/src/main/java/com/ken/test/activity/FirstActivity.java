package com.ken.test.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ken.test.R;
import com.ken.test.fragment.FragmentBeatiful;
import com.ken.test.fragment.FragmentCar;
import com.ken.test.fragment.FragmentMe;
import com.ken.test.fragment.FragmentShow;
import com.ken.test.fragment.FragmentStyle;

/**
 * Created by lenovo on 2017/4/13.
 */

public class FirstActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist_layout);
        //初始化控件
        initViews();
    }

    private void initViews() {
       /* ImageView message= (ImageView) findViewById(R.id.message_im_first);
        ImageView ch_im= (ImageView) findViewById(R.id.ch_im_first);*/
        frameLayout = (FrameLayout) findViewById(R.id.frame_first);

        //获得Frame的管理者
        FragmentManager fragmentManager=getSupportFragmentManager();
        //开启事物
         FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        //进行添加
        FragmentShow f_show=new FragmentShow();
        FragmentStyle f_style=new FragmentStyle();
        FragmentBeatiful f_bea=new FragmentBeatiful();
        FragmentCar f_car=new FragmentCar();
        FragmentMe f_me=new FragmentMe();
        beginTransaction.add(R.id.frame_first,f_show);
        beginTransaction.add(R.id.frame_first,f_style);
        beginTransaction.add(R.id.frame_first,f_bea);
        beginTransaction.add(R.id.frame_first,f_car);
        beginTransaction.add(R.id.frame_first,f_me);

        beginTransaction.show(f_show);
        beginTransaction.hide(f_style);
        beginTransaction.hide(f_bea);
        beginTransaction.hide(f_car);
        beginTransaction.hide(f_me);
        beginTransaction.commit();


    }
}
