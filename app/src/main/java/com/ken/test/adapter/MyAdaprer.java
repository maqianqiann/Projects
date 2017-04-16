package com.ken.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ken.test.R;
import com.ken.test.activity.FirstActivity;
import com.ken.test.bean.FirstBean;
import com.ken.test.bean.MoBean;

import java.util.List;

/**
 * Created by lenovo on 2017/4/14.
 */

public class MyAdaprer extends RecyclerView.Adapter<MyAdaprer.MyViewHolder> {
    private Context context;
    private List<FirstBean.DataBean.BestSellersBean> bestSellers;

    public MyAdaprer(Context context, List<FirstBean.DataBean.BestSellersBean> bestSellers) {
        this.context = context;
        this.bestSellers = bestSellers;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.item_show, null);
            return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(bestSellers.get(0).getGoodsList().get(position).getEfficacy());
        holder.price.setText(bestSellers.get(0).getGoodsList().get(position).getMarket_price()+"￥");
        Glide.with(context).load(bestSellers.get(0).getGoodsList().get(position).getGoods_img()).into(holder.image);

    }

   @Override
    public int getItemCount() {
        return bestSellers.get(0).getGoodsList().size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView image;
        private final TextView title;
        private final TextView price;
        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image_show_item);
            title = (TextView) itemView.findViewById(R.id.title_show_item);
            price = (TextView) itemView.findViewById(R.id.price_show_item);

        }
    }
}
