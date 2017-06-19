package us.mifeng.hehe.fragment;

import android.view.View;
import android.widget.TextView;

import us.mifeng.hehe.base.BaseFragment;

/**
 * Created by shido on 2017/6/14.
 */

public class QiTaFragment extends BaseFragment {
    @Override
    public View initView() {
        TextView textView = new TextView(getActivity());
        textView.setText("我是其他");
        return textView;
    }

    @Override
    public void initData() {

    }
}
