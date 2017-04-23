package com.ken.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ken.test.R;
import com.ken.test.bean.AddressBean;
import com.ken.test.utils.MyCallBack;
import com.ken.test.utils.OkHttpUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by lenovo on 2017/4/23.
 */

public class AddressActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText person;
    private EditText phone;
    private EditText xaddress;
    private EditText saddress;
    private ListView listView;
    private MyAdapter adapter;
    private RelativeLayout rel1;
    private RelativeLayout rel2;
    private TextView save;
    private TextView title_in;
    private Button add_new;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_layout);
        //初始化控件
        initViews();
    }

    private void initViews() {
        rel1 = (RelativeLayout) findViewById(R.id.address_re1);
        rel2 = (RelativeLayout) findViewById(R.id.address_re2);
        save = (TextView) findViewById(R.id.include_zc);
        title_in = (TextView) findViewById(R.id.include_title);
        listView = (ListView) findViewById(R.id.address_list);
        add_new = (Button) findViewById(R.id.address_new_add);//新增按钮
        title_in.setText("新增收货地址");
        save.setText("保存");
        save.setOnClickListener(this);
        //设置显示和隐藏
        person = (EditText) findViewById(R.id.address_person);
        phone = (EditText) findViewById(R.id.address_phone);
        xaddress = (EditText) findViewById(R.id.address_x);
        saddress = (EditText) findViewById(R.id.address_s);
        setAdapterMethod();    //调用设置适配器的方法


    }
    //调用设置适配器的方法
    private void setAdapterMethod() {
        List<AddressBean.DataBean> datas = getDatas();
        if(datas!=null){
            rel1.setVisibility(View.INVISIBLE);
            rel2.setVisibility(View.VISIBLE);
            save.setText("管理");
            title_in.setText("选择收货地址");
            //设置适配器
            adapter = new MyAdapter(datas);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            //对新增地址进行添加数据
            add_new.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //显示第一个布局第二个布局进行隐藏
                    rel1.setVisibility(View.VISIBLE);
                    rel2.setVisibility(View.INVISIBLE);
                }
            });
         }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAdapterMethod();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.include_zc:
                //将注册的信息发送给后台，与后台交互
                String per_s = person.getText().toString();
                String pho_s = phone.getText().toString();
                String xadd_s = xaddress.getText().toString();
                String sadd_s = saddress.getText().toString();
               if(!TextUtils.isEmpty(per_s)){
                    sendDatas(per_s,pho_s,xadd_s,sadd_s);
                   Toast.makeText(this, "加了", Toast.LENGTH_SHORT).show();
                    Intent in=new Intent();
                    in.putExtra("address",xadd_s);
                    this.setResult(11,in);
                    finish();
                }
                break;
        }
    }
    public void sendDatas(String per_s, String pho_s, String xadd_s, String sadd_s){
      String url="http://169.254.94.62:8080/bullking1/save?name="+per_s+"&phoneNumber="+pho_s+"&fixedtel="+sadd_s+"&provinceId="+sadd_s+"&cityId="+sadd_s+"&areaId="+sadd_s+"&areaDetail="+xadd_s+"&zipCode="+64;
       OkHttpUtils.getOkHttpObject(url, new MyCallBack() {
            @Override
            public void Ok(String s) {

            }
        });

    }
    //写个数据库查询的方法
    private List<AddressBean.DataBean> getDatas(){
        final List<AddressBean.DataBean> list=new ArrayList<>();
        String url="http://169.254.94.62:8080/bullking1/addressdefault?zipCode=64";
        OkHttpUtils.getOkHttpObject(url, new MyCallBack() {
            @Override
            public void Ok(String s) {
                Log.i("saves",s);
                Gson gson=new Gson();
                AddressBean bean = gson.fromJson(s, AddressBean.class);
                //进行适配
                List<AddressBean.DataBean> beanList = bean.getData();
                for (AddressBean.DataBean ab:beanList) {
                    list.add(ab);
                }
            }
        });
        return list;
    }
    private class MyAdapter extends BaseAdapter{
        List<AddressBean.DataBean> datas;
        public MyAdapter(List<AddressBean.DataBean> datas) {
            this.datas=datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
          convertView=View.inflate(AddressActivity.this,R.layout.add_list,null);
            TextView address_list = (TextView) convertView.findViewById(R.id.add_list_address);
            TextView phone_list = (TextView) convertView.findViewById(R.id.add_list_phone);
            TextView title_list = (TextView) convertView.findViewById(R.id.add_list_title);
            //设置数据
            title_list.setText(datas.get(position).getName());
            address_list.setText(datas.get(position).getAreaDetail());
            phone_list.setText("手机："+datas.get(position).getPhoneNumber());

            return convertView;
        }
    }
}
