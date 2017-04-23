package com.ken.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ken.test.R;
import com.ken.test.bean.DingBean;
import com.ken.test.bean.FirstBean;
import com.ken.test.bean.GongBean;
import com.ken.test.bean.GoodsBean;
import com.ken.test.utils.MyCallBack;
import com.ken.test.utils.OkHttpUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by lenovo on 2017/4/18.
 */

public class ShopActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView good_im;
    private TextView price_f;
    private TextView price_z;
    private ArrayList<GongBean.DataBean> list;
    private int position;
    private TextView shang_name;
    private TextView jia_car;
    private TextView mai_car;
    private ImageView shang_car;
    private String url;
    private ArrayList<GoodsBean> listg=new ArrayList<>();
    private int lei;
    private ArrayList<FirstBean.DataBean.SubjectsBean.GoodsListBean> arrayList;
    private String pic;
    private double price;
    private String name;
    private String pic_u;
    private double price_u;
    private String name_u;
    private String pic_n;
    private String name_n;
    private double price_n;
    private int number=1;
    private ArrayList<DingBean> listd=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shang_mian);
        //拿到数据
        Intent intent = getIntent();
        list = (ArrayList<GongBean.DataBean>) intent.getSerializableExtra("list");
        position = intent.getIntExtra("position", -1);
        url = intent.getStringExtra("url");//第一个recycle的数据
        lei = intent.getIntExtra("lei", 0);//嵌套的数据，识别的类型，下面的是数据
        arrayList = (ArrayList<FirstBean.DataBean.SubjectsBean.GoodsListBean>) intent.getSerializableExtra("lists");
        //初始化控件
        initViews();

    }

    private void initViews() {
        good_im = (ImageView) findViewById(R.id.shang_pic);
        price_f = (TextView) findViewById(R.id.shang_pirce1);
        price_z = (TextView) findViewById(R.id.shang_pirce2);
        shang_name = (TextView) findViewById(R.id.shang_name);
        ImageView im= (ImageView) findViewById(R.id.f1_person);
        //购物车
        shang_car = (ImageView) findViewById(R.id.shang_car);
        shang_car.setOnClickListener(this);
        //添加到购物车
        jia_car = (TextView) findViewById(R.id.shang_jia);
        jia_car.setOnClickListener(this);
        //立即购买
        mai_car = (TextView) findViewById(R.id.shang_mai);
        mai_car.setOnClickListener(this);
        //调用解析的方法
        if(url!=null){
            initDatas();

        } else if(lei==5&&arrayList!=null){
            pic_u = arrayList.get(position).getGoods_img();
            price_u = arrayList.get(position).getMarket_price();
            name_u = arrayList.get(position).getEfficacy();
            DingBean ding=new DingBean();
            ding.id=64;
            ding.im=pic_u;
            ding.price=price_u;
            ding.title=name_u;
            listd.add(ding);

            Glide.with(ShopActivity.this).load(arrayList.get(position).getGoods_img()).into(good_im);
            price_z.setText(arrayList.get(position).getMarket_price()+"￥");
            price_f.setText(arrayList.get(position).getShop_price()+"￥");
            shang_name.setText(arrayList.get(position).getEfficacy());




        }
        else{
           //设置数据
            pic_n = list.get(position).getGoods_img();
            name_n = list.get(position).getEfficacy();
            price_n = list.get(position).getMarket_price();

            DingBean ding=new DingBean();
            ding.id=64;
            ding.im=pic_n;
            ding.price=price_n;
            ding.title=name_n;
            listd.add(ding);
            Glide.with(ShopActivity.this).load(list.get(position).getGoods_img()).into(good_im);
        price_z.setText(list.get(position).getMarket_price()+"￥");
        price_f.setText(list.get(position).getShop_price()+"￥");
        shang_name.setText(list.get(position).getEfficacy());




        }
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent();
                ShopActivity.this.setResult(20,in);
                finish();
            }
        });

    }



    private void initDatas() {
        OkHttpUtils.getOkHttpObject(url, new MyCallBack() {

            @Override
            public void Ok(String s) {
                Gson gson=new Gson();
                FirstBean bean = gson.fromJson(s, FirstBean.class);
                List<FirstBean.DataBean.BestSellersBean> list = bean.getData().getBestSellers();
                pic = list.get(0).getGoodsList().get(position).getGoods_img();
                price = list.get(0).getGoodsList().get(position).getMarket_price();
                name = list.get(0).getGoodsList().get(position).getEfficacy();
                DingBean ding=new DingBean();
                ding.id=64;
                ding.im=pic;
                ding.price=price;
                ding.title=name;
                listd.add(ding);

                Glide.with(ShopActivity.this).load(list.get(0).getGoodsList().get(position).getGoods_img()).into(good_im);
                price_z.setText(list.get(0).getGoodsList().get(position).getMarket_price()+"￥");
                price_f.setText(list.get(0).getGoodsList().get(position).getShop_price()+"￥");
                shang_name.setText(list.get(0).getGoodsList().get(position).getEfficacy());


            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shang_car:
                //跳转到购物车的界
                Intent in=new Intent(ShopActivity.this,FirstActivity.class);
                in.putExtra("car",3);
                startActivity(in);
                break;
            case R.id.shang_jia:
                //与后台交互将数据上传到服务器上
                //添加的方法

                //弹出dialog
                if(LogActivity.state){
                    setDialog();

                }else{
                    Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent ins=new Intent(ShopActivity.this,LogActivity.class);
                    startActivity(ins);
                }

                break;
            case R.id.shang_mai:
                if(LogActivity.state) {
                    Intent intent = new Intent(this, CastActivity.class);
                    //传值，将购买的订单传过去
                    if(url!=null&&listd!=null){
                       intent.putExtra("listd",(Serializable)listd);

                    }else if(lei==5&&arrayList!=null&&listd!=null){
                        intent.putExtra("listd",(Serializable)listd);
                    }else if(listd!=null){
                        intent.putExtra("listd",(Serializable)listd);

                    }
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent ins=new Intent(ShopActivity.this,LogActivity.class);
                    startActivity(ins);
                }
                break;
        }
    }
    //写个网络请求的方法,添加到数据库的方法
    private void addDatas(int productID,int count,int colorID,int sizeID,int userID,String name,String pic,double price) {
        AsyncHttpClient client=new AsyncHttpClient();
        String url="http://169.254.94.62:8080/bullking1/cart?";
        //封装参数
        RequestParams params=new RequestParams();
        params.put("productID",productID);
        params.put("count",count);
        params.put("colorID",colorID);
        params.put("sizeID",sizeID);
        params.put("userID",userID);
        params.put("name",name);
        params.put("pic",pic);
        params.put("price",price);
       client.post(ShopActivity.this, url, params, new TextHttpResponseHandler() {
           @Override
           public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

           }

           @Override
           public void onSuccess(int statusCode, Header[] headers, String responseString) {
               Toast.makeText(ShopActivity.this, "已添加到购物车~", Toast.LENGTH_SHORT).show();

           }
       });


    }
    private void setDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ShopActivity.this);
        final AlertDialog dialog = builder.create();
        //设置布局
        View view1=View.inflate(ShopActivity.this,R.layout.dialog_car,null);
        dialog.setView(view1);
        //设置点击Dialog外部任意区域关闭Dialog
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();//显示
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        WindowManager m =getWindowManager();
        Display d = m.getDefaultDisplay(); //为获取屏幕宽、高
        WindowManager.LayoutParams p = dialog.getWindow().getAttributes(); //获取对话框当前的参数值
        p.width = d.getWidth(); //宽度设置为屏幕
        dialog.getWindow().setAttributes(p); //设置生效
        //找到控件
        Button button= (Button) view1.findViewById(R.id.a_button);
        Button add_button= (Button)  view1.findViewById(R.id.a_add);
        Button de_button= (Button)  view1.findViewById(R.id.a_delete);
        final TextView num_text= (TextView) view1.findViewById(R.id.a_num);
        TextView price_text= (TextView) view1.findViewById(R.id.a_price);
        TextView name_text= (TextView) view1.findViewById(R.id.a_name);
        ImageView a_pic= (ImageView) view1.findViewById(R.id.a_pic);
        //设置name
        if(url!=null){
            name_text.setText(name);
            price_text.setText(price+"￥");
            Glide.with(ShopActivity.this).load(pic).into(a_pic);


        }else if(lei==5&&arrayList!=null){
            name_text.setText(name_u);
            price_text.setText(price_u+"￥");
            Glide.with(ShopActivity.this).load(pic_u).into(a_pic);

        }else{
            name_text.setText(name_n);
            price_text.setText(price_n+"￥");
            Glide.with(ShopActivity.this).load(pic_n).into(a_pic);

        }
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 number++;
                num_text.setText(""+number);
            }
        });
        de_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number>0){
                    number--;
                    num_text.setText(""+number);
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(url!=null){
                    String num_s = num_text.getText().toString();
                    int anInt = Integer.parseInt(num_s);
                    addDatas(2,anInt,2,2,LogActivity.userID,name,pic,price);


                }else if(lei==5&&arrayList!=null){
                    String num_s = num_text.getText().toString();
                    int anInt = Integer.parseInt(num_s);
                    addDatas(2,anInt,2,2,LogActivity.userID,name_u,pic_u,price_u);


                }else{
                    String num_s = num_text.getText().toString();
                    int anInt = Integer.parseInt(num_s);
                    addDatas(2,anInt,2,2,LogActivity.userID,name_n,pic_n,price_n);

                }
                dialog.dismiss();//隐藏
            }

        });
    }
}
