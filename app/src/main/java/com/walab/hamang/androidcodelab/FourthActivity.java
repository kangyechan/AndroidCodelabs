package com.walab.hamang.androidcodelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    TextView massage;
    EditText secondMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        setTitle("네번째 엑티비티");

        init();

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        massage.setText(msg);
    }

    public void back(View view) {
        finish();
    }

    public void onClicknBack(View view) {
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra("fourmsg", secondMessage.getText().toString());

        setResult(RESULT_OK, intent); // OK라는 신호로 intent에 보냄

        finish();
    }

    public void init() {
        massage = findViewById(R.id.fourContent);
        secondMessage = findViewById(R.id.secondContent);
    }
}
