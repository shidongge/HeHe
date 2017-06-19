package us.mifeng.hehe.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by shido on 2017/6/14.
 */

public abstract class BaseActivity extends FragmentActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initList();
        initView();

    }
    public abstract void initView();
    public abstract void initList();
}
