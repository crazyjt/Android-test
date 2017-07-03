package com.example.first.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.*;
import android.widget.EditText;

/**
 * Created by 钧童 on 2017/7/3.
 */

public class ContextMenu extends Activity {
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contextmenu);

        editText=(EditText)findViewById(R.id.etContextMenu);

        //将控件绑定到上下文菜单中
        registerForContextMenu(editText);
    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu, menu);
//        menu.add(Menu.NONE, 0, 0, "AAA");
//        menu.add(Menu.NONE, 1, 1, "BBB");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:

                break;
            case R.id.item2:
                finish();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
