package com.example.doitvoca;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //단어검색 실행 함수
    public void startSearch(View view) {
        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(intent);
    }

    //단어장 실행 함수
    public void startVoca(View view) {
        Intent intent = new Intent(getApplicationContext(), WordListActivity.class);
        startActivity(intent);
    }

    //퀴즈실행 함수
    public void startQuiz(View view) {
        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(intent);
    }

    //환경설정 실행 함수
    public void startSetting(View view) {
        Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
        startActivity(intent);
    }

}
