package com.example.doitvoca;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText editID;
    private EditText editPW;
    private EditText editNickname;
    private Button Complete_button;
    FirebaseAuth firebaseAuth;

    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        액션바
        getSupportActionBar().setTitle("회원가입");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editID = (EditText) findViewById(R.id.ID);
        editPW = (EditText) findViewById(R.id.PW);
        editNickname = (EditText) findViewById(R.id.Nickname);
        Complete_button = (Button) findViewById(R.id.Complete_button);

        firebaseAuth = FirebaseAuth.getInstance();

        Complete_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String ID = editID.getText().toString().trim();
                String PW = editPW.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(ID,PW)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else{
                                    Toast.makeText(SignUpActivity.this,"등록 에러",Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
            }
        });


    }

}
