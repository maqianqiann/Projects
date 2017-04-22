package com.ken.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ken.test.R;
import com.ken.test.fragment.FragmentGood;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/4/17.
 */

public class GongInfoActivity extends AppCompatActivity {

    private ArrayList<Fragment> listf;
    private ArrayList<String> lists;
    private ArrayList<String> listt;
    private int position=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gong_real);
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        //初始化控件
        initViews();
    }

    private void initViews() {
        ImageView im = (ImageView) findViewById(R.id.gong_real_im);
        TabLayout tab= (TabLayout) findViewById(R.id.gong_real_tab);
        TextView title= (TextView) findViewById(R.id.gong_real_title);

        ViewPager vp= (ViewPager) findViewById(R.id.gong_real_vp);
        lists=new ArrayList<>();
        lists.add("http://m.yunifang.com/yunifang/mobile/goods/getall?random=13819&encode=d58e53c4b9e24bd5ba276ba68f8e98ec&category_id=17");
        lists.add("http://m.yunifang.com/yunifang/mobile/goods/getall?random=60305&encode=b0358434fda8d7478bfc325b5828b721&category_id=31");
        lists.add("http://m.yunifang.com/yunifang/mobile/goods/getall?random=60305&encode=b0358434fda8d7478bfc325b5828b721&category_id=19");
        lists.add("http://m.yunifang.com/yunifang/mobile/goods/getall?random=60305&encode=b0358434fda8d7478bfc325b5828b721&category_id=18");
        lists.add("http://m.yunifang.com/yunifang/mobile/goods/getall?random=60305&encode=b0358434fda8d7478bfc325b5828b721&category_id=20");
        listt=new ArrayList<>();
        listt.add("补水");
        listt.add("修复");
        listt.add("控油");
        listt.add("美白");
        listt.add("抗皱");
        title.setText(listt.get(position));


        listf=new ArrayList<>();
        for(int i=0;i<5;i++){
            FragmentGood f1=new FragmentGood();
            Bundle bundle=new Bundle();
            bundle.putString("url",lists.get(i));
            f1.setArguments(bundle);
            listf.add(f1);

        }
        //设置模式
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        tab.setTabsFromPagerAdapter(adapter);

        //设置默认
        vp.setCurrentItem(position);

        //设置点击
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                GongInfoActivity.this.setResult(1,intent);
                finish();
            }
        });
  }

private class MyPagerAdapter extends FragmentPagerAdapter{

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listf.get(position);
    }

    @Override
    public int getCount() {
        return listf.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listt.get(position);
    }
}

}
