package com.example.first.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//继承AppCompatActivity的话无法使用requestWindowFeature(Window.FEATURE_NO_TITLE)

public class MainActivity extends Activity {
    Button login,exit;
    EditText user,password;
    TextView result;
    ImageView show,pre,next;
    CheckBox merge;
    TextView tvpos,tvwrite;
    MoveView move;
    long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置取消标题
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置满屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.btLogin);
        exit = (Button)findViewById(R.id.btExit);
        user = (EditText)findViewById(R.id.etUser);
        password = (EditText)findViewById(R.id.etPassword);
        result = (TextView)findViewById(R.id.tvResult);
        show = (ImageView)findViewById(R.id.ivShow);
        merge = (CheckBox)findViewById(R.id.cbMerge);
        pre = (ImageView)findViewById(R.id.ivPre);
        next = (ImageView)findViewById(R.id.ivNext);
        tvpos = (TextView)findViewById(R.id.tvPos);
        tvwrite = (TextView)findViewById(R.id.tvWrite);
        move = (MoveView)findViewById(R.id.moveView1);

        login.setEnabled(false);
        //设置图片,复选框和文字不可见
        show.setVisibility(View.INVISIBLE);
        merge.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        pre.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(user.getText().toString() != "")
                {
                    login.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //login按钮监听事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(user.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                    result.setVisibility(View.INVISIBLE);
                    show.setVisibility(View.VISIBLE);
                    merge.setVisibility(View.VISIBLE);
                    pre.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);
                }
                else
                {
                    show.setVisibility(View.INVISIBLE);
                    result.setVisibility(View.INVISIBLE);
                    result.setVisibility(View.VISIBLE);
                    merge.setVisibility(View.INVISIBLE);
                    pre.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.INVISIBLE);

                }
            }
        });

        //exit按钮监听事件
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RadioGroupActivity.class);
                startActivity(intent);
            }
        });

        //merge复选款监听事件
        merge.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if( b == true )
                {
                    show.setImageResource(R.drawable.pc3);
                    next.setVisibility(View.INVISIBLE);
                    pre.setVisibility(View.INVISIBLE);
                }
                else
                {
                    show.setImageResource(R.drawable.pc1);
                    next.setVisibility(View.VISIBLE);
                    pre.setVisibility(View.INVISIBLE);
                }
            }
        });

        //next监听事件
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show.setImageResource(R.drawable.pc2);
                next.setVisibility(View.INVISIBLE);
                pre.setVisibility(View.VISIBLE);
            }
        });

        //pre监听事件
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show.setImageResource(R.drawable.pc1);
                pre.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
            }
        });

        //user,password设置键盘事件
        user.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String writeStr;
                writeStr = "正在输入帐号...";
                tvwrite.setText(writeStr);
                return false;
            }
        });

        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String writeStr;
                writeStr = "正在输入密码...";
                tvwrite.setText(writeStr);
                return false;
            }
        });
    }

    //重写onKeyDown方法实现双击返回键退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            if((System.currentTimeMillis() - time) >1000 )
            {
                Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                time = System.currentTimeMillis();
            }
            else
            {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){

        String posStr = "当前坐标为：";
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            float xPos = event.getX();
            float yPos = event.getY();
            posStr = posStr + "（" + xPos + "," + yPos + ")";
            tvpos.setText(posStr);
            //利用MoveView类的set方法将两个坐标传给MoveView类的X,Y变量
            move.setX((int)xPos);
            move.setY((int)yPos);
            //重新呈现，自动调用onDraw方法
            move.invalidate();
        }else if (event.getAction() == MotionEvent.ACTION_DOWN){
            tvpos.setBackgroundColor(Color.BLUE);
        }
        return super.onTouchEvent(event);
    }

}
