package com.example.first.test;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by 钧童 on 2017/6/30.
 */
//继承包含若干子控件的布局
public class Login extends LinearLayout {
    EditText etUserName,etUserPassword;
    Button btnLogin;
    public Login(Context context) {
        super(context);
        init(context);
    }

    public Login(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Login(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    //自定义初始化函数,将xml实例化，并且查找内部控件
    public void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.login,this,true);
        etUserName = (EditText)view.findViewById(R.id.etUerName);
        etUserPassword = (EditText)view.findViewById(R.id.etUerPassword);
        btnLogin = (Button)view.findViewById(R.id.btnLogin);
    }

    public String getUserName(){
        return etUserName.getText() + "";
    }
    public String getUserPassword(){
        return etUserPassword.getText() + "";
    }

    //重写setOnClickListener，用于监听按钮的事件而不是监听整个布局
    public void setOnClickListener(View.OnClickListener listener){
        btnLogin.setOnClickListener(listener);
    }
}
