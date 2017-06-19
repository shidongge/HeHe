package us.mifeng.hehe.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import us.mifeng.hehe.R;
import us.mifeng.hehe.base.BaseActivity;
import us.mifeng.hehe.fragment.HomeFragment;
import us.mifeng.hehe.fragment.QiTaFragment;
import us.mifeng.hehe.fragment.WeiXinFragment;
import us.mifeng.hehe.persenter.HintFragment;

public class MainActivity extends BaseActivity implements HintFragment{
    private LinearLayout ll_shouye,ll_weixin,ll_qita;
    private String ss[] = {"shouye","weixin","qita"};
    private FragmentManager fm;
    private HomeFragment homeFragment;
    private WeiXinFragment weiXinFragment;
    private QiTaFragment qiTaFragment;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        ll_qita = (LinearLayout) findViewById(R.id.ll_qita);
        ll_shouye = (LinearLayout) findViewById(R.id.ll_shouyye);
        ll_weixin = (LinearLayout) findViewById(R.id.ll_weixin);
        getData();
    }

    @Override
    public void initList() {

    }

    @Override
    public void hintFragment(FragmentManager fm, Fragment fragment, String str) {
        FragmentTransaction ft = fm.beginTransaction();
        for (String tag:ss) {
            if (!tag.equals(str)){
                Fragment fragmentByTag = fm.findFragmentByTag(tag);
                if (fragmentByTag!=null){
                    ft.hide(fragmentByTag);
                }
            }
        }
        if (fm.findFragmentByTag(str)==null){
            ft.add(R.id.ll_shang,fragment,str);
        }
        ft.show(fragment);
        ft.commit();
    }

    @Override
    public void getData() {
        fm = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        weiXinFragment = new WeiXinFragment();
        qiTaFragment = new QiTaFragment();
        ll_shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintFragment(fm,homeFragment,"shouye");
            }
        });
        ll_weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintFragment(fm,weiXinFragment,"weixin");
            }
        });
        ll_qita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintFragment(fm,qiTaFragment,"qita");
            }
        });
    }
}
