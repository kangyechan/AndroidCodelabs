package com.walab.hamang.androidcodelab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class CafeActivity extends AppCompatActivity implements View.OnClickListener{
    TextView menu1;
    TextView menu2;
    TextView menu3;
    CheckBox checkCard;
    public int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        init();
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

        Log.d("TEST", "CafeActivity- oncreate()");
    }

    @Override
    public void onClick(View view) {
        total = (Integer.parseInt(menu1.getText().toString()) * 1000) + (Integer.parseInt(menu2.getText().toString()) * 1500) + (Integer.parseInt(menu3.getText().toString()) * 1700);
        if(checkCard.isChecked()) total = total * 90 / 100;
        Toast toast = Toast.makeText(this, Integer.toString(total), Toast.LENGTH_SHORT);
        toast.show();
    }

    public void init() {
        menu1 = (TextView) findViewById(R.id.editMenu1);
        menu2 = (TextView) findViewById(R.id.editMenu2);
        menu3 = (TextView) findViewById(R.id.editMenu3);
        checkCard = (CheckBox) findViewById(R.id.card);

    }
}
