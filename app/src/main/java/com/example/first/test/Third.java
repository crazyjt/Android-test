package com.example.first.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 钧童 on 2017/6/22.
 */

public class Third extends Activity {
    EditText etCount;
    Button show,nextPage;
    LinearLayout third;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        etCount = (EditText)findViewById(R.id.etCount);
        show = (Button)findViewById(R.id.btnShow);
        nextPage = (Button)findViewById(R.id.thirdNextPage);
        third = (LinearLayout) findViewById(R.id.layoutThird);

        etCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                for(int i = third.getChildCount(); i >= 2; i--){
                    third.removeView(third.getChildAt(i));
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //读取etCount中输入的内容
                    int count = Integer.parseInt(etCount.getText().toString());
                    for(int i = 0; i < count; i++){
                        // 解析出相应view
                        LayoutInflater inflater = getLayoutInflater();
                        View view = inflater.inflate(R.layout.third_child,null);
                        String temp = "第" + (i+1) + "张：";
                        TextView textView = (TextView) view.findViewById(R.id.tvDescription);
                        textView.setText(temp);
                        third.addView(view);
                    }
                }
                catch(Exception ex){
                    etCount.setText("");
                    //获取焦点
                    etCount.requestFocus();
                }
            }
        });

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Third.this,Fourth.class);
                startActivity(intent);
            }
        });
    }
}
