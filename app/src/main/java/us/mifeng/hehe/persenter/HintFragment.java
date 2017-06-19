package us.mifeng.hehe.persenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by shido on 2017/6/14.
 */

public interface HintFragment {
    void hintFragment(FragmentManager fm, Fragment fragment ,String str);
    void getData();
}
