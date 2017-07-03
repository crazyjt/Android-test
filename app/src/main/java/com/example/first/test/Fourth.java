package com.example.first.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 钧童 on 2017/6/22.
 */

public class Fourth extends Activity {
    String[] singers = {"陈奕迅","林俊杰","薛之谦"};
    ListView listView;
    TextView tvChoose;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);
        listView = (ListView)findViewById(R.id.lvPic);
        tvChoose = (TextView)findViewById(R.id.tvChoose);
        next = (Button)findViewById(R.id.fourthNextPage);

        ArrayAdapter<String> adapters = new ArrayAdapter<String>(
                                            this,       //上下文
                                            R.layout.fourthchild,       //每一项的布局
                                            R.id.tvSinger,        //显示数据的控件id
                                            singers     //数据源
                                            );
        listView.setAdapter(adapters);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //parent是所点控件（指ListView），view是所点击的项，position是所点击项索引，id是项的id
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvChoose.setText(singers[position]);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fourth.this,Fifth.class);
                startActivity(intent);
            }
        });
    }
}
