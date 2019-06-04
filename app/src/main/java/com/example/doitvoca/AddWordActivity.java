package com.example.doitvoca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddWordActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    private EditText englishField;
    private EditText meaningField;
    private Button AddWord_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        //        액션바
        getSupportActionBar().setTitle("내 단어추가");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        englishField = findViewById(R.id.EnglishInput);
        meaningField = findViewById(R.id.MeaningInput);
        AddWord_button = findViewById(R.id.AddWord_button);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        AddWord_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                final String EnglishInput = englishField.getText().toString();
                final String MeaningInput = meaningField.getText().toString();

                if(TextUtils.isEmpty(EnglishInput) || TextUtils.isEmpty(MeaningInput)) {
                    englishField.setError("REQUIRED");
                    return;
                }
                MyWord myword = new MyWord(EnglishInput,MeaningInput);
                mDatabase.child("wordlist").push().setValue(myword);
                Toast.makeText(getApplicationContext(), "단어를 저장하였습니다.",Toast.LENGTH_LONG).show();

            }
        });

    }

}
