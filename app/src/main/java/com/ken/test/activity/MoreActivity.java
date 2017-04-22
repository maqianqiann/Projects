package com.ken.test.activity;

import android.content.Intent;
import android.graphics.Color;
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
import com.ken.test.fragments.FragmentMore;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/4/18.
 */

public class MoreActivity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<Fragment> listf;
    private FragmentManager manager;
    private FragmentMore f1;
    private FragmentMore f2;
    private FragmentMore f3;
    private TextView text_mo;
    private TextView text_she;
    private TextView text_jia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_layout);
        //初始化控件
        initViews();

    }

    private void initViews() {
        listf=new ArrayList<>();
        ImageView im= (ImageView) findViewById(R.id.include_im);
        TextView title= (TextView) findViewById(R.id.include_title);
        findViewById(R.id.include_zc).setVisibility(View.INVISIBLE);
        title.setText("全部商品");
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent();
                MoreActivity.this.setResult(2,in);
                finish();
            }
        });

        text_mo = (TextView) findViewById(R.id.more_mo);
        text_she = (TextView) findViewById(R.id.more_she);
        text_jia = (TextView) findViewById(R.id.more_jia);
        text_mo.setOnClickListener(this);
        text_she.setOnClickListener(this);
        text_jia.setOnClickListener(this);

        for(int i=0;i<3;i++){
            FragmentMore f1=new FragmentMore();
            Bundle bundle=new Bundle();
            bundle.putInt("position",i);
            f1.setArguments(bundle);
            listf.add(f1);
        }

        manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        f1 = (FragmentMore) listf.get(0);
        f2 = (FragmentMore) listf.get(1);
        f3 = (FragmentMore) listf.get(2);
        beginTransaction.add(R.id.more_frame,listf.get(0),"tag0");
        beginTransaction.add(R.id.more_frame,listf.get(1),"tag1");
        beginTransaction.add(R.id.more_frame,listf.get(2),"tag2");
        beginTransaction.show(listf.get(0));
        beginTransaction.hide(f2);
        beginTransaction.hide(f3);
        beginTransaction.commit();

    }

    private void showAndHide(Fragment f1,Fragment f2,Fragment f3){
        FragmentTransaction bt = manager.beginTransaction();
        bt.show(f1);
        bt.hide(f2);
        bt.hide(f3);
        bt.commit();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
          case   R.id.more_mo:
                showAndHide(f1,f2,f3);
               text_mo.setTextColor(Color.RED);
              text_jia.setTextColor(Color.BLACK);
              text_she.setTextColor(Color.BLACK);
                break;
            case   R.id.more_she:
                showAndHide(f2,f1,f3);
                text_mo.setTextColor(Color.BLACK);
                text_she.setTextColor(Color.RED);
                text_jia.setTextColor(Color.BLACK);

                break;
            case   R.id.more_jia:
                showAndHide(f3,f2,f1);
                text_mo.setTextColor(Color.BLACK);
                text_she.setTextColor(Color.BLACK);
                text_jia.setTextColor(Color.RED);
                break;
        }
    }
}
