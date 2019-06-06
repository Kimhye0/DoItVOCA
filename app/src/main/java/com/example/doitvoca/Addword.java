package com.example.doitvoca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addword extends AppCompatActivity {
    private DatabaseReference mDatabase;

    private EditText englishField;
    private EditText meaningField;
    private Button AddWord_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addword);
        /*//        액션바
        getSupportActionBar().setTitle("단어추가");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        englishField = findViewById(R.id.EnglishInput);
        meaningField = findViewById(R.id.MeaningInput);
        AddWord_button = findViewById(R.id.AddWord_button);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        AddWord_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Word word = new Word();
                word.EnglishInput = englishField.getText().toString();
                word.MeaningInput = meaningField.getText().toString();
                if(TextUtils.isEmpty(word.EnglishInput) || TextUtils.isEmpty(word.MeaningInput)) {
                    englishField.setError("REQUIRED");
                    return;
                }
                mDatabase.child("wordlist").push().setValue(word);
                Toast.makeText(getApplicationContext(), "단어를 저장하였습니다.", Toast.LENGTH_LONG).show();
                //단어추가하고 단어장으로 가도록 수정..
                Intent intent = new Intent(getApplicationContext(), WordListActivity.class);
                startActivity(intent);

            }
        });

    }
    public void returnTop(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
