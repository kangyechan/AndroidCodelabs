package com.walab.hamang.androidcodelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    EditText name, massage;
    TextView fourmassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setTitle("첫번째 엑티비티");

        init();
    }

    public void onClick2(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void onClick3(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("name", name.getText().toString());
        startActivity(intent);
    }

    public void onClick4(View view) {
        Intent intent = new Intent(this, FourthActivity.class);
        intent.putExtra("msg",massage.getText().toString());
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100){
            if(resultCode == RESULT_OK) {
                String msg2 = data.getStringExtra("fourmsg");
                fourmassage.setText(msg2);
            }
        }
    }

    public void init() {
        name = findViewById(R.id.intentEditText);
        massage = findViewById(R.id.fourEditText);
        fourmassage = findViewById(R.id.fourMsg);

    }
}
