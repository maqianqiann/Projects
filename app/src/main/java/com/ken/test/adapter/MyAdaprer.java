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

import java.util.List;

/**
 * Created by lenovo on 2017/4/14.
 */

public class MyAdaprer extends RecyclerView.Adapter<MyAdaprer.MyViewHolder> {
    private Context context;
    private List<FirstBean.DataBean.BestSellersBean> bestSellers;
    private final int IMAGE_ONE = 0;
    private final int IMAGE_TWO = 1;
    private final int IMAGE_MORE = 2;
    private FirstBean bean;

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
        holder.title.setText(bestSellers.get(0).getGoodsList().get(position).getGoods_name());
        holder.price.setText(bestSellers.get(0).getGoodsList().get(position).getMarket_price()+"￥");
        Glide.with(context).load(bestSellers.get(0).getGoodsList().get(position).getGoods_img()).into(holder.image);

    }

   @Override
    public int getItemCount() {
        return bestSellers.get(0).getGoodsList().size();
    }
/*@Override
public int getItemCount() {
    return bean.getData().getBestSellers().get(0).getGoodsList().size()+
            bean.getData().getDefaultGoodsList().size()+bean.getData().getSubjects().get(0).getGoodsList().size()
            +bean.getData().getSubjects().get(1).getGoodsList().size()
            +bean.getData().getSubjects().get(2).getGoodsList().size()
            +bean.getData().getSubjects().get(3).getGoodsList().size()
            +bean.getData().getSubjects().get(4).getGoodsList().size()
            +bean.getData().getSubjects().get(5).getGoodsList().size()
            +bean.getData().getSubjects().get(6).getGoodsList().size()
            ;*/


 /*   @Override
    public int getItemViewType(int position) {
        if(bean.getData().getDefaultGoodsList().size()==6){
              return 2;
        }if(!bean.getData().getSubjects().isEmpty()){
            return 1;
        }else{
            return 0;
        }


    }*/


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
