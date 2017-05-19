package com.ken.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.ken.test.R;

/**
 * Created by lenovo on 2017/4/24.
 */

public class SureDingActivity extends AppCompatActivity {

    private Button button;
    private String order;
    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sure_ding_layout);
        Intent intent = getIntent();
        order = intent.getStringExtra("order");
        name = intent.getStringExtra("name");
        CheckBox ch= (CheckBox) findViewById(R.id.sure_cb1);
        button = (Button) findViewById(R.id.button_sure_zhi);
        //设置点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //进行支付逻辑
               Intent in=new Intent(SureDingActivity.this,PayDemoActivity.class);
                in.putExtra("order", order);
                in.putExtra("name",name);
               startActivity(in);//跳转到支付界面
            }
        });
    }
}
