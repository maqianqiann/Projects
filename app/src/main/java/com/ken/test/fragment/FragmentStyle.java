package com.ken.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ken.test.R;
import com.ken.test.activity.FirstActivity;
import com.ken.test.adapter.MyAdaprer;
import com.ken.test.adapter.MyAdapterStyle;
import com.ken.test.bean.MoBean;
import com.ken.test.utils.MyCallBack;
import com.ken.test.utils.OkHttpUtils;

import java.util.List;

/**
 * Created by lenovo on 2017/4/13.
 */

public class FragmentStyle extends Fragment implements View.OnClickListener{

    private FirstActivity activity;
    private View view;
    private RecyclerView rv;

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
        ImageView sx_man= (ImageView) view.findViewById(R.id.type_sx_man);

         sx_mm.setOnClickListener(this);
         sx_rfs.setOnClickListener(this);
         sx_rfr.setOnClickListener(this);
         sx_jmr.setOnClickListener(this);
         sx_other.setOnClickListener(this);
         sx_tz.setOnClickListener(this);
         sx_man.setOnClickListener(this);



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
        rv = (RecyclerView) view.findViewById(R.id.type_recyclerView);

    }

    //设置点击事件
    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.type_sx_mianmo:

                 break;
             case R.id.type_sx_runfushui:
                 break;
             case R.id.type_sx_runfuru:
                 break;
             case R.id.type_sx_jiemianru:
                 break;
              case R.id.type_sx_other:
                 break;
             case R.id.type_sx_taozhuang:
                 break;
             case R.id.type_sx_man:
                 break;

             case R.id.type_gx_bushui:
                 break;
             case R.id.type_gx_xiufu:
                 break;
             case R.id.type_gx_kongyou:
                 break;
             case R.id.type_gx_kangzhou:
                 break;
             case R.id.type_gx_meibai:
                 break;


             case R.id.type_fz_huihe:
                 break;
             case R.id.type_fz_zhongxing:
                 break;
             case R.id.type_fz_ganxing:
                 break;
             case R.id.type_fz_doudou:
                 break;
             case R.id.type_fz_youxing:
                 break;
             case R.id.type_fz_mingan:
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
                MoBean moBean = gson.fromJson(s, MoBean.class);
                final List<MoBean.DataBean> list = moBean.getData();
                rv.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));
                rv.setAdapter(new MyAdapterStyle(activity,list));
              }
        });
    }
}
