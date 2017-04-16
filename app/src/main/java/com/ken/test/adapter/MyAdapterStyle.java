package com.ken.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ken.test.R;
import com.ken.test.bean.MoBean;

import java.util.List;

/**
 * Created by lenovo on 2017/4/15.
 */

public class MyAdapterStyle extends RecyclerView.Adapter<MyAdapterStyle.ViewHolderStyle>{
    Context context;
    List<MoBean.DataBean> list;

    public MyAdapterStyle(Context context, List<MoBean.DataBean> list) {
        this.list=list;
        this.context=context;
    }

    @Override
    public ViewHolderStyle onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=View.inflate(context,R.layout.item_show_two,null);
        return new ViewHolderStyle(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderStyle holder, int position) {
      holder.title.setText(list.get(position).getEfficacy());
      holder.desc.setText(list.get(position).getGoods_name());
        holder.price.setText(list.get(position).getShop_price()+"￥");
        Glide.with(context).load(list.get(position).getGoods_img()).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHolderStyle extends RecyclerView.ViewHolder{

       TextView title;
        TextView desc;
        ImageView im;
        TextView price;
        public ViewHolderStyle(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_show_tt);
            desc = (TextView)  itemView.findViewById(R.id.desc_show_tt);
            im = (ImageView) itemView.findViewById(R.id.image_show_tt);
            price = (TextView) itemView.findViewById(R.id.price_show_tt);

        }
    }

}

