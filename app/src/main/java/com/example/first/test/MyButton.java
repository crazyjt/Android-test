package com.example.first.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by 钧童 on 2017/6/30.
 */
//继承现有控件
public class MyButton extends Button {

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                setScaleX(0.5f);
                setScaleY(0.5f);
                break;
            case MotionEvent.ACTION_UP:
                setScaleX(1f);
                setScaleY(1f);
                break;
        }
        return super.onTouchEvent(event);
    }
}
