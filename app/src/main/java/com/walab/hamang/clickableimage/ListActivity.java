package com.walab.hamang.clickableimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayList<String> fruit = new ArrayList<>();
    EditText e1;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        adapter =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruit);

        e1 = findViewById(R.id.edit1);

        fruit.add("Banana");
        fruit.add("Apple");
        fruit.add("Grape");

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String one = fruit.get(position);
                Toast.makeText(ListActivity.this, one, Toast.LENGTH_SHORT).show();

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // 데이터 삭제
                fruit.remove(position);

                // 어댑터에 통보
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    public void onAdd(View view) {
        // edit 에서 입력한 정보 가져오기
        String one = e1.getText().toString();

        // fruit에 추가하기
        fruit.add(one);

        // 어댑터에 업데이트 요청하기
        adapter.notifyDataSetChanged();
    }
}
