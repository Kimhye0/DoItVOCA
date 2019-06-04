package com.example.sample_result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void startQuiz(View view) {

        int quizCategory = 0;  // All

        switch (view.getId()) {
            case R.id.menu_voca:
                quizCategory = 1;
                break;
            case R.id.menu_quiz:
                quizCategory = 2;
                break;
            case R.id.menu_search:
                quizCategory = 3;
                break;
        }

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("QUIZ_CATEGORY", quizCategory);
        startActivity(intent);

    }
}
