package com.example.doitvoca;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//로그인 성공시 메인으로 넘어가는 것 보여주기 위해 만든 페이지 !!

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Signup_button = (Button) findViewById(R.id.Signup_button);
        Signup_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);

            }
        });

    }
// 토스트 메세지 띄우기
    public void onButton1Clicked(View v) {
        Toast.makeText(getApplicationContext(), "버튼이 눌렸어요.",Toast.LENGTH_LONG).show();
    }
// 버튼 클릭 이벤트
    public void onButton2Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://alldic.daum.net/"));
        startActivity(intent);
    }

}
