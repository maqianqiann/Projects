package com.ken.test.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
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
    private int position;
    public static String name;
    private RadioButton show;
    private RadioButton lei;
    private RadioButton good;
    private RadioButton car;
    private RadioButton my;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist_layout);
        Intent intent = getIntent();
        position = intent.getIntExtra("car",0);

        //初始化控件
        initViews();
    }

    private void initViews() {
       /* ImageView message= (ImageView) findViewById(R.id.message_im_first);
        ImageView ch_im= (ImageView) findViewById(R.id.ch_im_first);*/
        frameLayout = (FrameLayout) findViewById(R.id.frame_first);

        show = (RadioButton) findViewById(R.id.home_page);
        lei = (RadioButton) findViewById(R.id.classify);
        good = (RadioButton) findViewById(R.id.good);
        car = (RadioButton) findViewById(R.id.shop);
        my = (RadioButton) findViewById(R.id.my);


        show.setOnClickListener(this);
        lei.setOnClickListener(this);
        good.setOnClickListener(this);
        car.setOnClickListener(this);
        my.setOnClickListener(this);
         show.setSelected(true);



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

        //判断car的数字
        if(position==3){
            showAndHide(f_car,f_bea,f_me,f_style,f_show);
        }else if (position==4){
            showAndHide(f_me,f_show,f_style,f_bea,f_car);
        }

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
            case R.id.home_page:
                showAndHide(f_show,f_style,f_bea,f_car,f_me);
                show.setSelected(true);
                lei.setSelected(false);
                good.setSelected(false);
                car.setSelected(false);
                my.setSelected(false);



                break;
            case R.id.classify:
                showAndHide(f_style,f_show,f_bea,f_car,f_me);
                show.setSelected(false);
                lei.setSelected(true);
                good.setSelected(false);
                car.setSelected(false);
                my.setSelected(false);
                break;
            case R.id.good:
                showAndHide(f_bea,f_show,f_style,f_car,f_me);
                show.setSelected(false);
                lei.setSelected(false);
                good.setSelected(true);
                car.setSelected(false);
                my.setSelected(false);
                break;
            case R.id.shop:
                //判断登陆的状态
                boolean state = LogActivity.state;
                if(!state){
                    Intent in=new Intent(FirstActivity.this,LogActivity.class);
                    startActivity(in);

                }
                showAndHide(f_car,f_show,f_style,f_bea,f_me);
                car.setSelected(true);
                lei.setSelected(false);
                good.setSelected(false);
                show.setSelected(false);
                my.setSelected(false);
                break;
            case R.id.my:
                showAndHide(f_me,f_show,f_style,f_bea,f_car);
                my.setSelected(true);
                lei.setSelected(false);
                good.setSelected(false);
                car.setSelected(false);
                show.setSelected(false);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0&&resultCode==10){
            name = data.getStringExtra("name");
        }
    }
}
