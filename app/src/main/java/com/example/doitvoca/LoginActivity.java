package com.example.doitvoca;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText loginID;
    private EditText loginPW;
    private Button Login_button;



    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginID = (EditText) findViewById(R.id.loginID);
        loginPW = (EditText) findViewById(R.id.loginPW);
        Login_button = (Button) findViewById(R.id.Login_button);
        mAuth = FirebaseAuth.getInstance();

        //회원가입 activity로 전환
        Button Signup_button = (Button) findViewById(R.id.Signup_button);
        Signup_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);

            }
        });

        Login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String ID = loginID.getText().toString().trim();
                String PW = loginPW.getText().toString().trim();

                if (ID.getBytes().length <= 0||PW.getBytes().length <= 0 ) {
                    Toast.makeText(LoginActivity.this,"이메일 또는 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else{

                    mAuth.signInWithEmailAndPassword(ID, PW)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // 로그인 성공하면 로그찍고 메인 activitiy로 넘어감
                                        Log.d("TAG","signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        //Log.w("signInWithEmail:failure", task.getException());
                                        Toast.makeText(LoginActivity.this,"이메일 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                                        //updateUI(null);
                                    }

                                    // ...
                                }
                            });
                }




            }
        });

    }


}
