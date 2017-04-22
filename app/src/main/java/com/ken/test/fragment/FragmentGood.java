package com.ken.test.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
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
import com.ken.test.activity.GongInfoActivity;
import com.ken.test.activity.ShopActivity;
import com.ken.test.bean.GongBean;
import com.ken.test.utils.MyCallBack;
import com.ken.test.utils.OkHttpUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/4/17.
 */

public class FragmentGood extends Fragment{

    private View view;
    private String url;
    private GridView grid;
    private GongInfoActivity activity;
    private ArrayList<GongBean.DataBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout,null);
        activity = (GongInfoActivity) getActivity();
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        grid = (GridView) view.findViewById(R.id.frag_good_grid);

        //进行解析
       initDatas();
        //设置点击事件
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(activity,ShopActivity.class);
                in.putExtra("position",position);
                in.putExtra("list",(Serializable)list);
                startActivityForResult(in,10);
            }
        });

    }

    private void initDatas() {
        OkHttpUtils.getOkHttpObject(url, new MyCallBack() {


            @Override
            public void Ok(String s) {
                Gson gson=new Gson();
                GongBean bean = gson.fromJson(s, GongBean.class);
                list = (ArrayList)bean.getData();
                grid.setAdapter(new MyAdapter(list));

            }
        });

    }

  private class MyAdapter extends BaseAdapter{

      private List<GongBean.DataBean> list;

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
          ViewHolder holder=null;
          if(convertView==null){
              convertView=View.inflate(activity,R.layout.item_show_two,null);
              holder=new ViewHolder();
              holder.title= (TextView) convertView.findViewById(R.id.title_show_tt);
              holder.desc= (TextView) convertView.findViewById(R.id.desc_show_tt);
              holder.price= (TextView) convertView.findViewById(R.id.price_show_tt);
              holder.im= (ImageView) convertView.findViewById(R.id.image_show_tt);
              convertView.setTag(holder);
          }else{
              holder= (ViewHolder) convertView.getTag();
          }
          holder.title.setText(list.get(position).getEfficacy());
          holder.desc.setText(list.get(position).getGoods_name());
          holder.price.setText(list.get(position).getShop_price()+"￥");
          Glide.with(activity).load(list.get(position).getGoods_img()).into(holder.im);

          return convertView;
      }
  }
    class ViewHolder{
        TextView title;
        TextView desc;
        TextView price;
        ImageView im;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
