package com.example.first.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 钧童 on 2017/6/28.
 */

public class Ninth extends Activity {
    ProgressBar progressBar;
    SeekBar seekBar;
    TextView tv1,tv2;
    Button button;
    int i = 0;
    //定义timer定时器
    Timer timer = new Timer();
    //定义子线程用于修改进度值并且发送消息,每次定时触发所做的任务
    //Android不允许在子线程中修改界面，所以需要用handler进行消息传递，让主线程完成修改
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            if(i < 100) {
                i++;
                //发送消息，通知主线程修改界面
                handler.sendEmptyMessage(0X001);
            }
            else {
                handler.sendEmptyMessage(0X002);
            }
        }
    };

    //定义Handler进行消息传递和接受
    Handler handler = new Handler(){
        public void handleMessage(android.os.Message message){
            switch (message.what){
                case 0X001:
                    tv1.setText(i + "");
                    progressBar.setProgress(i);
                    break;
                case 0X002:
                    //删除定时器任务和定时器
                    timerTask.cancel();
                    timer.cancel();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedStanceState){
        super.onCreate(savedStanceState);
        setContentView(R.layout.ninth);

        progressBar =(ProgressBar)findViewById(R.id.progressBar);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        tv1 = (TextView)findViewById(R.id.tvProgressBar);
        tv2 = (TextView)findViewById(R.id.tvSeekBar);
        button = (Button)findViewById(R.id.btnProgress);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //用schedule方法触发，100表示每隔0.1s触发一次，延迟为0
                timer.schedule(timerTask,0,100);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //移动滑块时的操作：
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //等同于tv2.setText(progress);
                tv2.setText(seekBar.getProgress() + "");
            }
            //开始移动滑块的操作：
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            //停止移动滑块的操作：
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
