package com.walab.hamang.androidcodelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondMsgActivity extends AppCompatActivity {

    EditText secondSendMsg;
    TextView secondTvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_msg);

        setTitle("Second Activities");
        init();
    }

    public void init() {
        secondSendMsg = findViewById(R.id.etReplyMsg);
        secondTvMsg = findViewById(R.id.msgSpace);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("sendMsg");
        secondTvMsg.setText(msg);
    }

    public void Reply(View view) {
        Intent intent = new Intent(this, FirstMsgActivity.class);
        intent.putExtra("replyMsg", secondSendMsg.getText().toString());

        setResult(RESULT_OK, intent);

        finish();

    }

}
