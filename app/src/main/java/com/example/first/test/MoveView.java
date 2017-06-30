package com.example.first.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 钧童 on 2017/2/23.
 */
    //此类用于在xml中添加控件
public class MoveView extends View {
    Bitmap bmp = null;
    private int X = 250;
    private int Y = 800;
    public MoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.heart);
    }

    //当VIew呈现时自动调用
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bmp,X-bmp.getWidth()/2,Y-bmp.getHeight()/2,null);
        super.onDraw(canvas);
    }

    public void setY(int y) {
        Y = y;
    }

    public void setX(int x) {
        X = x;
    }
}
