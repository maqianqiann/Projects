package com.ken.test.utils;


import android.os.Handler;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by lenovo on 2017/4/15.
 */

public abstract class MyCallBack implements Callback {
   private Handler handler= new Handler();

    @Override
    public void onFailure(Request request, IOException e) {



    }

    @Override
    public void onResponse(Response response) throws IOException {
        final String s=response.body().string();
       handler.post(new Runnable() {
           @Override
           public void run() {
              Ok(s);
           }
       });
    }
   public abstract  void Ok(String s);
}
