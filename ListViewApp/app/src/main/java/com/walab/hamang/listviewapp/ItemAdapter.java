package com.walab.hamang.listviewapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    ArrayList<Fruit> fruit;
    Context c;

    ItemAdapter(Context c, ArrayList<Fruit> fruit) {
        this.c = c;
        this.fruit = fruit;
    }

    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Object getItem(int i) {
        return fruit.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 1. 뷰를 만든다
        if (view == null) view = View.inflate(c, R.layout.list_item, null); // 화면에 차지않은 view 공간이 있을시

        // 2. 데이터를 ㅁ변경한다.
        TextView tv = view.findViewById(R.id.item_view);
        ImageView iv = view.findViewById(R.id.item_img);
        tv.setText(fruit.get(i).getName());
        iv.setImageResource(fruit.get(i).getImageId());

        // 3. 뷰를 리턴한다.
        return view;
    }
}
