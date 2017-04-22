package com.ken.test.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ken.test.R;

import com.ken.test.bean.InfoBean;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by lenovo on 2017/4/17.
 */
public class LogActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView phone_text;
    private TextView ynf_text;
    private EditText log_pwd_text;
    private EditText log_name_text;
    private Button log_button;
    public static boolean state=false;
    public static  int userID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_layout);
        //初始化控件
        initViews();

    }

    private void initViews() {
        TextView zc= (TextView) findViewById(R.id.include_zc);
        zc.setOnClickListener(this);

        log_button = (Button) findViewById(R.id.log_button);
        ynf_text = (TextView) findViewById(R.id.log_ynf_text);
        phone_text = (TextView) findViewById(R.id.log_phone_text);

        log_pwd_text = (EditText) findViewById(R.id.log_pwd_text);
        log_name_text = (EditText) findViewById(R.id.log_name_text);


        log_button.setOnClickListener(this);
        ynf_text.setOnClickListener(this);
        phone_text.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.log_button:
                 //点击登陆进行判断
                 String name=log_name_text.getText().toString();
                 String pwd=log_pwd_text.getText().toString();
                 if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(pwd)){
                     //进行上传到服务器与后台交互
                     load(name,pwd);

                 }

            break;
            case R.id.log_ynf_text:
                ynf_text.setSelected(true);
                phone_text.setSelected(false);


                break;
            case R.id.log_phone_text:
                //设置点击变色
                ynf_text.setSelected(false);
                phone_text.setSelected(true);

                break;
            case R.id.include_zc:
                Intent in=new Intent(LogActivity.this,RegActivity.class);
                startActivityForResult(in,20);
                break;


        }
    }

    private void load(final String name, String pwd) {
        AsyncHttpClient client=new AsyncHttpClient();
        String url="http://169.254.94.62:8080/bullking1/login?name="+name+"&pwd="+pwd;
        client.get(LogActivity.this, url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(LogActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Toast.makeText(LogActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                Gson gson=new Gson();
                InfoBean bean = gson.fromJson(responseString, InfoBean.class);
                userID = bean.userID;
                if(bean.str.equals("success")){
                    state=true;
                   Intent in=new Intent();
                    in.putExtra("name",name);
                    in.putExtra("position",4);
                    in.putExtra("userID", userID);
                  LogActivity.this.setResult(10,in);

                    finish();
                }else if(bean.str.equals("fail"))
                {
                    state=false;
                    Toast.makeText(LogActivity.this, "账号密码错误", Toast.LENGTH_SHORT).show();
                }

            }
        }) ;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==20&&resultCode==30){
            if(data!=null){
              String name=data.getStringExtra("name");
              String pwd=data.getStringExtra("pwd");
               log_name_text.setText(name);
               log_pwd_text.setText(pwd);
            }
        }
    }
}
