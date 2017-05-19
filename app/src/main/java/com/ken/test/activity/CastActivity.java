package com.ken.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ken.test.R;
import com.ken.test.bean.DingBean;
import com.ken.test.bean.YuDingBean;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by lenovo on 2017/4/21.
 */

public class CastActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<DingBean> list;
    private int number=1;
    private TextView address;
    private Button button_sure;
    private String order_sn;
    private String names;
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
        button_sure = (Button) findViewById(R.id.button_sure);
        button_sure.setOnClickListener(this);
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
            case R.id.button_sure:
                //设置
               postDatas();
                break;
        }

    }
    //第一次与后台交互
    private void postDatas() {
        //进行与后台交互，将参数封装到post方法中进行与后台交互，生成预支付订单的信息返回
        AsyncHttpClient client=new AsyncHttpClient();
        String url="http://lexue365.51dangao.cn/api/order/add_order";
        client.addHeader("userid",465+"");
        client.addHeader("cltid", "1");
        client.addHeader("token", "bbb6e99c4cd22930ea4c945d9932f98a");
        client.addHeader("mobile", "15718812708");

        RequestParams params = new RequestParams();
        params.put("activity_id",4);
        params.put("time_id",2927);
        params.put("child_num",1);

        params.put("contact",list.get(0).title);
        params.put("mobile","15718812708");
        params.put("remark",1);
        client.post(getApplicationContext(), url, params, new TextHttpResponseHandler() {

           @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.i("xxx",responseString);
                Gson gson=new Gson();
                YuDingBean bean = gson.fromJson(responseString, YuDingBean.class);
                //拿到订单号
                order_sn = bean.getData().getOrder_sn();
                names = bean.getData().getGoods_name();
            }
        });
        Intent in=new Intent(CastActivity.this,SureDingActivity.class);
        in.putExtra("order",order_sn);
        in.putExtra("name",names);
        startActivity(in);//跳转到选择支付方式的界面


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
