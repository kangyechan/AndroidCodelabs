package com.walab.hamang.usernavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout t1, t2, t3;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b1:
                setDisplayTab(1);
                break;
            case R.id.b2:
                setDisplayTab(2);
                break;
            case R.id.b3:
                setDisplayTab(3);
                break;
        }
    }

    public void setDisplayTab(int num) {
        t1.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE);
        t3.setVisibility(View.INVISIBLE);
        if(num == 1) t1.setVisibility(View.VISIBLE);
        if(num == 2) t2.setVisibility(View.VISIBLE);
        if(num == 3) t3.setVisibility(View.VISIBLE);
    }

    public void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        t1 = findViewById(R.id.content1);
        t2 = findViewById(R.id.content2);
        t3 = findViewById(R.id.content3);
    }
}
