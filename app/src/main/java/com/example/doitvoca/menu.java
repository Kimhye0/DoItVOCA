package com.example.doitvoca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.menu_setting).setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.menu_setting:
                    Log.d("OnClickListener", "click session button");
                    // 액티비티 실행
                    Intent intentSubActivity =
                            new Intent(menu.this, setting.class);
                    startActivity(intentSubActivity);
                    break;
            }
        }
    };
}
