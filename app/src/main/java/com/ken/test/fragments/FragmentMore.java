package com.ken.test.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ken.test.R;
import com.ken.test.activity.MoreActivity;
import com.ken.test.activity.ShopActivity;
import com.ken.test.adapter.MyGridAdapter;
import com.ken.test.bean.GongBean;
import com.ken.test.bean.MoBean;
import com.ken.test.utils.MyCallBack;
import com.ken.test.utils.OkHttpUtils;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.R.id.list;

/**
 * Created by lenovo on 2017/4/18.
 */

public class FragmentMore extends Fragment {

    private View view;
    private MoreActivity activity;
    private String url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=13819&encode=d58e53c4b9e24bd5ba276ba68f8e98ec&category_id=17";
    private GridView gridView;
   private int position=0;
    private MyAdapter adapter;
    private ArrayList<GongBean.DataBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        view = inflater.inflate(R.layout.fragment_layout,null);
        activity = (MoreActivity) getActivity();
        Bundle bundle = getArguments();
        position = bundle.getInt("position");
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gridView = (GridView) view.findViewById(R.id.frag_good_grid);

        //进行解析数据
        getDatas();
        
        //设置监听
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(activity,ShopActivity.class);
                in.putExtra("position",position);
                in.putExtra("list",(Serializable)list);
                startActivityForResult(in,10);
            }
        });


    }

    private void getDatas() {
        OkHttpUtils.getOkHttpObject(url, new MyCallBack() {
            @Override
            public void Ok(String s) {
                Gson gson=new Gson();
                GongBean bean = gson.fromJson(s, GongBean.class);
                list = (ArrayList<GongBean.DataBean>) bean.getData();
                if(position==1){
                    Collections.sort(list);
                }if(position==2){

                    Collections.sort(list, new Comparator<GongBean.DataBean>() {
                        @Override
                        public int compare(GongBean.DataBean lhs, GongBean.DataBean rhs) {
                            if(lhs.getMarket_price()>rhs.getMarket_price()){
                                return 1;
                            }if(lhs.getMarket_price()<rhs.getMarket_price()){
                                return -1;
                            }
                             return 0;
                        }
                    });
                }

                adapter = new MyAdapter(list);
                gridView.setAdapter(adapter);
            }
        });
    }
 private class MyAdapter extends BaseAdapter {

     private  List<GongBean.DataBean> list;

     public MyAdapter(List<GongBean.DataBean> list) {
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
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = View.inflate(activity, R.layout.item_show_two, null);
                holder = new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.title_show_tt);
                holder.desc = (TextView) convertView.findViewById(R.id.desc_show_tt);
                holder.im = (ImageView) convertView.findViewById(R.id.image_show_tt);
                holder.price = (TextView) convertView.findViewById(R.id.price_show_tt);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.price.setText(list.get(position).getMarket_price() + "￥");
            holder.desc.setText(list.get(position).getGoods_name());
            holder.title.setText(list.get(position).getEfficacy());
            Glide.with(activity).load(list.get(position).getGoods_img()).into(holder.im);

            return convertView;
        }

        class ViewHolder {
            TextView title;
            ImageView im;
            TextView price;
            TextView desc;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
