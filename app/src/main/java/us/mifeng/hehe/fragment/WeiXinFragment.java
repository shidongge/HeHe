package us.mifeng.hehe.fragment;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import us.mifeng.hehe.base.BaseFragment;

/**
 * Created by shido on 2017/6/14.
 */

public class WeiXinFragment extends BaseFragment{
    @Override
    public View initView() {
        TextView textView = new TextView(getActivity());
        textView.setText("我是微信");
        return textView;
    }

    @Override
    public void initData() {

    }
}
