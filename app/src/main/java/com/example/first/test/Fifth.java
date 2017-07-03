package com.example.first.test;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 钧童 on 2017/6/23.
 */

public class Fifth extends Activity {
    ListView lvBaseAdapter;
    List<String> datasource = new ArrayList<>();
    List<String> datasource2 = new ArrayList<>();
    List<Drawable> datasource1 = new ArrayList<>();
    //SimpleAdapter中的数据源必须为List<Map<,>>类型
    List<Map<String, String>> data = new ArrayList<Map<String, String>>();
    EditText etaddSinger,etaddSong;
    Button btnadd;

    @Override
    protected  void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth);

        lvBaseAdapter = (ListView)findViewById(R.id.lvBaseAdapater);
        etaddSinger = (EditText)findViewById(R.id.etAddSinger);
        etaddSong = (EditText)findViewById(R.id.etAddSongCOunt);
        btnadd = (Button)findViewById(R.id.btnAdd);
        //将歌手名数据取得，并作为字符串数组
        String[] arry = getResources().getStringArray(R.array.baseAdapterSinger);
        //将字符串数组中的每个元素加入数据源datasource中
        for(int i = 0; i < arry.length; i++){
            datasource.add(arry[i]);
        }
        //将歌曲数量数据取得，并作为字符串数组
        String[] arry1 = getResources().getStringArray(R.array.baseAdapterSongCount);
        for(int i = 0; i < arry1.length; i++){
            datasource2.add(arry1[i]);
        }
        //fill();

        datasource1.add(getResources().getDrawable(R.drawable.eason));
        datasource1.add(getResources().getDrawable(R.drawable.lin));
        datasource1.add(getResources().getDrawable(R.drawable.xue));
        datasource1.add(getResources().getDrawable(R.drawable.wang));
        datasource1.add(getResources().getDrawable(R.drawable.xiao));
        datasource1.add(getResources().getDrawable(R.drawable.zhang));
        datasource1.add(getResources().getDrawable(R.drawable.zhou));

        final SimpleAdapter adapter = new SimpleAdapter(
                this,  //上下文
                data,  //数据源,必须为List<Map<,>>类型
                R.layout.fifthchild,    //项布局id
                new String[]{"name","count"},   //从哪些字段String[]
                new int[]{R.id.tvSingerName,R.id.tvSongCount}   //显示数据的控件id   int[]
                );


        //添加数据并且刷新Adapter
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView test = (TextView)findViewById(R.id.tvTest);
                String addsinger = etaddSinger.getText().toString();
                String addsong = etaddSong.getText().toString();
                datasource.add(addsinger);
                datasource2.add(addsong);
                Map<String, String> map = new HashMap<String, String>();
                map.put("name", addsinger);
                map.put("count", addsong);
                data.add(map);
                //通知adapter内容更新
                lvBaseAdapter.setAdapter(adapter);
            }
        });

        lvBaseAdapter.setAdapter(new MyAdapter());
 //       lvBaseAdapter.setAdapter(adapter);
    }

    void fill(){
        Map<String, String> map;
        for(int i = 0; i < datasource.size(); i++){
            map = new HashMap<>();
            //将歌手姓名逐个加入map中
            map.put("name",datasource.get(i));
            //将歌曲数量逐个加入map中
            map.put("count",datasource2.get(i));
            data.add(map);
        }
    }

    class MyAdapter extends BaseAdapter{
        //项的个数,控制循环次数
        @Override
        public int getCount() {
            return datasource.size();
        }
        //返回该项
        @Override
        public Object getItem(int position) {
            return position;
        }
        //返回项id
        @Override
        public long getItemId(int position) {
            return position;
        }
        //返回该项的view
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /*
            //在本activity中加入一个新的TextView用于显示数据
            TextView tv = new TextView(Fifth.this);
            tv.setText(datasource.get(position));
            */
            Wrapper wrapper = null;
            View view = convertView;
            //判断当前的view（即convertView）是否加载过,如果加载过就不再解析，减少内存消耗
            if(view == null){
                //布局文件解析为View
                //下面两句等同于View view = LayoutInflater.from(Fifth.this).inflate(R.layout.fifthchild,parent,false);
                LayoutInflater layoutInflater = getLayoutInflater();
                view= layoutInflater.inflate(R.layout.fifthchild,parent,false);
                //如果View不存在，则需要初始化wrapper并且将其设置为view的tag属性
                //view只能有一个tag属性，该属性可以是任何数据的值
                wrapper = new Wrapper(view);
                view.setTag(wrapper);
            }
            else {
                //如果view存在，则直接通过view的tag属性获得wrapper
                wrapper = (Wrapper) view.getTag();
            }
            //在View中寻找控件
            //TextView tv = (TextView)view.findViewById(R.id.tvSingerName);
            //将上面这句改为优化后的方法
            TextView tv = wrapper.getTv();
            tv.setText(datasource.get(position));
            //ImageView iv = (ImageView)view.findViewById(R.id.ivSinger);
            //将上面这句改为优化后的方法
            ImageView iv = wrapper.getIv();
            iv.setImageDrawable(datasource1.get(position));

            return  view;
        }
    }

    //Wrapper类用于优化findViewById()的消耗资源问题
    class Wrapper{
        TextView tv;
        ImageView iv;
        View view;
        //利用构造函数获得MyAdapter中的view
        public Wrapper(View view){
            this.view = view;
        }

        public TextView getTv(){
            if(tv == null)
                tv = (TextView) view.findViewById(R.id.tvSingerName);
            return tv;
        }

        public ImageView getIv(){
            if(iv == null)
                iv = (ImageView) view.findViewById(R.id.ivSinger);
            return iv;
        }
    }
}
