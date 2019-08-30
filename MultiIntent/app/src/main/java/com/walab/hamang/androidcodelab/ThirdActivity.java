package com.walab.hamang.androidcodelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        init();
    }

    public void onClick(View view) {
        finish();
    }

    public void init() {
        name = findViewById(R.id.thirdTitle);
        Intent intent = getIntent();
        String  fName= intent.getStringExtra("name");
        name.setText(fName);
    }
}
