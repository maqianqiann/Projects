package com.ken.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ken.test.R;
import com.ken.test.bean.DingBean;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/4/21.
 */

public class CastActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<DingBean> list;
    private int number=1;
    private TextView address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhi_main);
        Intent intent = getIntent();
        list = (ArrayList<DingBean>) intent.getSerializableExtra("listd");
        //初始化界面
        initViews();

    }

    private void initViews() {
       ImageView dw_im= (ImageView) findViewById(R.id.zhi_dw);
       final ImageView fan_im= (ImageView) findViewById(R.id.zhi_fan);
        dw_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(CastActivity.this,BaiMapActivity.class);
                startActivity(in);
            }
        });
        fan_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //找到控件
        ListView lv= (ListView) findViewById(R.id.zhi_lv);
        //找到地址的控件
        address = (TextView) findViewById(R.id.zhi_address);
        address.setOnClickListener(this);

        //获得数据
        lv.setAdapter(new MyAdapter(list));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.zhi_address:
              //进行跳转到地址的界面
                Intent in=new Intent(CastActivity.this,AddressActivity.class);
                startActivityForResult(in,111);
                break;
        }

    }

    private class MyAdapter extends BaseAdapter{
       ArrayList<DingBean> list;
    public MyAdapter(ArrayList<DingBean> list) {
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      convertView=View.inflate(CastActivity.this,R.layout.dingdan_layout,null);
        TextView title= (TextView) convertView.findViewById(R.id.z_name);
        Button jia= (Button) convertView.findViewById(R.id.z_jia);
        Button jian= (Button) convertView.findViewById(R.id.z_jian);
        final TextView num= (TextView) convertView.findViewById(R.id.z_num);
        TextView price= (TextView) convertView.findViewById(R.id.z_pirce);
        ImageView pic= (ImageView) convertView.findViewById(R.id.z_pic);

        title.setText(list.get(position).title);
        price.setText(list.get(position).price+"￥");
        Glide.with(CastActivity.this).load(list.get(position).im).into(pic);
        //设置点击事件
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number>0){
                    number--;
                    num.setText(number+"");
                }
            }
        });
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                num.setText(number+"");
            }
        });

        return convertView;
    }
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         if(data!=null){
             if(requestCode==111&&resultCode==11){
                 String add = data.getStringExtra("address");
                 address.setText(add);
             }
         }
    }
}
