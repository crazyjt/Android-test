package com.example.first.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;

/**
 * Created by 钧童 on 2017/7/2.
 */

public class Menu extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        //方法一：覆写Activity的onCreateOptionsMenu()方法，该方法在Activity创建时就被调用
//        menu.add(android.view.Menu.NONE, 0, 0, "AAA");
//        menu.add(android.view.Menu.NONE, 1, 1, "BBB");

        //方法二：实例化菜单的xml并放入menu实例
 //       MenuInflater menuInflater = new MenuInflater(this);
        //将R.menu.main所定义的主菜单的xml文件添加到参数menu中
 //       menuInflater.inflate(R.menu.main, menu);

        //添加次级菜单的方法一：在menu的xml文件中添加二级menu，然后用解析菜单的方法将菜单解析

        //添加次级菜单的方法二：用addSubMenu(主菜单)创建二级菜单之后，再用二级菜单.add()添加二级菜单
        SubMenu subMenu = menu.addSubMenu(android.view.Menu.NONE, 0, 0, "主菜单");
        //组1
        subMenu.add(1, 0, 0, "二级菜单一");
        subMenu.add(1, 1, 1, "二级菜单二");
        //组2
        subMenu.add(2, 2, 2, "二级菜单三");
        subMenu.add(2, 3, 3, "二级菜单四");
        subMenu.add(2, 4, 4, "二级菜单五");
        //设置组1不可点击
        subMenu.setGroupEnabled(1,false);

        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //利用item.getItemId()判断选中是哪个选项
        switch (item.getItemId()){
            case R.id.groupitem1:
                if(item.isChecked() == false){
                    item.setChecked(true);
                }
                else item.setChecked(false);
                break;
            case R.id.groupitem2:
                if(item.isChecked() == false){
                    item.setChecked(true);
                }
                else item.setChecked(false);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(android.view.Menu menu) {
        //利用findItem()查找选项
        MenuItem menuItem = menu.findItem(2);
        if(menuItem != null){
            //从menu中删除指定选项
            menu.removeItem(2);
            //向menu中添加指定选项
            menu.add(android.view.Menu.NONE, 2, 2, "CCC");
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
