package com.example.first.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * Created by 钧童 on 2017/6/27.
 */

public class Seventh extends Activity {
    String[] datasource = {"AAA","BBB","CCC","DDD","EEE","FFF","GGG","HHH","III","JJJ"};
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedStanceState){
        super.onCreate(savedStanceState);
        setContentView(R.layout.seventh);

        gridView = (GridView)findViewById(R.id.gvTest);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.seventhchild,R.id.textView,datasource);

        gridView.setAdapter(adapter);
    }
}
