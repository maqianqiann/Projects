package com.ken.test.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ken.test.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements Animator.AnimatorListener{
    private static final int ANIM_COUNT = 4;
    private static final int[] PHOTOS = new int[] { R.drawable.xiaomi_guidance_1,
            R.drawable.xiaomi_guidance_2, R.drawable.xiaomi_guidance_3, R.drawable.xiaomi_guidance_4,
 };

    private int time=7;
    private FrameLayout mContainer;
    private ImageView mView;
    private Random mRandom = new Random();
    private int mIndex = 0;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(time>0){
                time--;
                textView.setText(time+"s进行跳转");
                handler.sendEmptyMessageDelayed(0,1000);

            }else{
                startActivity(new Intent(MainActivity.this,FirstActivity.class));
                overridePendingTransition(R.anim.start_anim,R.anim.back_anim);
                finish();
            }
        }
    };
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContainer = new FrameLayout(this);
        mContainer.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT));

        mView = createNewView();

        textView = new TextView(this);
        textView.setText("7s跳过动画");
        textView.setGravity(Gravity.RIGHT);
        textView.setTextSize(20);
        mContainer.addView(mView);
        mContainer.addView(textView);
        setContentView(mContainer);
        handler.sendEmptyMessageDelayed(0,1000);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacksAndMessages(null);
                startActivity(new Intent(MainActivity.this,FirstActivity.class));
                overridePendingTransition(R.anim.start_anim,R.anim.back_anim);

                finish();
            }
        });
    }

    private ImageView createNewView() {
        ImageView ret = new ImageView(this);
        ret.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT));
        ret.setScaleType(ImageView.ScaleType.FIT_XY);
        ret.setImageResource(PHOTOS[mIndex]);
        mIndex = (mIndex + 1 < PHOTOS.length) ? mIndex + 1 : 0;

        return ret;
    }


    private void nextAnimation() {
        AnimatorSet anim = new AnimatorSet();
        final int index = mRandom.nextInt(ANIM_COUNT);

        switch (index) {
            case 0:
                anim.playTogether(
                        ObjectAnimator.ofFloat(mView, "scaleX", 1.5f, 1f),
                        ObjectAnimator.ofFloat(mView, "scaleY", 1.5f, 1f));
                break;

            case 1:
                anim.playTogether(ObjectAnimator.ofFloat(mView, "scaleX", 1, 1.5f),
                        ObjectAnimator.ofFloat(mView, "scaleY", 1, 1.5f));
                break;

            case 2:
             //   AnimatorProxy.wrap(mView).setScaleX(1.5f);
              //  AnimatorProxy.wrap(mView).setScaleY(1.5f);
                anim.playTogether(ObjectAnimator.ofFloat(mView, "translationY",
                        80f, 0f));
                break;

            case 3:
            default:
              //  AnimatorProxy.wrap(mView).setScaleX(1.5f);
               // AnimatorProxy.wrap(mView).setScaleY(1.5f);
                anim.playTogether(ObjectAnimator.ofFloat(mView, "translationX", 0f,
                        40f));
                break;
        }

        anim.setDuration(2000);
        anim.addListener(this);
        anim.start();

    }

    @Override
    public void onAnimationCancel(Animator arg0) {
    }

    @Override
    public void onAnimationEnd(Animator animator) {
        mContainer.removeView(mView);
        mView = createNewView();
        mContainer.addView(mView);
        nextAnimation();
    }

    @Override
    public void onAnimationRepeat(Animator arg0) {
    }

    @Override
    public void onAnimationStart(Animator arg0) {
    }


    @Override
    protected void onResume() {
        super.onResume();
        nextAnimation();
    }

}
