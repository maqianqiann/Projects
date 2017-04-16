package com.ken.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ken.test.R;
import com.ken.test.bean.FirstBean;

import java.util.List;

/**
 * Created by lenovo on 2017/4/14.
 */

public class MyGridAdapter extends BaseAdapter {
    private Context context;
    private List<FirstBean.DataBean.DefaultGoodsListBean> listBeen;
    public MyGridAdapter(Context context, List<FirstBean.DataBean.DefaultGoodsListBean> listBeen) {
      this.context=context;
      this.listBeen=listBeen;
    }

    @Override
    public int getCount() {
        return listBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return listBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item_show_two,null);
            holder=new ViewHolder();
            holder.title= (TextView) convertView.findViewById(R.id.title_show_tt);
            holder.desc= (TextView) convertView.findViewById(R.id.desc_show_tt);
            holder.im= (ImageView) convertView.findViewById(R.id.image_show_tt);
            holder.price= (TextView) convertView.findViewById(R.id.price_show_tt);
         convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.price.setText(listBeen.get(position).getMarket_price()+"￥");
        holder.desc.setText(listBeen.get(position).getGoods_name());
        holder.title.setText(listBeen.get(position).getEfficacy());
        Glide.with(context).load(listBeen.get(position).getGoods_img()).into(holder.im);

        return convertView;
    }
     class ViewHolder{
         TextView title;
         ImageView im;
         TextView price;
         TextView desc;
     }
}
