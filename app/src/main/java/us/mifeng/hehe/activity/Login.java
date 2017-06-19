package us.mifeng.hehe.activity;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import us.mifeng.hehe.R;
import us.mifeng.hehe.adapter.VPAdapter;
import us.mifeng.hehe.base.BaseActivity;


/**
 * Created by shido on 2017/6/14.
 */

public class Login extends BaseActivity {
    private List<ImageView> list;
    private int ss [] = {
      R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher
    };

    private ViewPager mVp;
    private VPAdapter vp;
    private LinearLayout ll_time;
    private TextView time;
    private int index = 3;
    boolean xx=true;
    @Override
    public void initView() {
        setContentView(R.layout.login);
        mVp = (ViewPager) findViewById(R.id.mVp);
        ll_time = (LinearLayout) findViewById(R.id.ll_time);
        time = (TextView) findViewById(R.id.time);
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position==3){
                    ll_time.setVisibility(View.VISIBLE);
                    time.setText(index+"");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    while (xx){
                                        try {
                                            Thread.sleep(1000);
                                            handler.sendEmptyMessage(100);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }).start();
                        }
                    });
                }else {
                    ll_time.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        vp = new VPAdapter(Login.this,list);
        mVp.setAdapter(vp);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==100){
                index--;
                time.setText(index+"");
                if (index==0){
                    xx=false;
                    ll_time.setVisibility(View.GONE);
                    startActivity(new Intent(Login.this, DengLu.class));
                }
            }
        }
    };

    @Override
    public void initList() {
        list = new ArrayList<>();
       for (int i = 0;i<ss.length;i++){
           ImageView imageView = new ImageView(Login.this);
           imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
           imageView.setScaleType(ImageView.ScaleType.FIT_XY);
           imageView.setImageResource(ss[i]);
           list.add(imageView);
       }
    }
}
