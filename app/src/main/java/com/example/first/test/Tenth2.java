package com.example.first.test;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by 钧童 on 2017/6/30.
 */

public class Tenth2 extends TabActivity {
    @Override
    protected void onCreate(Bundle savedStanceState){
        super.onCreate(savedStanceState);
        setContentView(R.layout.tenth2);
        //继承与TabActivity可以直接用getTabHost()获得
        TabHost tabHost = getTabHost();

        //定义选项卡
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab1");
        //选项卡上的便签(选项卡按钮内容)
        tabSpec1.setIndicator("tab1");
        //选项卡的内容
        tabSpec1.setContent(R.id.tab1);
        //在TabHost上添加选项卡
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2");
        tabSpec2.setIndicator("tab2");
        tabSpec2.setContent(R.id.tab2);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3");
        tabSpec3.setIndicator("tab3");
        tabSpec3.setContent(R.id.tab3);
        tabHost.addTab(tabSpec3);
    }
}
