package com.example.doitvoca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    //환경설정 실행 함수
    public void confirmSetting(View view) {
        Toast.makeText(getApplication(),"회원정보가 수정되었습니다.",Toast.LENGTH_LONG).show();
    }

    //메인메뉴로 이동
    public void returnTop(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
