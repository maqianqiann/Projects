package com.ken.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ken.test.R;
import com.ken.test.activity.FirstActivity;
import com.ken.test.adapter.MyAdaprer;
import com.ken.test.bean.FirstBean;
import com.ken.test.utils.GlideImageLoader;
import com.ken.test.view.FullyLinearLayoutManager;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import com.youth.banner.Banner;
import com.youth.banner.view.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by lenovo on 2017/4/13.
 */

public class FragmentShow extends Fragment {

    private View view;
    private FirstActivity activity;
    private ArrayList<String> images;
    private Banner banner;
    private RecyclerView rv_show;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.show_layout,null);
        activity = (FirstActivity) getActivity();

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        banner = (Banner) view.findViewById(R.id.banner_show_fragment);
        rv_show = (RecyclerView) view.findViewById(R.id.rv_show_c);
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(activity,FullyLinearLayoutManager.HORIZONTAL,false);
        rv_show.setNestedScrollingEnabled(false);
        //设置布局管理器
        rv_show.setLayoutManager(linearLayoutManager);



         //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //解析数据
        getDatas();

    }

    private void getDatas() {
        String url="http://m.yunifang.com/yunifang/mobile/home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447";
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(activity, url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                 Gson gson=new Gson();
                 FirstBean bean=gson.fromJson(responseString,FirstBean.class);
                final List<FirstBean.DataBean.Ad1Bean> list = bean.getData().getAd1();
                images=new ArrayList<String>();
                for (int i = 0; i <list.size() ; i++) {
                      images.add(list.get(i).getImage());
                    Log.i("xxx",list.get(i).getImage());
                }
                Toast.makeText(activity, list.get(1).getImage(), Toast.LENGTH_SHORT).show();
                //设置图片集合
                  banner.setImages(images);
                //banner设置方法全部调用完毕时最后调用
                  banner.start();
                final List<FirstBean.DataBean.BestSellersBean> bestSellers = bean.getData().getBestSellers();

                //设置适配器
                rv_show.setAdapter(new MyAdaprer(activity,bestSellers));
            }
        });


    }

}
