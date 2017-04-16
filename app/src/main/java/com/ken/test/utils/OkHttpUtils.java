package com.ken.test.utils;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * Created by lenovo on 2017/4/15.
 */

public class OkHttpUtils {

    //创建对外提供的方法
    public static void getOkHttpObject(String url,MyCallBack cb){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(cb);

    }

}



