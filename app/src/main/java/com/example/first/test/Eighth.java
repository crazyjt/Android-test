package com.example.first.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by 钧童 on 2017/6/28.
 */

public class Eighth extends Activity {
    Gallery gallery;
    int[] dataPic = {
            R.drawable.pc1,
            R.drawable.pc2,
            R.drawable.pc3,
            R.drawable.eason,
            R.drawable.lin,
            R.drawable.wang,
            R.drawable.xiao,
            R.drawable.xue,
            R.drawable.zhang,
            R.drawable.zhou
    };

    @Override
    protected void onCreate(Bundle savedStanceState){
        super.onCreate(savedStanceState);
        setContentView(R.layout.eighth);

        gallery = (Gallery)findViewById(R.id.galleryPic);

        gallery.setAdapter(new MyAdapter());


    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return dataPic.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View viewItem;
            viewItem = convertView;
            ImageView ivItem;
            Wrapper wrapper;
            if(viewItem == null){
                viewItem = LayoutInflater.from(Eighth.this).inflate(R.layout.eighthchild,parent,false);
                wrapper = new Wrapper(viewItem);
                viewItem.setTag(wrapper);
            }
            else {
                wrapper = (Wrapper) viewItem.getTag();
            }
            ivItem = wrapper.getIvItem();
            ivItem.setImageResource(dataPic[position]);
            return viewItem;
        }
    }
    class Wrapper{
        ImageView ivItem;
        View viewItem;
        public Wrapper(View viewItem){
            this.viewItem = viewItem;
        }
        public ImageView getIvItem(){
            if(ivItem == null){
                ivItem = (ImageView) viewItem.findViewById(R.id.imageView3);
            }
            return ivItem;
        }
    }
}
