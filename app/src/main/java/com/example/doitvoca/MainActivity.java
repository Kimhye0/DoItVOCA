package com.example.doitvoca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//안드로이드의 화면이 Activity
//MainActivity가 AppCompatActivity를 상속함
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

        Button MyWordPage = (Button) findViewById(R.id.AddWordbtn);
        MyWordPage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,AddWordActivity.class);
                startActivity(intent);

            }
        });

    }


}
