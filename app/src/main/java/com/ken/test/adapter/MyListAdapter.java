package com.ken.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ken.test.R;

import com.ken.test.bean.FirstBean;
import com.ken.test.view.FullyLinearLayoutManager;

import java.util.List;

/**
 * Created by lenovo on 2017/4/14.
 */

public class MyListAdapter extends BaseAdapter {

    private Context context;
    private List<FirstBean.DataBean.SubjectsBean> subjects;
    private RecyclerView rv_show_two;

    public MyListAdapter(Context context, List<FirstBean.DataBean.SubjectsBean> subjects) {
        this.context=context;
        this.subjects=subjects;
        if(rv_show_two!=null){
            //设置布局管理器
            rv_show_two.setLayoutManager(new FullyLinearLayoutManager(context, FullyLinearLayoutManager.HORIZONTAL,false));
        }

    }

    @Override
    public int getCount() {
        return subjects.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      convertView=View.inflate(context, R.layout.show_two,null);
        rv_show_two = (RecyclerView) convertView.findViewById(R.id.rv_show_two);
       ImageView imageView= (ImageView) convertView.findViewById(R.id.image_show_two);
       Glide.with(context).load(subjects.get(position).getImage()).into(imageView);

        rv_show_two.setNestedScrollingEnabled(false);

         rv_show_two.setLayoutManager(new FullyLinearLayoutManager(context, FullyLinearLayoutManager.HORIZONTAL,false));

        final List<FirstBean.DataBean.SubjectsBean.GoodsListBean> goodsList = subjects.get(position).getGoodsList();
        //设置适配器
        rv_show_two.setAdapter(new MyAdapterTwo(context,goodsList));

        return convertView;
    }

    public class MyAdapterTwo extends RecyclerView.Adapter<MyAdapterTwo.ViewHolderTwo> {
        private Context context;
        private List<FirstBean.DataBean.SubjectsBean.GoodsListBean> goodsList;

        public MyAdapterTwo(Context context, List<FirstBean.DataBean.SubjectsBean.GoodsListBean> goodsList) {
            this.context=context;
            this.goodsList=goodsList;
        }
        @Override
        public ViewHolderTwo onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=View.inflate(context,R.layout.item_show_two,null);

            return new ViewHolderTwo(view);
        }

        @Override
        public void onBindViewHolder(ViewHolderTwo holder, int position) {
               holder.title.setText(goodsList.get(position).getEfficacy());
             Glide.with(context).load(goodsList.get(position).getGoods_img()).into(holder.im);
            holder.desc.setText(goodsList.get(position).getGoods_name());
            holder.price.setText(goodsList.get(position).getMarket_price()+"￥");

        }

        @Override
        public int getItemCount() {
            return goodsList.size();
        }

        class ViewHolderTwo extends RecyclerView.ViewHolder{

            private final TextView title;
            private final ImageView im;
            private final TextView desc;
            private final TextView price;

            public ViewHolderTwo(View itemView) {
                  super(itemView);
                title = (TextView) itemView.findViewById(R.id.title_show_tt);
                im = (ImageView) itemView.findViewById(R.id.image_show_tt);
                desc = (TextView) itemView.findViewById(R.id.desc_show_tt);
                price = (TextView) itemView.findViewById(R.id.price_show_tt);

              }
          }
    }
}
