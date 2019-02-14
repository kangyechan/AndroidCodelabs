package com.walab.hamang.donutapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    String menu[] = {"치킨", "피자", "소고기", "박달대게"};
    boolean checked[] = {true, true, false, false};
    int selectedIndex = 3;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn1:
                showDialog1();
                break;
            case R.id.btn2:
                showDialog2();
                break;
            case R.id.btn3:
                showDialog3();
                break;
            case R.id.btn4:
                showDialog4();
                break;
        }
    }

    public void showDialog1(){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본대화상자")
                .setMessage("기본대화상자 입니다.")
                .setIcon(R.drawable.ic_launcher_foreground)
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        displayToast("CANCEL Clicked");
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        displayToast("OK Clicked");
                    }
                }).show();
    }

    public void showDialog2(){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본대화상자")
//                .setMessage("기본대화상자 입니다.")
                .setSingleChoiceItems(menu, selectedIndex, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selectedIndex = i;
                    }
                })
                .setIcon(R.drawable.ic_launcher_foreground)
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        displayToast("CANCEL Clicked");
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        displayToast(menu[selectedIndex]+"(을)를 선택했습니다.");
                    }
                }).show();
    }

    public void showDialog3(){

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본대화상자")
//                .setMessage("기본대화상자 입니다.")
                .setMultiChoiceItems(menu, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        // boolean array를 true로 바꿔주기
                        checked[i] = b;
                    }
                })
                .setIcon(R.drawable.ic_launcher_foreground)
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        displayToast("CANCEL Clicked");
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 뭐가 체크되어있는지
                        String str = "";
                        for(int j = 0; j< checked.length; j++)
                            if(checked[j]) str += menu[j] + ",";
                        displayToast(str + "(을)를 선택했습니다.");
                    }
                }).show();
    }

    public void showDialog4(){
        View dlgView = View.inflate(this, R.layout.dialog, null);

        et = dlgView.findViewById(R.id.etName);

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본대화상자")
                .setView(dlgView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        displayToast("이름은 " + et.getText().toString()+" 입니다.");
                    }
                }).show();
    }

    public void displayToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
