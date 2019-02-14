package com.walab.hamang.listviewapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fruit> fruit = new ArrayList<>();
//    ArrayAdapter<String> adapter;
    ItemAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initListView();
    }

    private void initListView() {
//        1. Data를 만든다
//        wordList.add("banana");
//        wordList.add("pineapple");
//        wordList.add("grape");

        fruit.add(new Fruit(R.drawable.apple, "Apple"));
        fruit.add(new Fruit(R.drawable.pineapple, "PineApple"));
        fruit.add(new Fruit(R.drawable.banana, "Banana"));

//        fruit.addFruit("apple", R.drawable.apple);
//        fruit.addFruit("pineapple", R.drawable.pineapple);

//        2. 어댑터를 만든다 (컨택스트, 어떤 뷰를 쓸것인지, 어떤 데이터를 쓸것인지 정해줘야함.)
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wordList);
        adapter = new ItemAdapter(this, fruit);

//        3. 어댑터를 리스트뷰에 연결한다.
        lv = findViewById(R.id.wordlist);
        lv.setAdapter(adapter);

//        4. 이벤트는 연결한다.
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                displayToast(fruit.get(i).getName());
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                delDialog(i);
                return true;
            }
        });
    }

    public void displayToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void delDialog(final int position) {
        String title = fruit.get(position).getName();
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("리스트 삭제")
                .setMessage(title + " (을)를 정말 삭제하시겠습니까?")
                .setNegativeButton("아니오",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        displayToast("취소하였습니다.");
                    }
                })
                .setPositiveButton("네",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        displayToast("삭제되었습니다.");
                        fruit.remove(position); // 다른 클래스의 position을 사용해야하기 때문에 위 변수가 final로 변경됨.
                        adapter.notifyDataSetChanged(); // 어댑터에 알림
                    }
                }).show();
    }

}
