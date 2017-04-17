package com.ken.test.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ken.test.R;
import com.ken.test.activity.FirstActivity;
import com.ken.test.activity.GongInfoActivity;
import com.ken.test.activity.InfoActivity;
import com.ken.test.bean.MoBean;
import com.ken.test.utils.MyCallBack;
import com.ken.test.utils.OkHttpUtils;
import com.ken.test.view.InnerGridView;

import java.util.List;

/**
 * Created by lenovo on 2017/4/13.
 */

public class FragmentStyle extends Fragment implements View.OnClickListener{

    private FirstActivity activity;
    private View view;

    private InnerGridView gridView;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (FirstActivity) getActivity();
        view = View.inflate(activity, R.layout.type_layout,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化控件
        initViews();

    }

    private void initViews() {
        //顶部的控件
        ImageView sx_mm= (ImageView) view.findViewById(R.id.type_sx_mianmo);
        ImageView sx_rfs= (ImageView) view.findViewById(R.id.type_sx_runfushui);
        ImageView sx_rfr= (ImageView) view.findViewById(R.id.type_sx_runfuru);
        ImageView sx_jmr= (ImageView) view.findViewById(R.id.type_sx_jiemianru);
        ImageView sx_other= (ImageView) view.findViewById(R.id.type_sx_other);
        ImageView sx_tz= (ImageView) view.findViewById(R.id.type_sx_taozhuang);

         sx_mm.setOnClickListener(this);
         sx_rfs.setOnClickListener(this);
         sx_rfr.setOnClickListener(this);
         sx_jmr.setOnClickListener(this);
         sx_other.setOnClickListener(this);
         sx_tz.setOnClickListener(this);



        //中间的控件
        ImageView gx_bs= (ImageView) view.findViewById(R.id.type_gx_bushui);
        ImageView gx_xf= (ImageView) view.findViewById(R.id.type_gx_xiufu);
        ImageView gx_ky= (ImageView) view.findViewById(R.id.type_gx_kongyou);
        ImageView gx_mb= (ImageView) view.findViewById(R.id.type_gx_meibai);
        ImageView gx_kz= (ImageView) view.findViewById(R.id.type_gx_kangzhou);
        gx_bs.setOnClickListener(this);
        gx_xf.setOnClickListener(this);
        gx_ky.setOnClickListener(this);
        gx_mb.setOnClickListener(this);
        gx_kz.setOnClickListener(this);



        Button button_huihe= (Button) view.findViewById(R.id.type_fz_huihe);
        Button button_zx= (Button) view.findViewById(R.id.type_fz_zhongxing);
        Button button_gx= (Button) view.findViewById(R.id.type_fz_ganxing);
        Button button_yx= (Button) view.findViewById(R.id.type_fz_youxing);
        Button button_dd= (Button) view.findViewById(R.id.type_fz_doudou);
        Button button_mg= (Button) view.findViewById(R.id.type_fz_mingan);

        button_huihe.setOnClickListener(this);
        button_zx.setOnClickListener(this);
        button_gx.setOnClickListener(this);
        button_dd.setOnClickListener(this);
        button_yx.setOnClickListener(this);
        button_mg.setOnClickListener(this);
       //初始化数据
        getDatas();
        gridView = (InnerGridView) view.findViewById(R.id.type_GridView);

    }

    //设置点击事件
    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.type_sx_mianmo:
                 intent = new Intent(activity, InfoActivity.class);
                  intent.putExtra("url","http://m.yunifang.com/yunifang/mobile/goods/getall?random=13819&encode=d58e53c4b9e24bd5ba276ba68f8e98ec&category_id=17");
                  intent.putExtra("name","面膜");
                 startActivityForResult(intent,0);
                   break;
             case R.id.type_sx_runfushui:
                 intent =  new Intent(activity, InfoActivity.class);
                 intent.putExtra("url","http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=39");
                 intent.putExtra("name","润肤水");
                 startActivityForResult(intent,0);
                 break;
             case R.id.type_sx_runfuru:
                 intent =  new Intent(activity, InfoActivity.class);
                 intent.putExtra("url","http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=40");
                 intent.putExtra("name","润肤乳");
                 startActivityForResult(intent,0);
                 break;
             case R.id.type_sx_jiemianru:
                 intent =  new Intent(activity, InfoActivity.class);
                 intent.putExtra("url","http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=24");
                 intent.putExtra("name","洁面乳");
                 startActivityForResult(intent,0);
                 break;
              case R.id.type_sx_other:
                  intent =  new Intent(activity, InfoActivity.class);
                  intent.putExtra("url","http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=35");
                  intent.putExtra("name","其他");
                  startActivityForResult(intent,0);
                 break;
             case R.id.type_sx_taozhuang:
                 intent =  new Intent(activity, InfoActivity.class);
                 intent.putExtra("url","http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=33");
                 intent.putExtra("name","套装");
                 startActivityForResult(intent,0);

                 break;



             case R.id.type_gx_bushui:

                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",0);
                 startActivityForResult(intent,0);

                 break;
             case R.id.type_gx_xiufu:

                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",1);
                 startActivityForResult(intent,0);
                 break;
             case R.id.type_gx_kongyou:
                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",2);
                 startActivityForResult(intent,0);
                 break;
             case R.id.type_gx_kangzhou:
                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",3);
                 startActivityForResult(intent,0);
                 break;
             case R.id.type_gx_meibai:
                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",4);
                 startActivityForResult(intent,0);
                 break;


             case R.id.type_fz_huihe:
                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",0);
                 startActivityForResult(intent,0);
                 break;
             case R.id.type_fz_zhongxing:
                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",1);
                 startActivityForResult(intent,0);
                 break;
             case R.id.type_fz_ganxing:
                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",2);
                 startActivityForResult(intent,0);
                 break;
             case R.id.type_fz_doudou:
                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",2);
                 startActivityForResult(intent,0);
                 break;
             case R.id.type_fz_youxing:
                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",3);
                 startActivityForResult(intent,0);
                 break;
             case R.id.type_fz_mingan:
                 intent=new Intent(activity, GongInfoActivity.class);
                 intent.putExtra("position",4);
                 startActivityForResult(intent,0);
                 break;

         }
    }
    private void getDatas(){
        String url="http://m.yunifang.com/yunifang/mobile/category/list?random=96333&encode=bf3386e14fe5bb0bcef234baebca2414";
        OkHttpUtils.getOkHttpObject(url, new MyCallBack() {
            @Override
            public void Ok(String s) {
                //进行解析
                Gson gson=new Gson();
                MoBean moBeen = gson.fromJson(s,MoBean.class);
                final List<MoBean.DataBean.GoodsBriefBean> list = moBeen.getData().getGoodsBrief();
                MyAdapter myAdapter = new MyAdapter(list);
                 gridView.setAdapter(myAdapter);

              }
        });


    }
    private class MyAdapter extends BaseAdapter{
       private  List<MoBean.DataBean.GoodsBriefBean> list;
        public MyAdapter(List<MoBean.DataBean.GoodsBriefBean> list) {
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
                 holder.title = (TextView) convertView.findViewById(R.id.title_show_tt);
                 holder.desc = (TextView)  convertView.findViewById(R.id.desc_show_tt);
                 holder.im = (ImageView) convertView.findViewById(R.id.image_show_tt);
                 holder.price = (TextView) convertView.findViewById(R.id.price_show_tt);
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
        class ViewHolder{
            TextView title;
            TextView desc;
            ImageView im;
            TextView price;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
