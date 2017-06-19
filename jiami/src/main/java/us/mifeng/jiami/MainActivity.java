package us.mifeng.jiami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        String str = "name = zhangsan&pass=1234566";
        String s = MD5JiaMi.md5(str);
        Log.e(TAG, "initData: "+s );
    }
}
