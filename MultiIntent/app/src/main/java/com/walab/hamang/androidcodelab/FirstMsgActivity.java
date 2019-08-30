package com.walab.hamang.androidcodelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstMsgActivity extends AppCompatActivity {

    EditText firstSendMsg;
    TextView firstTvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_msg);

        setTitle("Two Activities");
        init();
    }

    public void init() {
        firstSendMsg = findViewById(R.id.etSendMsg);
        firstTvMsg = findViewById(R.id.msgSpace);
    }

    public void Send(View view) {
        Intent intent = new Intent(this, SecondMsgActivity.class);
        intent.putExtra("sendMsg", firstSendMsg.getText().toString());
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100){
            if(resultCode == RESULT_OK) {
                String reply = data.getStringExtra("replyMsg");
                firstTvMsg.setText(reply);
            }
        }
    }
}
