package com.ken.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ken.test.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by lenovo on 2017/4/20.
 */

public class RegActivity extends AppCompatActivity {

    private EditText name;
    private EditText pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_main);
        //初始化界面
        initViews();
    }

    private void initViews() {
        name = (EditText) findViewById(R.id.reg_name);
        pwd = (EditText) findViewById(R.id.reg_paw);
      TextView reg= (TextView) findViewById(R.id.reg_reg);

        //进行注册

       reg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String names= name.getText().toString();
               String pwds= pwd.getText().toString();
               if(!TextUtils.isEmpty(names)&&!TextUtils.isEmpty(pwds)){
                   load(names,pwds);
               }
           }
       });

    }
    public void load(final String names, final String pwds){
        AsyncHttpClient client=new AsyncHttpClient();
        String url="http://169.254.94.62:8080/bullking1/register?name="+names+"&pwd="+pwds;
        client.get(RegActivity.this, url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(RegActivity.this, "注册失败", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                Intent in=new Intent();
                in.putExtra("name",names);
                in.putExtra("pwd",pwds);

                RegActivity.this.setResult(30,in);
                finish();
            }
        });
    }
}
