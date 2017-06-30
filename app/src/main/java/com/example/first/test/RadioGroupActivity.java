package com.example.first.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

/**
 * Created by 钧童 on 2017/2/21.
 */

public class RadioGroupActivity extends Activity {
    RadioGroup rg1,rg2;
    Button sure,reset,next;
    ImageView iv;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        rg1 = (RadioGroup)findViewById(R.id.rg1);
        rg2 = (RadioGroup)findViewById(R.id.rg2);
        sure = (Button)findViewById(R.id.btSure);
        reset = (Button)findViewById(R.id.btReset);
        next = (Button)findViewById(R.id.btnNextPage);
        iv = (ImageView)findViewById(R.id.ivResult);

        //设置图片不可见
        iv.setVisibility(View.INVISIBLE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RadioGroupActivity.this,Third.class);
                startActivity(intent);
            }
        });

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckedChangeListener listener = new CheckedChangeListener();
                rg1.setOnCheckedChangeListener(listener);
                rg2.setOnCheckedChangeListener(listener);
                iv.setVisibility(View.VISIBLE);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setVisibility(View.INVISIBLE);
                //重置为选择第一项
                rg1.check(R.id.rbAmplification);
                rg2.check(R.id.rbPc1);
            }
        });
    }
    //内部类，用于对RadioGroup进行统一的监听
    class CheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (radioGroup.getId()){
            case R.id.rg1:
                if(i == R.id.rbAmplification) {
                    iv.setMaxHeight(100);
                    iv.setMaxWidth(100);
                    //或者是setFrame()
                }
                else{
                    iv.setMaxHeight(10);
                    iv.setMaxWidth(10);
                }
            break;
            case R.id.rg2:
                switch (i)
                {
                    case R.id.rbPc1:
                        iv.setImageResource(R.drawable.pc1);
                        break;
                    case R.id.rbPc2:
                        iv.setImageResource(R.drawable.pc2);
                        break;
                    case R.id.rbPc3:
                        iv.setImageResource(R.drawable.pc3);
                        break;
                }
            break;
            }

        }
    }
}
