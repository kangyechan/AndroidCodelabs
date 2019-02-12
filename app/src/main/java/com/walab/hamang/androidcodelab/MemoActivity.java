package com.walab.hamang.androidcodelab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity implements View.OnClickListener{

    Button m1, m2, m3, save, reset;
    EditText mTitle, mContent;
    Memo memo[] = new Memo[3];
    int selectedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        init();
    }

    public void init() {
        m1 = findViewById(R.id.b1);
        m2 = findViewById(R.id.b2);
        m3 = findViewById(R.id.b3);
        save = findViewById(R.id.bSave1);
        reset = findViewById(R.id.bReset);
        mTitle = findViewById(R.id.memotitle);
        mContent = findViewById(R.id.memocontent);
        for( int i = 0; i < memo.length; i++ ) memo[i] = new Memo();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.b1) {
            selectedIndex = 0;
            getMemo();
        } else if (view.getId() == R.id.b2) {
            selectedIndex = 1;
            getMemo();
        } else if (view.getId() == R.id.b3) {
            selectedIndex = 2;
            getMemo();
        } else if (view.getId() == R.id.bSave1) {
            memoSave(selectedIndex);
        } else {
            memoReset(selectedIndex);
            getMemo();
        }
    }

    public void memoReset(int index) {
        memo[index].setMemo("","");
    }

    public void memoSave(int index) {
        memo[index].setTitle(mTitle.getText().toString());
        memo[index].setContent(mContent.getText().toString());
        Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
    }

    public void getMemo() {
        mTitle.setText(memo[selectedIndex].getTitle());
        mContent.setText(memo[selectedIndex].getContent());
    }

    public void saveChange(int index) {
     
    }
}
