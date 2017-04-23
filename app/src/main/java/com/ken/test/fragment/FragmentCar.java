package com.ken.test.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ken.test.R;
import com.ken.test.activity.CastActivity;
import com.ken.test.activity.FirstActivity;
import com.ken.test.activity.LogActivity;
import com.ken.test.bean.DingBean;
import com.ken.test.bean.GoodsBean;
import com.ken.test.bean.GouwucheBean;
import com.ken.test.view.QQListView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by lenovo on 2017/4/13.
 */

public class FragmentCar extends Fragment implements View.OnClickListener{

    private View view;
    private FirstActivity activity;
    private CheckBox cb_all;
    private TextView price_all;
    private TextView js_all;
    private QQListView listView;

    private Map<String, Boolean> map;
    private List<GoodsBean.CartItemListBean> list;
    private RelativeLayout rel_car1;
    private RelativeLayout rel_car2;

    private ArrayList<GouwucheBean.CartItemList> cartItemList1;
    private GouwucheBean bean;
    private MyAdapter adapter;
    private ArrayList<DingBean> listd;//这是订单的集合
    private double money=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.car_layout,null);
        activity = (FirstActivity) getActivity();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //判断登陆的状态

        Button guang= (Button) view.findViewById(R.id.button_guang_car);

        rel_car1 = (RelativeLayout) view.findViewById(R.id.rel_car1);
        rel_car2 = (RelativeLayout) view.findViewById(R.id.rel_car2);


        //获得全选的框
        cb_all = (CheckBox) view.findViewById(R.id.f3_box);
        cb_all.setOnClickListener(this);

        price_all = (TextView) view.findViewById(R.id.f3_price);

        js_all = (TextView) view.findViewById(R.id.f3_jiesuan);
        js_all.setOnClickListener(this);

        listView = (QQListView) view.findViewById(R.id.f3_listView_car);

        guang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(activity,FirstActivity.class);
                startActivity(in);

            }
        });

        if(LogActivity.state==true){
            questDatas(64);
         }

        //设置条目的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
        //设置cb的点击事件
        cb_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cartItemList1!=null){
                    boolean checked = ((CheckBox) v).isChecked();
                    if(checked){
                        for (int i = 0; i <cartItemList1.size() ; i++) {
                            cartItemList1.get(i).setFlag(checked);
                            adapter.notifyDataSetChanged();//刷新适配器
                            double parseInt = Double.parseDouble(cartItemList1.get(i).getPrice())*100/100d;
                            int count = cartItemList1.get(i).getCount();
                            money+= parseInt*count ;
                        }
                    }else if(!checked){
                        for (int i = 0; i <cartItemList1.size() ; i++) {
                            cartItemList1.get(i).setFlag(false);
                            adapter.notifyDataSetChanged();//刷新适配器
                        }
                        money=0;
                    }
                }//计算钱数
                price_all.setText(money+"￥");
            }
        });
   }

    @Override
    public void onResume() {
        super.onResume();
        if(LogActivity.state==true){
            //再次调用请求的方法
                questDatas(64);
        }
    }

    //写个请求的方法
    public void  questDatas(int id){
        String url="http://169.254.94.62:8080/bullking1/cart?userID="+id;
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(activity, url, new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                    }
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Gson gson=new Gson();
                        Log.i("xxx",responseString);
                        bean = gson.fromJson(responseString, GouwucheBean.class);
                        cartItemList1 = bean.getCartItemList();
                        if(cartItemList1!=null){
                            rel_car1.setVisibility(View.GONE);
                            rel_car2.setVisibility(View.VISIBLE);
                             //遍历集合
                            for (int i = 0; i <cartItemList1.size() ; i++) {
                                cartItemList1.get(i).setFlag(false);//设置状态

                            }
                            //拿到价格的总数

                            //设置数据
                            adapter = new MyAdapter(cartItemList1);
                            listView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();


                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.f3_jiesuan:
                //将选中的内容传过去
                if(cartItemList1!=null){
                    listd=new ArrayList<>();
                    for (int i = 0; i <cartItemList1.size() ; i++) {
                    if(cartItemList1.get(i).getFlag()){
                        //将数据装到集合中传入
                        DingBean bean=new DingBean();
                        bean.title=cartItemList1.get(i).getName();
                        bean.price=Double.parseDouble(cartItemList1.get(i).getPrice());
                        bean.im=cartItemList1.get(i).getPic();
                        bean.id=cartItemList1.get(i).getCount();
                        listd.add(bean);
                    }
                    }
                }
                Intent in=new Intent(activity, CastActivity.class);
                if(listd.size()!=0){
                    in.putExtra("listd",(Serializable)listd);
                    //将订单信息传过去
                    startActivity(in);

                }else{
                    Toast.makeText(activity, "您还没有选择您购买的商品~", Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }

    private class MyAdapter extends BaseAdapter{
        ArrayList<GouwucheBean.CartItemList> cartItemList;
        public MyAdapter(ArrayList<GouwucheBean.CartItemList> cartItemList) {
            this.cartItemList=cartItemList;
        }

        @Override
        public int getCount() {
            return cartItemList.size();
        }

        @Override
        public Object getItem(int position) {
            return cartItemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView=View.inflate(activity,R.layout.car_list_layout,null);
            ImageView im= (ImageView) convertView.findViewById(R.id.im_car_list);
            TextView title= (TextView) convertView.findViewById(R.id.title_car_list);
            TextView price= (TextView) convertView.findViewById(R.id.price_car_list);
            TextView num= (TextView) convertView.findViewById(R.id.num_car_list);
            TextView delete= (TextView) convertView.findViewById(R.id.delete);
            CheckBox cb= (CheckBox) convertView.findViewById(R.id.cb_car_list);

            //设置数据
            title.setText(cartItemList.get(position).getName());
            price.setText(cartItemList.get(position).getPrice()+"￥");
            Glide.with(activity).load(cartItemList.get(position).getPic()).into(im);
            cb.setChecked(cartItemList.get(position).getFlag());
           num.setText(cartItemList.get(position).getCount()+"");
            //设置点击事件
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //获得当前的状态设为相反的状态
                    Boolean aBoolean = cartItemList.get(position).getFlag();
                    cartItemList.get(position).setFlag(!aBoolean);
                    Boolean flag = cartItemList.get(position).getFlag();
                    adapter.notifyDataSetChanged();//刷新
                    if(flag){
                        double parseInt = Double.parseDouble(cartItemList1.get(position).getPrice())*100/100d;
                        int count = cartItemList1.get(position).getCount();
                        money+= (parseInt*count) ;
                        price_all.setText(money+"");
                    }if(!flag){
                        double parseInt = Double.parseDouble(cartItemList1.get(position).getPrice())*100/100d;
                        int count = cartItemList1.get(position).getCount();
                        money-= (parseInt*count) ;
                        price_all.setText(money+"");
                    }
                    adapter.notifyDataSetChanged();

                    boolean Boolean_flag=true;
                    for (int i = 0; i <cartItemList.size(); i++) {
                        Boolean ba = cartItemList.get(i).getFlag();
                        if(!ba){
                            //如果有一个为false都为false
                            Boolean_flag=false;
                            cb_all.setChecked(false);
                        }
                    }
                    if(Boolean_flag){
                       cb_all.setChecked(Boolean_flag);
                       adapter.notifyDataSetChanged();
                    }
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartItemList.remove(position);
                    notifyDataSetChanged();
                    listView.turnToNormal();
                }
            });

            return convertView;
        }
    }
}
