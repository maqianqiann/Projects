package com.ken.test.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ken.test.R;
import com.ken.test.fragment.FragmentBeatiful;
import com.ken.test.fragment.FragmentCar;
import com.ken.test.fragment.FragmentMe;
import com.ken.test.fragment.FragmentShow;
import com.ken.test.fragment.FragmentStyle;

/**
 * Created by lenovo on 2017/4/13.
 */

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    private FragmentShow f_show;
    private FragmentStyle f_style;
    private FragmentBeatiful f_bea;
    private FragmentCar f_car;
    private FragmentMe f_me;

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
        TextView car = (TextView) findViewById(R.id.ca);
        TextView s = (TextView) findViewById(R.id.s);
        TextView m = (TextView) findViewById(R.id.m);
        TextView f = (TextView) findViewById(R.id.f);
        TextView wo = (TextView) findViewById(R.id.w);
        car.setOnClickListener(this);
        s.setOnClickListener(this);
        m.setOnClickListener(this);
        f.setOnClickListener(this);
        wo.setOnClickListener(this);




        //获得Frame的管理者
        fragmentManager = getSupportFragmentManager();
        //开启事物
         FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        //进行添加
        f_show = new FragmentShow();
        f_style = new FragmentStyle();
        f_bea = new FragmentBeatiful();
        f_car = new FragmentCar();
        f_me = new FragmentMe();
        beginTransaction.add(R.id.frame_first, f_show);
        beginTransaction.add(R.id.frame_first, f_style);
        beginTransaction.add(R.id.frame_first, f_bea);
        beginTransaction.add(R.id.frame_first, f_car);
        beginTransaction.add(R.id.frame_first, f_me);

        beginTransaction.show(f_show);
        beginTransaction.hide(f_style);
        beginTransaction.hide(f_bea);
        beginTransaction.hide(f_car);
        beginTransaction.hide(f_me);
        beginTransaction.commit();


    }
    //写个方法控制显示和隐藏
    public void showAndHide(Fragment f1,Fragment f2,Fragment f3,Fragment f4,Fragment f5){
        final FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.show(f1);
        beginTransaction.hide(f2);
        beginTransaction.hide(f3);
        beginTransaction.hide(f4);
        beginTransaction.hide(f5);
        beginTransaction.commit();

      }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.s:
                showAndHide(f_show,f_style,f_bea,f_car,f_me);
                break;
            case R.id.f:
                showAndHide(f_style,f_show,f_bea,f_car,f_me);

                break;
            case R.id.m:
                showAndHide(f_bea,f_show,f_style,f_car,f_me);

                break;
            case R.id.ca:
                showAndHide(f_car,f_show,f_style,f_bea,f_me);

                break;
            case R.id.w:
                showAndHide(f_me,f_show,f_style,f_bea,f_car);

                break;
        }
    }
}
