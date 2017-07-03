package com.example.first.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 钧童 on 2017/7/1.
 */

public class Call_Login extends Activity {
    Login login;
    TextView tv1,tv2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_login);

        login = (Login)findViewById(R.id.myLogin);
        tv1 = (TextView)findViewById(R.id.textView2);
        tv2 = (TextView)findViewById(R.id.textView3);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(login.getUserName());
                tv2.setText(login.getUserPassword());
            }
        });
    }
}
