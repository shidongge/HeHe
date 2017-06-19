package us.mifeng.hehe.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import us.mifeng.hehe.R;
import us.mifeng.hehe.base.BaseActivity;

/**
 * Created by shido on 2017/6/14.
 */

public class DengLu extends BaseActivity {
    private EditText pass,user;
    private Button mBtn;

    @Override
    public void initView() {
        setContentView(R.layout.denglu);
        pass = (EditText) findViewById(R.id.pass);
        user = (EditText) findViewById(R.id.user);
        mBtn = (Button) findViewById(R.id.denglu_mBtn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = pass.getText().toString();
                String userword = user.getText().toString();
                if (password.equals("")||userword.equals("")){
                    Toast.makeText(DengLu.this, "账号过密码不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(DengLu.this,MainActivity.class));
                }
            }
        });
    }

    @Override
    public void initList() {

    }
}
