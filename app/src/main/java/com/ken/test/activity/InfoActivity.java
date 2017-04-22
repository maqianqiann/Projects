package com.ken.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ken.test.R;
import com.ken.test.bean.GongBean;
import com.ken.test.utils.MyCallBack;
import com.ken.test.utils.OkHttpUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2017/4/17.
 */
public class InfoActivity extends AppCompatActivity{

    private RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gong_layout);
        rv = (RecyclerView) findViewById(R.id.gong_recycleView);
        ImageView im = (ImageView) findViewById(R.id.gong_im);
        TextView title= (TextView) findViewById(R.id.gong_title);


       im.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent();
               InfoActivity.this.setResult(1,intent);
               finish();
           }
       });

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String name = intent.getStringExtra("name");
        title.setText(name);
        //进行解析
        OkHttpUtils.getOkHttpObject(url, new MyCallBack() {


            @Override
            public void Ok(String s) {
                Gson gson=new Gson();
                GongBean bean = gson.fromJson(s, GongBean.class);
                List<GongBean.DataBean> list = bean.getData();
                rv.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));
                MyAdapterGong adapter = new MyAdapterGong(list);
                rv.setAdapter(adapter);

            }
        });

    }

    //写个适配器
    private class MyAdapterGong extends RecyclerView.Adapter<MyAdapterGong.GViewHolder>{

        List<GongBean.DataBean> list;
        public MyAdapterGong(List<GongBean.DataBean> list) {
            this.list=list;
        }



        @Override
        public GViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View view=View.inflate(InfoActivity.this,R.layout.item_show_two,null);
            return new GViewHolder(view);
        }

        @Override
        public void onBindViewHolder(GViewHolder holder, int position) {
            holder.title.setText(list.get(position).getEfficacy());
            holder.desc.setText(list.get(position).getGoods_name());
            holder.price.setText(list.get(position).getShop_price()+"￥");
            Glide.with(InfoActivity.this).load(list.get(position).getGoods_img()).into(holder.im);

        }


        @Override
        public int getItemCount() {
            return list.size();
        }

        class GViewHolder extends RecyclerView.ViewHolder{

            private final ImageView im;
            private final TextView desc;
            private final TextView title;
            private final TextView price;

            public GViewHolder(View itemView) {
                super(itemView);
                im = (ImageView) itemView.findViewById(R.id.image_show_tt);
                desc = (TextView) itemView.findViewById(R.id.desc_show_tt);
                desc.setGravity(Gravity.LEFT);
                title = (TextView) itemView.findViewById(R.id.title_show_tt);
                price = (TextView) itemView.findViewById(R.id.price_show_tt);
                price.setGravity(Gravity.LEFT);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in=new Intent(InfoActivity.this,ShopActivity.class);
                        in.putExtra("list",(Serializable)list);
                        in.putExtra("position",getLayoutPosition());
                        startActivityForResult(in,10);

                    }
                });
            }



        }
    }
}
