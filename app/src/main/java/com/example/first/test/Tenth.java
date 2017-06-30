package com.example.first.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

/**
 * Created by 钧童 on 2017/6/29.
 */

public class Tenth extends Activity {
    TabHost tabHost;
    Button btnClock;
    @Override
    protected void onCreate(Bundle savedStanceState){
        super.onCreate(savedStanceState);
        setContentView(R.layout.tenth);

        tabHost = (TabHost)findViewById(R.id.tabhost);
        btnClock = (Button)findViewById(R.id.btnClock);

        //当TabHost不是继承于TabActivity时必须调用setup()方法
        tabHost.setup();

        //定义选项卡
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab1");
        //选项卡上的便签(选项卡按钮内容)
        tabSpec1.setIndicator("Calendar");
        //选项卡的内容
        tabSpec1.setContent(R.id.tab1);
        //在TabHost上添加选项卡
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2");
        //便签为系统内部图片
        tabSpec2.setIndicator("",getResources().getDrawable(android.R.drawable.ic_input_add));
        tabSpec2.setContent(R.id.tab2);
        tabHost.addTab(tabSpec2);

        btnClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3");
                //便签为系统内部图片
                tabSpec3.setIndicator("Clock");
                //实现TabHost.TabContentFactory()接口来提供新的视图view
                tabSpec3.setContent(new TabHost.TabContentFactory() {
                    @Override
                    public View createTabContent(String tag) {
                        View view;
                        view = LayoutInflater.from(Tenth.this).inflate(R.layout.tenchild,null);
                        return view;
                    }
                });
                tabHost.addTab(tabSpec3);
            }
        });
    }
}
